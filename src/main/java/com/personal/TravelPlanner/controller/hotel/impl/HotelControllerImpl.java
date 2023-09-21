package com.personal.TravelPlanner.controller.hotel.impl;

import com.personal.TravelPlanner.controller.hotel.HotelController;
import com.personal.TravelPlanner.dto.hotel.HotelDTO;
import com.personal.TravelPlanner.entity.hotel.Hotel;
import com.personal.TravelPlanner.service.hotel.HotelService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HotelControllerImpl implements HotelController {

    public final HotelService hotelService;

    Logger logger = LoggerFactory.getLogger(HotelController.class);

    @Override
    public ResponseEntity<HotelDTO> saveHotel(HotelDTO hotelDTO) {
        logger.debug("enter [saveHotel] controller , request = "+hotelDTO);
        ResponseEntity<HotelDTO> response = ResponseEntity.ok(hotelService.saveHotel(hotelDTO));
        logger.debug("exit [saveHotel] controller, response = " + hotelDTO);
        return response;
    }

    @Override
    public ResponseEntity<HotelDTO> updateHotel(HotelDTO hotelDTO) {
        return null;
    }

    @Override
    public ResponseEntity<HotelDTO> deleteHotel(String email) {
        return null;
    }
}
