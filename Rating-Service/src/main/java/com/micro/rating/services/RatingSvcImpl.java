package com.micro.rating.services;

import com.micro.rating.entity.Rating;
import com.micro.rating.exceptions.ResourceNotFoundException;
import com.micro.rating.repositories.IRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingSvcImpl implements IRatingService {

    @Autowired
    IRatingRepository ratingRepository;


    @Override
    public Rating saveRating(Rating rating) {
        String ratingId = UUID.randomUUID().toString();
        rating.setRatingId(ratingId);
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) throws ResourceNotFoundException {
        List<Rating> allRatings = ratingRepository.findByUserId(userId);
        if (allRatings.isEmpty()) {
            throw new ResourceNotFoundException("No ratings available or incorrect user id");
        }
        return allRatings;

    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }
}