package com.micro.hotel.controllers;


import com.micro.hotel.entities.Hotel;
import com.micro.hotel.services.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HotelController {

    @Autowired
    private IHotelService hotelService;

    // create hotel
    @PostMapping("/hotel")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        return new ResponseEntity<>(hotelService.saveHotel(hotel), HttpStatus.CREATED);

    }

    // get hotel lists
    @GetMapping("/hotels")
    public  ResponseEntity<List<Hotel>> getAllHotels(){
        return  new ResponseEntity<>(hotelService.getHotelList(),HttpStatus.OK);
    }

    //get hotel by id
    @GetMapping("/hotel/{id}")
    public  ResponseEntity<Hotel> fetchById(@PathVariable("id") String id){
        return new ResponseEntity<>(hotelService.getHotelById(id),HttpStatus.OK);
    }

}
