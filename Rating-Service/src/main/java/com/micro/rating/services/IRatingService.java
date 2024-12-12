package com.micro.rating.services;

import com.micro.rating.entity.Rating;

import java.util.List;

public interface IRatingService   {

    Rating saveRating(Rating rating);

    List<Rating> getAllRatings();
    List<Rating> getRatingByUserId(String userId);

    List<Rating> getRatingByHotelId(String hotelId);
}
