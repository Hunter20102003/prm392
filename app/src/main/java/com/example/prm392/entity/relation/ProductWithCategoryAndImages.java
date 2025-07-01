package com.example.prm392.entity.relation;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.prm392.entity.Category;
import com.example.prm392.entity.Product;
import com.example.prm392.entity.ProductImage;

import java.util.List;

public class ProductWithCategoryAndImages {
    @Embedded
    public Product product;
    @Relation(
            parentColumn = "category_id",
            entityColumn = "category_id"
    )
    public Category category;
    @Relation(
            parentColumn = "product_id",
            entityColumn = "product_id"
    )
    public List<ProductImage> productImages;
}
