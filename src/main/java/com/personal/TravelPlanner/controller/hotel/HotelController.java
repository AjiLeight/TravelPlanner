package com.personal.TravelPlanner.controller.hotel;

import com.personal.TravelPlanner.dto.hotel.HotelDTO;
import com.personal.TravelPlanner.entity.hotel.Hotel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/hotel")
public interface HotelController {
    @PostMapping
    public ResponseEntity<HotelDTO> saveHotel(@RequestBody(required = true) HotelDTO hotelDTO);
    @PutMapping
    public ResponseEntity<HotelDTO> updateHotel(@RequestBody(required = true) HotelDTO hotelDTO);
    @DeleteMapping
    public ResponseEntity<HotelDTO> deleteHotel(@RequestBody(required = true) String email);
}
