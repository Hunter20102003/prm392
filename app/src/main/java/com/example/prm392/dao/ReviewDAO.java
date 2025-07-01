package com.example.prm392.dao;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.prm392.entity.Review;
import com.example.prm392.entity.relation.ReviewWithUser;

import java.util.List;

@Dao
public interface ReviewDAO {
    @Transaction
    @Query("SELECT * FROM reviews WHERE product_id = :productId ORDER BY review_date DESC")
    List<ReviewWithUser> getReviewsByProductId(int productId);

    @Insert
    void insertReview(Review review);
}
