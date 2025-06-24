package com.example.prm392.entity.relation;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.prm392.entity.CartItem;
import com.example.prm392.entity.Product;

public class CartItemWithProduct {
    @Embedded public CartItem cartItem;
    @Relation(parentColumn = "product_id", entityColumn = "product_id")
    public Product product;
}
