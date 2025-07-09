package com.example.prm392.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.prm392.R;
import com.example.prm392.bean.CartItemBean;
import com.example.prm392.listener.CartItemListener;

import java.util.List;

public class CartItemAdapter extends RecyclerView.Adapter<CartItemAdapter.CartViewHolder> {
    private List<CartItemBean> itemBeanList;
    private CartItemListener listener;

    public CartItemAdapter(List<CartItemBean> itemBeanList, CartItemListener listener) {
        this.itemBeanList = itemBeanList;
        this.listener = listener;
    }

    public List<CartItemBean> getItemList() {
        return itemBeanList;
    }

    public class CartViewHolder extends RecyclerView.ViewHolder {
        private CheckBox checkBoxItem;
        private ImageView imgProduct;
        private TextView tvProductName;
        private TextView tvProductPrice;
        private Button btnDecrease;
        private Button btnIncrease;
        private TextView tvQuantity;
        private Button btnDelete;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBoxItem = itemView.findViewById(R.id.checkboxItem);
            imgProduct = itemView.findViewById(R.id.imgProduct);
            tvProductName = itemView.findViewById(R.id.tvProductName);
            tvProductPrice = itemView.findViewById(R.id.tvProductPrice);
            btnDecrease = itemView.findViewById(R.id.btnDecrease);
            btnIncrease = itemView.findViewById(R.id.btnIncrease);
            tvQuantity = itemView.findViewById(R.id.tvQuantity);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        CartItemBean itemBean = itemBeanList.get(position);

        holder.tvProductName.setText(itemBean.getProduct().getName());
        holder.tvProductPrice.setText(String.valueOf(itemBean.getProduct().getNewPrice()));
        holder.tvQuantity.setText(String.valueOf(itemBean.getQuantity()));
        holder.checkBoxItem.setOnCheckedChangeListener(null);  // Ngắt liên kết tạm trước khi set lại trạng thái
        holder.checkBoxItem.setChecked(itemBean.isChecked());

        String imgUrl = itemBean.getProduct().getProductImageList().stream()
                .filter(img -> img.getPrimary())
                .map(img -> img.getImageUrl())
                .findFirst()
                .orElse(null);

        if (imgUrl != null) {
            Glide.with(holder.imgProduct.getContext()).load(imgUrl).into(holder.imgProduct);
        } else {
            holder.imgProduct.setImageResource(R.drawable.product_default);
        }

        holder.btnIncrease.setOnClickListener(v -> {
            int newQuantity = itemBean.getQuantity() + 1;
            itemBean.setQuantity(newQuantity);
            notifyItemChanged(holder.getAdapterPosition());
            listener.onQuantityChanged(itemBean, newQuantity);
        });

        holder.btnDecrease.setOnClickListener(v -> {
            int newQuantity = itemBean.getQuantity();
            if (newQuantity > 1) {
                newQuantity--;
                itemBean.setQuantity(newQuantity);
                notifyItemChanged(holder.getAdapterPosition());
                listener.onQuantityChanged(itemBean, newQuantity);
            }
        });

        holder.checkBoxItem.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (holder.getAdapterPosition() != RecyclerView.NO_POSITION) {
                itemBean.setChecked(isChecked);
                listener.onItemCheckedChanged(itemBean, isChecked);
            }
        });

        holder.btnDelete.setOnClickListener(v -> {
            listener.onItemDeleted(itemBean);
        });
    }

    @Override
    public int getItemCount() {
        return itemBeanList.size();
    }
}
