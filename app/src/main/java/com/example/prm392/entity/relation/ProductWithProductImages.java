package com.example.prm392.entity.relation;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.prm392.entity.Product;
import com.example.prm392.entity.ProductImage;

import java.util.List;

public class ProductWithProductImages {
    @Embedded
    public Product product;
    @Relation(
            parentColumn = "product_id",
            entityColumn = "product_id"
    )
    public List<ProductImage> productImages;
}
