package com.personal.TravelPlanner.service.hotel.impl;

import com.personal.TravelPlanner.dto.hotel.HotelDTO;
import com.personal.TravelPlanner.entity.hotel.Hotel;
import com.personal.TravelPlanner.repository.hotel.HotelRepository;
import com.personal.TravelPlanner.service.hotel.HotelService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    public final HotelRepository hotelRepository;
    Logger logger = LoggerFactory.getLogger(HotelService.class);

    @Override
    public HotelDTO saveHotel(HotelDTO hotel) {
        logger.debug("enter [saveHotel] service,  hotelRequest = "+hotel.toString());
        Hotel newHotel = Hotel.builder()
                .address(hotel.getAddress())
                .name(hotel.getName())
                .contact(hotel.getContact())
                .city(hotel.getCity())
                .email(hotel.getEmail())
                .build();
        newHotel = hotelRepository.save(newHotel);
        logger.debug("save successful");
        HotelDTO response = HotelDTO.builder()
                .address(newHotel.getAddress())
                .contact(newHotel.getContact())
                .name(newHotel.getName())
                .email(newHotel.getEmail())
                .city(newHotel.getCity())
                .build();
        logger.debug("exit [saveHotel] service , return hotel = "+newHotel);
        return response;
    }

    @Override
    public HotelDTO deleteHotel(String email) {
        return null;
    }

    @Override
    public HotelDTO updateHotel(HotelDTO hotel) {
        return null;
    }
}
