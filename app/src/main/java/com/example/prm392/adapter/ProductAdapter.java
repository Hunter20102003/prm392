package com.example.prm392.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.prm392.R;
import com.example.prm392.entity.Product;
import com.example.prm392.entity.ProductImage;
import com.example.prm392.entity.relation.ProductWithProductImages;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder> {
    private List<ProductWithProductImages> products;
    private Context context;

    public ProductAdapter(Context context, List<ProductWithProductImages> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = products.get(position).product;
        holder.textName.setText(product.getName());
        holder.textPrice.setText(String.format("%,.0f đ", product.getNewPrice()));

        // Load ảnh từ link online
        List<ProductImage> images = products.get(position).productImages;
        if (images != null && !images.isEmpty()) {
            Log.d("DEBUG_IMAGE_URL", images.toString());
            String imageUrl = images.get(0).getImageUrl();
            Glide.with(context)
                    .load(imageUrl)
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.error_image)
                    .into(holder.imageProduct);
        } else {
            // nếu không có ảnh thì gán ảnh mặc định
            holder.imageProduct.setImageResource(R.drawable.ic_launcher_foreground);
        }

        holder.btnAddToCart.setOnClickListener(v -> {
            Toast.makeText(context, "Chưa hỗ trợ giỏ hàng!", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}

