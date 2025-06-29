package com.example.prm392.entity.relation;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.prm392.entity.Category;
import com.example.prm392.entity.Product;

import java.util.List;

public class CategoryWithProducts {
    @Embedded
    public Category category;
    @Relation(
            parentColumn = "category_id",
            entityColumn = "category_id"
    )
    public List<Product> products;
}
