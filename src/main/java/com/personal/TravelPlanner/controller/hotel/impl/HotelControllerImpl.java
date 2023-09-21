package com.personal.TravelPlanner.controller.hotel.impl;

import com.personal.TravelPlanner.controller.hotel.HotelController;
import com.personal.TravelPlanner.dto.hotel.HotelDTO;
import com.personal.TravelPlanner.entity.hotel.Hotel;
import com.personal.TravelPlanner.exception.EmailNotFoundException;
import com.personal.TravelPlanner.service.hotel.HotelService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        return ResponseEntity.ok(hotelService.updateHotel(hotelDTO));
    }

    @Override
    public ResponseEntity<String> deleteHotel(String email) {
        return ResponseEntity.ok(hotelService.deleteHotel(email));
    }

    @Override
    public ResponseEntity<List<HotelDTO>> getAllHotels() {
        return ResponseEntity.ok(hotelService.getAllHotels());
    }

    @Override
    public ResponseEntity<HotelDTO> getHotelByEmail(String email) throws EmailNotFoundException {
        return ResponseEntity.ok(hotelService.getHotelByEmail(email));
    }
}
