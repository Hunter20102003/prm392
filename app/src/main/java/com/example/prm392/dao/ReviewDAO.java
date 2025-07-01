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
    @Query("SELECT * FROM reviews WHERE product_id = :id")
    List<ReviewWithUser> getReviewsByProductId(Integer id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Review review);

    @Update
    void update(Review review);

    @Delete
    void delete(Review review);

    @Query("DELETE FROM reviews")
    void deleteAll();

    @Transaction
    @Query("SELECT * FROM reviews where product_id = :productId ")
    List<ReviewWithUser> getReviewByProductId(Integer productId);

}
