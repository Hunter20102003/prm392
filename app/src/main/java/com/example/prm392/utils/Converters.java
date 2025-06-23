package com.example.prm392.utils;

import androidx.room.TypeConverter;

import com.example.prm392.enums.OrderStatus;
import com.example.prm392.enums.PaymentMethod;
import com.example.prm392.enums.PaymentStatus;
import com.example.prm392.enums.ProductStatus;
import com.example.prm392.enums.TransactionType;
import com.example.prm392.enums.UserRole;

public class Converters {
    //user role
    @TypeConverter
    public static String fromUserRole(UserRole role) {
        return role == null ? null : role.toString();
    }

    @TypeConverter
    public static UserRole toUserRole(String value) {
        return value == null ? null : UserRole.valueOf(value);
    }
    //product status
    @TypeConverter
    public static String fromProductStatus(ProductStatus status) {
        return status == null ? null : status.toString();
    }
    @TypeConverter
    public static ProductStatus toProductStatus(String value) {
        return value == null ? null : ProductStatus.valueOf(value);
    }
    //Order status
    @TypeConverter
    public static String fromOrderStatus(OrderStatus status) {
        return status == null ? null : status.toString();
    }

    @TypeConverter
    public static OrderStatus toOrderStatus(String value) {
        return value == null ? null : OrderStatus.valueOf(value);
    }
    //Payment method
    @TypeConverter
    public static String fromPaymentMethod(PaymentMethod method) {
        return method == null ? null : method.toString();
    }
    @TypeConverter
    public static PaymentMethod toPaymentMethod(String value) {
        return value == null ? null : PaymentMethod.valueOf(value);
    }
//Payment status
    @TypeConverter
    public static String fromPaymentStatus(PaymentStatus status) {
        return status == null ? null : status.toString();
    }
    @TypeConverter
    public static PaymentStatus toPaymentStatus(String value) {
        return value == null ? null : PaymentStatus.valueOf(value);
    }
// Transaction type
    @TypeConverter
    public static String fromTransactionType(TransactionType type) {
        return type == null ? null : type.toString();
    }
    @TypeConverter
    public static TransactionType toTransactionType(String value) {
        return value == null ? null : TransactionType.valueOf(value);
    }

}
