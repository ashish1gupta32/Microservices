package com.example.rating.service.dao;

import com.example.rating.service.model.Rating;

import java.util.List;

public interface RatingDao {
    Rating saveRating(Rating rating);
    List<Rating> getAllRating();
    Rating getRatingById(int ratingId);

    Rating deleteRatingByKey(int ratingId);

    List<Rating> getRatingByUserId(String userId);
}
