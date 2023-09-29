package com.personal.TravelPlanner.controller.reservation;

import com.personal.TravelPlanner.dto.hotel.HotelDTO;
import com.personal.TravelPlanner.dto.reservation.AvailabilityByCityDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reserve")
public interface ReservationController {
    @GetMapping()
    ResponseEntity<List<HotelDTO>> searchAvailableHotelByCIty(@RequestBody AvailabilityByCityDTO dto);
}
