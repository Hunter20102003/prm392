package com.example.prm392.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.example.prm392.enums.UserRole;

import java.time.LocalDateTime;

@Entity(tableName = "users")
public class User {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    private Integer userId;

    @ColumnInfo(name = "email")
    @NonNull
    private String email;

    @ColumnInfo(name = "password")
    @NonNull
    private String password;

    @ColumnInfo(name = "full_name")
    @NonNull
    private String fullName;

    @ColumnInfo(name = "phone")
    private String phone;

    @ColumnInfo(name = "image_url")
    private String imageUrl;

    @ColumnInfo(name = "role")
    private UserRole role = UserRole.USER;

    @ColumnInfo(name = "created_at")
    private LocalDateTime createdAt;

    @ColumnInfo(name = "updated_at")
    private LocalDateTime updatedAt;

    @ColumnInfo(name = "is_active")
    private Boolean isActive = true;

    public User() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    @NonNull
    public String getFullName() {
        return fullName;
    }

    public void setFullName(@NonNull String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
