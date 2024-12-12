package com.micro.rating.controllers;

import com.micro.rating.entity.Rating;
import com.micro.rating.services.IRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    IRatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> saveRatingDetails(@RequestBody Rating rating) {
        return new ResponseEntity<>(ratingService.saveRating(rating), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatingInfo() {
        return new ResponseEntity<>(ratingService.getAllRatings(), HttpStatus.OK);
    }

    // get rating based on userId

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> fetchRatingByUserId(@PathVariable String userId) {
        return new ResponseEntity<>(ratingService.getRatingByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Rating>> fetchRatingByHotelId(@PathVariable String hotelId) {
        return new ResponseEntity<>(ratingService.getRatingByHotelId(hotelId), HttpStatus.OK);
    }

}
