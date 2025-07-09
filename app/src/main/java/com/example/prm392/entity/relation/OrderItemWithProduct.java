package com.example.prm392.entity.relation;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.prm392.entity.OrderItem;
import com.example.prm392.entity.Product;

import java.util.List;

public class OrderItemWithProduct {
    @Embedded
    public OrderItem orderItem;
    @Relation(
            parentColumn = "product_id",
            entityColumn = "product_id")
    public Product product;
}
