package com.micro.hotel.services;

import com.micro.hotel.entities.Hotel;
import com.micro.hotel.repositories.IHotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements IHotelService {

    @Autowired
    public IHotelRepository iHotelRepository;

    @Override
    public Hotel saveHotel(Hotel hotel) {
        String randomId = UUID.randomUUID().toString();
        hotel.setId(randomId);
        return iHotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getHotelList() {
        return iHotelRepository.findAll();

    }

    @Override
    public Hotel getHotelById(String id) {

        return iHotelRepository.findById(id).get();
    }
}
