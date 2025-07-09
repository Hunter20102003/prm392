package com.example.prm392.repository;

import android.content.Context;

import com.example.prm392.dao.ReviewDAO;
import com.example.prm392.dao.room.AppDatabase;
import com.example.prm392.entity.Review;
import com.example.prm392.entity.relation.ReviewWithUser;
import com.example.prm392.utils.Mapper;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class ReviewRepository {
    private final ReviewDAO reviewDAO;
    private final ModelMapper mapper = Mapper.getInstance();
    public ReviewRepository(Context context) {
        AppDatabase reviewRoomDatabase = AppDatabase.getInstance(context);
        reviewDAO = reviewRoomDatabase.reviewDao();
    }
    public void addReview(Review review) {
        reviewDAO.insert(review);
    }
    public void updateReview(Review review) {
        reviewDAO.update(review);
    }
    public void deleteReview(Review review) {
        reviewDAO.delete(review);}
    public void deleteAllReviews() {
        reviewDAO.deleteAll();
    }
    public List<Review> getReviewsByProductId(Integer productId) {
       List<ReviewWithUser> reviewWithUsers= reviewDAO.getReviewsByProductId(productId);
       mapper.map(reviewWithUsers, Review.class);
       List <Review> reviews=new ArrayList<>();
       return reviews;

    }
    public Double getAvgRatingByProductId(Integer productId) {
        return reviewDAO.getAverageRatingByProductId(productId);
    }

}
