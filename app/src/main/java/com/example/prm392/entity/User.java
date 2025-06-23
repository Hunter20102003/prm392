package com.example.prm392.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.example.prm392.enums.UserRole;

@Entity(tableName = "users")
public class User {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    public int userId;

    @ColumnInfo(name = "email")
    @NonNull
    public String email;

    @ColumnInfo(name = "password")
    @NonNull
    public String password;

    @ColumnInfo(name = "full_name")
    @NonNull
    public String fullName;

    @ColumnInfo(name = "phone")
    public String phone;

    @ColumnInfo(name = "address")
    public String address;

    @ColumnInfo(name = "image_url")
    public String imageUrl;

    @ColumnInfo(name = "role")
    public UserRole role = UserRole.USER;

    @ColumnInfo(name = "created_at")
    public String createdAt;

    @ColumnInfo(name = "updated_at")
    public String updatedAt;

    @ColumnInfo(name = "is_active")
    public boolean isActive = true;
}
