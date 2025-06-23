package com.example.prm392.entity;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import com.example.prm392.enums.*;

@Entity(tableName = "products",
        foreignKeys = @ForeignKey(entity = Category.class,
                parentColumns = "category_id",
                childColumns = "category_id")
        ,
        indices = {
                @Index(value = {"category_id"})
        })

public class Product {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "product_id")
    public int productId;

    @ColumnInfo(name = "name")
    @NonNull
    public String name;

    @ColumnInfo(name = "title")
    @NonNull
    public String title;

    @ColumnInfo(name = "description")
    public String description;

    @ColumnInfo(name = "old_price")
    public double oldPrice;

    @ColumnInfo(name = "new_price")
    @NonNull
    public double newPrice;

    @ColumnInfo(name = "category_id")
    @NonNull
    public int categoryId;

    @ColumnInfo(name = "stock_quantity")
    public int stockQuantity = 0;

    @ColumnInfo(name = "weight")
    public String weight;

    @ColumnInfo(name = "dimensions")
    public String dimensions;

    @ColumnInfo(name = "created_at")
    public String createdAt;

    @ColumnInfo(name = "updated_at")
    public String updatedAt;

    @ColumnInfo(name = "status")
    @NonNull
    public ProductStatus status = ProductStatus.AVAILABLE;
}
