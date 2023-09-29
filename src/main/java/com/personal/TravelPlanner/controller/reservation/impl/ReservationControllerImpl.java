package com.personal.TravelPlanner.controller.reservation.impl;

import com.personal.TravelPlanner.controller.reservation.ReservationController;
import com.personal.TravelPlanner.dto.hotel.HotelDTO;
import com.personal.TravelPlanner.dto.reservation.AvailabilityByCityDTO;
import com.personal.TravelPlanner.service.reservation.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReservationControllerImpl implements ReservationController {
    @Autowired
    ReservationService reservationService;

    @Override
    public ResponseEntity<List<HotelDTO>> searchAvailableHotelByCIty(AvailabilityByCityDTO dto) {
        return ResponseEntity.ok(reservationService.searchHotelForAvailabilityByCity(dto));
    }
}
