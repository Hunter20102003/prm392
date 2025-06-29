package com.example.prm392.entity;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
@Entity(tableName = "cart_items",
        foreignKeys = {
                @ForeignKey(entity = ShoppingCart.class,
                        parentColumns = "cart_id",
                        childColumns = "cart_id",
                        onDelete = ForeignKey.CASCADE),
                @ForeignKey(entity = Product.class,
                        parentColumns = "product_id",
                        childColumns = "product_id")
        }, indices = {
        @Index(value = {"cart_id"}),@Index(value={"product_id"})
})
public class CartItem {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "cart_item_id")
    private Integer cartItemId;

    @ColumnInfo(name = "cart_id")
    @NonNull
    private Integer cartId;

    @ColumnInfo(name = "product_id")
    @NonNull
    private Integer productId;

    @ColumnInfo(name = "quantity")
    private Integer quantity = 1;

    public CartItem() {
    }



    public Integer getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(Integer cartItemId) {
        this.cartItemId = cartItemId;
    }

    @NonNull
    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(@NonNull Integer cartId) {
        this.cartId = cartId;
    }

    @NonNull
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(@NonNull Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
