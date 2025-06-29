package com.example.prm392.utils;

import androidx.room.TypeConverter;

import com.example.prm392.bean.ProvinceBean;
import com.example.prm392.entity.Province;
import com.example.prm392.enums.OrderStatus;
import com.example.prm392.enums.PaymentMethod;
import com.example.prm392.enums.PaymentStatus;
import com.example.prm392.enums.ProductStatus;
import com.example.prm392.enums.TransactionType;
import com.example.prm392.enums.UserRole;


import java.time.LocalDate;
import java.time.LocalDateTime;

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
    //date
    @TypeConverter
    public static String fromDate(LocalDate date) {
        return date == null ? null : date.toString();
    }
    @TypeConverter
    public static LocalDate toDate(String value) {
        return value == null ? null : LocalDate.parse(value);
}
    //datetime
        @TypeConverter
    public static String fromDateTime(LocalDateTime dateTime) {
        return dateTime == null ? null : dateTime.toString();
    }
    @TypeConverter
    public static LocalDateTime toDateTime(String value) {
        return value == null ? null : LocalDateTime.parse(value);
    }


}
