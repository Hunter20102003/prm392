package com.example.prm392.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "categories")

public class Category {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "category_id")
    public int categoryId;

    @ColumnInfo(name = "name")
    @NonNull
    public String name;

    @ColumnInfo(name = "description")
    public String description;

    @ColumnInfo(name = "image_url")
    public String imageUrl;

    @ColumnInfo(name = "created_at")
    public String createdAt;

    @ColumnInfo(name = "updated_at")
    public String updatedAt;
}