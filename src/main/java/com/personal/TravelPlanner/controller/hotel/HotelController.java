package com.personal.TravelPlanner.controller.hotel;

import com.personal.TravelPlanner.dto.hotel.HotelDTO;
import com.personal.TravelPlanner.entity.hotel.Hotel;
import com.personal.TravelPlanner.exception.EmailNotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/hotel")
public interface HotelController {
    @PostMapping
    public ResponseEntity<HotelDTO> saveHotel(@RequestBody(required = true) @Valid HotelDTO hotelDTO);
    @PutMapping
    public ResponseEntity<HotelDTO> updateHotel(@RequestBody(required = true) @Valid HotelDTO hotelDTO);
    @DeleteMapping("/{email}")
    public ResponseEntity<String> deleteHotel(@PathVariable(required = true) @Email String email);
    @GetMapping
    public ResponseEntity<List<HotelDTO>> getAllHotels();
    @GetMapping("/{email}")
    public ResponseEntity<HotelDTO> getHotelByEmail(@PathVariable(required = true) @Email String email) throws EmailNotFoundException;
}
