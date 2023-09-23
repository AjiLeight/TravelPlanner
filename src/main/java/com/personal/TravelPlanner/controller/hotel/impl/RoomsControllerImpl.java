package com.personal.TravelPlanner.controller.hotel.impl;

import com.personal.TravelPlanner.controller.hotel.RoomsController;
import com.personal.TravelPlanner.dto.hotel.CapacityResponseDTO;
import com.personal.TravelPlanner.dto.hotel.UpdateCapacityRequestDTO;
import com.personal.TravelPlanner.service.hotel.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RoomsControllerImpl implements RoomsController {
    private final HotelService hotelService;
    @Override
    public ResponseEntity<String> addRooms(String hotelEmail, Integer capacity) {
        return ResponseEntity.ok(hotelService.addCapacity(hotelEmail, capacity));
    }

    @Override
    public ResponseEntity<CapacityResponseDTO> getCapacity(String hotel) {
        return ResponseEntity.ok(hotelService.getCapacity(hotel));
    }

    @Override
    public ResponseEntity<CapacityResponseDTO> updateCapacity(UpdateCapacityRequestDTO request) throws Exception {
        return ResponseEntity.ok(hotelService.updateCapacity(request));
    }
}
