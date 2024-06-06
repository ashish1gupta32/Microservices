package com.example.rating.service.repository;

import com.example.rating.service.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating,Integer> {
    List<Rating> findAllByUserId(String userId);
}
