package com.personal.TravelPlanner.service.hotel;

import com.personal.TravelPlanner.dto.hotel.HotelDTO;
import com.personal.TravelPlanner.entity.hotel.Hotel;
import com.personal.TravelPlanner.exception.EmailNotFoundException;

import java.util.List;

public interface HotelService {
    HotelDTO saveHotel(HotelDTO hotel);
    String deleteHotel(String email);
    HotelDTO updateHotel(HotelDTO hotel);

    List<HotelDTO> getAllHotels();
    HotelDTO getHotelByEmail(String email) throws EmailNotFoundException;
}
