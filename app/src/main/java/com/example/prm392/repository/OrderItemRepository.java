package com.example.prm392.repository;

import android.content.Context;

import com.example.prm392.dao.OrderItemDAO;
import com.example.prm392.dao.room.AppDatabase;

public class OrderItemRepository {
    private final OrderItemDAO orderItemDAO;
    public OrderItemRepository(Context context) {
        AppDatabase orderItemRoomDatabase = AppDatabase.getInstance(context);
        orderItemDAO = orderItemRoomDatabase.orderItemDao();
    }
    public Integer countOrderItemsByProductId(Integer productId) {
        return orderItemDAO.countOrderItemsByProductId(productId);
    }

}
