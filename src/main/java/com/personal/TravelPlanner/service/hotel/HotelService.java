package com.personal.TravelPlanner.service.hotel;

import com.personal.TravelPlanner.dto.hotel.CapacityResponseDTO;
import com.personal.TravelPlanner.dto.hotel.HotelDTO;
import com.personal.TravelPlanner.dto.hotel.UpdateCapacityRequestDTO;
import com.personal.TravelPlanner.exception.auth.EmailNotFoundException;

import java.util.List;

public interface HotelService {
    HotelDTO saveHotel(HotelDTO hotel);
    String deleteHotel(String email);
    HotelDTO updateHotel(HotelDTO hotel);

    List<HotelDTO> getAllHotels();
    HotelDTO getHotelByEmail(String email) throws EmailNotFoundException;

    String addCapacity(String hotelEmail, Integer capacity);

    CapacityResponseDTO getCapacity(String hotel);

    CapacityResponseDTO updateCapacity(UpdateCapacityRequestDTO request) throws Exception;
}
