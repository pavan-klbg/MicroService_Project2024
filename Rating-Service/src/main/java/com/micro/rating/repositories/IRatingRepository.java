package com.micro.rating.repositories;

import com.micro.rating.entity.Rating;
import com.micro.rating.exceptions.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRatingRepository extends JpaRepository<Rating,String> {

    //custom finder methods
    List<Rating> findByUserId(String userId) throws ResourceNotFoundException;
    List<Rating> findByHotelId(String hotelId);
}
