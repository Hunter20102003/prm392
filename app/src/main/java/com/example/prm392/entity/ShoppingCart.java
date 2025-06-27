package com.example.prm392.entity;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "shopping_cart",
        foreignKeys = @ForeignKey(entity = User.class,
                parentColumns = "user_id",
                childColumns = "user_id"),indices = {
        @Index(value = {"user_id"})
})
public class ShoppingCart {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "cart_id")
    private Integer cartId;

    @ColumnInfo(name = "user_id")
    @NonNull
    private Integer userId;


    public ShoppingCart() {
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    @NonNull
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(@NonNull Integer userId) {
        this.userId = userId;
    }


}