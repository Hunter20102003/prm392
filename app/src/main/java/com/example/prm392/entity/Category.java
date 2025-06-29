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
    private Integer categoryId;

    @ColumnInfo(name = "name")
    @NonNull
    private String name;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "image_url")
    private String imageUrl;

    public Category() {
    }



    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


}