package com.example.prm392.adapter;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prm392.R;

public class ProductViewHolder extends RecyclerView.ViewHolder {
    ImageView imageProduct;
    TextView textName, textPrice;
    ImageButton btnAddToCart;

    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);
        imageProduct = itemView.findViewById(R.id.imageProduct);
        textName = itemView.findViewById(R.id.textName);
        textPrice = itemView.findViewById(R.id.textPrice);
        btnAddToCart = itemView.findViewById(R.id.btnAddToCart);
    }
}

