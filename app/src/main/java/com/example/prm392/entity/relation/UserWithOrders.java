package com.example.prm392.entity.relation;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.prm392.entity.Order;
import com.example.prm392.entity.User;

import java.util.List;

public class UserWithOrders {
    @Embedded
    public User user;
    @Relation(parentColumn="user_id",entityColumn="user_id")
    public List<Order> orders;

}
