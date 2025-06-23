package com.example.prm392.entity;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "order_items",
        foreignKeys = {
                @ForeignKey(entity = Order.class,
                        parentColumns = "order_id",
                        childColumns = "order_id",
                        onDelete = ForeignKey.CASCADE),
                @ForeignKey(entity = Product.class,
                        parentColumns = "product_id",
                        childColumns = "product_id")
        }, indices = {
        @Index(value = {"order_id"}),@Index(value={"product_id"})
})
public class OrderItem {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "order_item_id")
    public int orderItemId;

    @ColumnInfo(name = "order_id")
    @NonNull
    public int orderId;

    @ColumnInfo(name = "product_id")
    @NonNull
    public int productId;

    @ColumnInfo(name = "quantity")
    @NonNull
    public int quantity;

    @ColumnInfo(name = "unit_price")
    @NonNull
    public double unitPrice;

    @ColumnInfo(name = "total_price")
    @NonNull
    public double totalPrice;
}