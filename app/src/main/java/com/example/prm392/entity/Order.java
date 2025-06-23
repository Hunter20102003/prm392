package com.example.prm392.entity;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.example.prm392.enums.OrderStatus;
import com.example.prm392.enums.PaymentMethod;
import com.example.prm392.enums.PaymentStatus;

@Entity(tableName = "orders",
        foreignKeys = @ForeignKey(entity = User.class,
                parentColumns = "user_id",
                childColumns = "user_id"),indices = {@Index(value = "user_id")})
public class Order {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "order_id")
    public int orderId;

    @ColumnInfo(name = "user_id")
    @NonNull
    public int userId;

    @ColumnInfo(name = "order_date")
    public String orderDate;

    @ColumnInfo(name = "total_price")
    public Double totalPrice;

    @ColumnInfo(name = "total_amount")
    @NonNull
    public double totalAmount;

    @ColumnInfo(name = "status")
    public OrderStatus orderStatus=OrderStatus.PENDING;

    @ColumnInfo(name = "shipping_address")
    @NonNull
    public String shippingAddress;

    @ColumnInfo(name = "payment_method")
    @NonNull
    public PaymentMethod paymentMethod=PaymentMethod.WALLET;

    @ColumnInfo(name = "payment_status")
    public PaymentStatus paymentStatus=PaymentStatus.PAID;

    @ColumnInfo(name = "notes")
    public String notes;
}
