package com.example.prm392.entity.relation;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.prm392.entity.Review;
import com.example.prm392.entity.User;

public class ReviewWithUser {
    @Embedded
    public Review review;
    @Relation(parentColumn = "user_id", entityColumn = "user_id")
    public User user;
}
