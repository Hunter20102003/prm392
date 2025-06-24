package com.example.prm392.entity.relation;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.prm392.entity.User;
import com.example.prm392.entity.Wallet;

public class UserWithWallet {
    @Embedded
    public User user;
    @Relation(parentColumn = "user_id", entityColumn = "user_id")
    public Wallet wallet;
}
