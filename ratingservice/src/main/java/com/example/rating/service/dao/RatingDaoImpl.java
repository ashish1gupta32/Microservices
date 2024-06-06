package com.example.rating.service.dao;

import com.example.rating.service.exception.RatingNotFoundException;
import com.example.rating.service.model.Rating;
import com.example.rating.service.repository.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RatingDaoImpl implements RatingDao {

    private final RatingRepository ratingRepository;

    @Override
    public Rating saveRating(Rating rating) {
        ratingRepository.save(rating);
        return rating;
    }

    @Override
    public List<Rating> getAllRating() {
        return ratingRepository.findAll();
    }

    @Override
    public Rating getRatingById(int ratingId) {
        return ratingRepository.findById(ratingId).orElseThrow(RatingNotFoundException::new);
    }

    @Override
    public Rating deleteRatingByKey(int ratingId) {
        Rating rating = ratingRepository.findById(ratingId).orElseThrow(RatingNotFoundException::new);
        ratingRepository.deleteById(ratingId);
        return rating;
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepository.findAllByUserId(userId);
    }
}
