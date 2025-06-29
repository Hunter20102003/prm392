package com.example.prm392.entity;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
    private Integer reviewId;

    @ColumnInfo(name = "user_id")
    @NonNull
        private Integer userId;

    @ColumnInfo(name = "product_id")
    @NonNull
    private Integer productId;

    @ColumnInfo(name = "rating")
    @NonNull
    private Integer rating;

    @ColumnInfo(name = "comment")
    private String comment;

    @ColumnInfo(name = "review_date")
    private LocalDate reviewDate;

    public Review() {
    }


    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    @NonNull
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(@NonNull Integer userId) {
        this.userId = userId;
    }

    @NonNull
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(@NonNull Integer productId) {
        this.productId = productId;
    }

    @NonNull
    public Integer getRating() {
        return rating;
    }

    public void setRating(@NonNull Integer rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(LocalDate reviewDate) {
        this.reviewDate = reviewDate;
    }
}
