package com.example.prm392.entity;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
@Entity(tableName = "product_images",
        foreignKeys = @ForeignKey(entity = Product.class,
                parentColumns = "product_id",
                childColumns = "product_id"),
        indices = {
                @Index(value = {"product_id"})
        })
public class ProductImage {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "image_id")
    public int imageId;

    @ColumnInfo(name = "product_id")
    @NonNull
    public int productId;

    @ColumnInfo(name = "image_url")
    @NonNull
    public String imageUrl;

    @ColumnInfo(name = "is_primary")
    public boolean isPrimary = false;
}
