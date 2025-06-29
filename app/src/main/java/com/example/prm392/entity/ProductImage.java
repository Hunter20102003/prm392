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
    private Integer imageId;

    @ColumnInfo(name = "product_id")
    @NonNull
    private Integer productId;

    @ColumnInfo(name = "image_url")
    @NonNull
    private String imageUrl;

    @ColumnInfo(name = "is_primary")
    private Boolean isPrimary = false;

    public ProductImage() {
    }


    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    @NonNull
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(@NonNull Integer productId) {
        this.productId = productId;
    }

    @NonNull
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(@NonNull String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getPrimary() {
        return isPrimary;
    }

    public void setPrimary(Boolean primary) {
        isPrimary = primary;
    }
}
