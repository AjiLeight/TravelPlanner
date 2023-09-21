package com.personal.TravelPlanner.service.hotel;

import com.personal.TravelPlanner.dto.hotel.HotelDTO;
import com.personal.TravelPlanner.entity.hotel.Hotel;

public interface HotelService {
    HotelDTO saveHotel(HotelDTO hotel);
    HotelDTO deleteHotel(String email);
    HotelDTO updateHotel(HotelDTO hotel);
}
