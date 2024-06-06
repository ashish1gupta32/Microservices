package com.example.rating.service.controller;

import com.example.rating.service.dao.RatingDao;
import com.example.rating.service.model.Rating;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
@RequiredArgsConstructor
public class RatingController {

    private final RatingDao ratingDao;

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRating(){
        return ResponseEntity.ok(ratingDao.getAllRating());
    }
    @GetMapping("/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){
        return ResponseEntity.ok(ratingDao.getRatingByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<Rating> saveRating(@RequestBody Rating rating){
        return ResponseEntity.ok(ratingDao.saveRating(rating));
    }
    @DeleteMapping("/{ratingId}")
    public  ResponseEntity<Rating> deleteRating(@PathVariable int ratingId){
        return ResponseEntity.ok(ratingDao.deleteRatingByKey(ratingId));
    }
}
