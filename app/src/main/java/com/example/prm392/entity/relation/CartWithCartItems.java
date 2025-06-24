package com.example.prm392.entity.relation;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.prm392.entity.CartItem;
import com.example.prm392.entity.ShoppingCart;

import java.util.List;

public class CartWithCartItems {
    @Embedded
    ShoppingCart shoppingCart;
    @Relation(
            parentColumn = "cart_id",
            entityColumn = "cart_id"
    )
    List<CartItem> cartItems;
}
