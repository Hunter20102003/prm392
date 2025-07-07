package com.example.prm392.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;

import com.example.prm392.R;
import com.example.prm392.entity.ProductImage;
import com.example.prm392.entity.relation.ProductWithProductImages;


import java.util.List;

public class SuggestProductAdapter extends RecyclerView.Adapter<SuggestProductAdapter.ProductViewHolder> {

    private Context context;
    private List<ProductWithProductImages> productList;

    public SuggestProductAdapter(Context context, List<ProductWithProductImages> list) {
        this.context = context;
        this.productList = list;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_suggest_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        ProductWithProductImages item = productList.get(position);

        holder.txtName.setText(item.product.getName());

        holder.txtPrice.setText(String.valueOf(item.product.getNewPrice()) + " đ");
        // Load ảnh từ link online
        List<ProductImage> images = productList.get(position).productImages;
        if (images != null && !images.isEmpty()) {
            Log.d("DEBUG_IMAGE_URL", images.toString());
            String imageUrl = images.get(0).getImageUrl();
            Glide.with(context)
                    .load(imageUrl)
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.error_image)
                    .into(holder.img);
        } else {
            // nếu không có ảnh thì gán ảnh mặc định
            holder.img.setImageResource(R.drawable.ic_launcher_foreground);
        }


    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView txtName,txtPrice;
        ImageView img;

        ImageButton btnAddToCart;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.textName);
            txtPrice = itemView.findViewById(R.id.textPrice);
            img = itemView.findViewById(R.id.imageProduct);
            btnAddToCart = itemView.findViewById(R.id.btnAddToCart);

        }
    }
}
