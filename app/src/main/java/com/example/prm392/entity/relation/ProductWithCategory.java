package com.example.prm392.entity.relation;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.prm392.entity.Category;
import com.example.prm392.entity.Product;

public class ProductWithCategory {
    @Embedded
    public Product product;
    @Relation(
            parentColumn = "category_id",
            entityColumn = "category_id"
    )
    public Category category;
}
