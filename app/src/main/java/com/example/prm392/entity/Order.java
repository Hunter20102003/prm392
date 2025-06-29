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
    private Integer orderId;

    @ColumnInfo(name = "user_id")
    @NonNull
    private Integer userId;

    @ColumnInfo(name = "order_date")
    private String orderDate;

    @ColumnInfo(name = "total_price")
    private Double totalPrice;

    @ColumnInfo(name = "total_amount")
    @NonNull
    private double totalAmount;

    @ColumnInfo(name = "status")
    private OrderStatus orderStatus=OrderStatus.PENDING;

    @ColumnInfo(name = "shipping_address")
    @NonNull
    private String shippingAddress;

    @ColumnInfo(name = "payment_method")
    @NonNull
    private PaymentMethod paymentMethod=PaymentMethod.WALLET;

    @ColumnInfo(name = "payment_status")
    private PaymentStatus paymentStatus=PaymentStatus.PAID;

    @ColumnInfo(name = "notes")
    private String notes;

    public Order() {
    }


    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @NonNull
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(@NonNull Integer userId) {
        this.userId = userId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @NonNull
    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(@NonNull String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    @NonNull
    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(@NonNull PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }
    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
