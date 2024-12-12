package com.micro.hotel.services;

import com.micro.hotel.entities.Hotel;

import java.util.List;

public interface IHotelService {

    Hotel saveHotel(Hotel hotel);

    List<Hotel> getHotelList();

    Hotel getHotelById(String id);


}
