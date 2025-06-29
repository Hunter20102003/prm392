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
    private Integer orderItemId;

    @ColumnInfo(name = "order_id")
    @NonNull
    public Integer orderId;

    @ColumnInfo(name = "product_id")
    @NonNull
    public Integer productId;

    @ColumnInfo(name = "quantity")
    @NonNull
    public Integer quantity;

    @ColumnInfo(name = "unit_price")
    @NonNull
    public Double unitPrice;

    @ColumnInfo(name = "total_price")
    @NonNull
    public Double totalPrice;

    public OrderItem() {
    }



    public Integer getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }

    @NonNull
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(@NonNull Integer orderId) {
        this.orderId = orderId;
    }

    @NonNull
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(@NonNull Integer productId) {
        this.productId = productId;
    }

    @NonNull
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(@NonNull Integer quantity) {
        this.quantity = quantity;
    }

    @NonNull
    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(@NonNull Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @NonNull
    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(@NonNull Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}