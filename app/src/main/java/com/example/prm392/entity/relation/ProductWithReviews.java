package com.example.prm392.entity.relation;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.prm392.entity.Product;
import com.example.prm392.entity.Review;

import java.util.List;

public class ProductWithReviews {
    @Embedded public Product product;
    @Relation(parentColumn = "product_id", entityColumn = "product_id")
    public List<Review> reviews;
}
