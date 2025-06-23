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
    public int cartItemId;

    @ColumnInfo(name = "cart_id")
    @NonNull
    public int cartId;

    @ColumnInfo(name = "product_id")
    @NonNull
    public int productId;

    @ColumnInfo(name = "quantity")
    public int quantity = 1;

    @ColumnInfo(name = "added_at")
    public String addedAt;
}
