package com.example.prm392.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.prm392.bean.CartItemBean;
import com.example.prm392.entity.CartItem;
import com.example.prm392.entity.relation.CartItemWithProduct;
import com.example.prm392.entity.relation.CartWithCartItems;

import java.util.List;

@Dao
public interface CartItemDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(CartItem cartItem);

    @Query("SELECT SUM(quantity) FROM cart_items WHERE cart_id = :cartId")
    Integer countCartItemsByCartId(int cartId);

    @Query("SELECT quantity FROM cart_items WHERE cart_id = :cartId AND product_id = :productId")
    Integer countCartItemByCartIdAndProductId(int cartId, int productId);

    @Query("SELECT * FROM cart_items WHERE cart_id = :cartId and product_id=:productId")
    CartItem getCartItemByCartIdAndProductId(int cartId, int productId);

    @Update
    void updateCartItem(CartItem cartItem);

    @Transaction
    @Query("SELECT * FROM shopping_cart WHERE cart_id = :cartId")
    CartWithCartItems getCartItemsByCartId(int cartId);

    @Transaction
    @Query("SELECT * FROM cart_items WHERE product_id = :productId")
    CartItemWithProduct getCartItemWithProduct(int productId);

    @Query("DELETE FROM cart_items WHERE cart_item_id = :id")
    int deleteCartItemByID(int id);

    @Query("UPDATE cart_items SET quantity = quantity + 1 WHERE cart_item_id = :cartItemId")
    int increaseCartItemQuantity(int cartItemId);

    @Query("UPDATE cart_items SET quantity = quantity - 1 WHERE cart_item_id = :cartItemId")
    int decreaseCartItemQuantity(int cartItemId);
}
