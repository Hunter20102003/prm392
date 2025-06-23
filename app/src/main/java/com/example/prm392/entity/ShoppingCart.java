package com.example.prm392.entity;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "shopping_cart",
        foreignKeys = @ForeignKey(entity = User.class,
                parentColumns = "user_id",
                childColumns = "user_id"),indices = {
        @Index(value = {"user_id"})
})
public class ShoppingCart {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "cart_id")
    public int cartId;

    @ColumnInfo(name = "user_id")
    @NonNull
    public int userId;

    @ColumnInfo(name = "created_at")
    public String createdAt;

    @ColumnInfo(name = "updated_at")
    public String updatedAt;
}