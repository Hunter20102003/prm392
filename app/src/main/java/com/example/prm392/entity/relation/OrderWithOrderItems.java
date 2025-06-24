package com.example.prm392.entity.relation;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.prm392.entity.Order;
import com.example.prm392.entity.OrderItem;

import java.util.List;

public class OrderWithOrderItems {
    @Embedded
    public Order order;
    @Relation(
            parentColumn = "order_id",
            entityColumn = "order_id")
    public List<OrderItem> orderItems;

}
