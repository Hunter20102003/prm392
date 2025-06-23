package com.example.prm392.entity;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
@Entity(tableName = "reviews",
        foreignKeys = {
                @ForeignKey(entity = User.class,
                        parentColumns = "user_id",
                        childColumns = "user_id"),
                @ForeignKey(entity = Product.class,
                        parentColumns = "product_id",
                        childColumns = "product_id",
                        onDelete = ForeignKey.CASCADE)
        }, indices = {
        @Index(value = {"user_id"}),@Index(value={"product_id"})
})
public class Review {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "review_id")
    public int reviewId;

    @ColumnInfo(name = "user_id")
    @NonNull
    public int userId;

    @ColumnInfo(name = "product_id")
    @NonNull
    public int productId;

    @ColumnInfo(name = "rating")
    @NonNull
    public int rating;

    @ColumnInfo(name = "comment")
    public String comment;

    @ColumnInfo(name = "review_date")
    public String reviewDate;
}
