package com.personal.TravelPlanner.controller;

import com.personal.TravelPlanner.dto.hotel.HotelDTO;
import com.personal.TravelPlanner.dto.reservation.SaveReservationRequestDTO;
import com.personal.TravelPlanner.service.reservation.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class DemoController {
    @Autowired
    ReservationService reservationService;

    @GetMapping
    public ResponseEntity<String> hw(){

        return ResponseEntity.ok("hello world");
    }

    @PostMapping
    public ResponseEntity<HotelDTO> demoBookingUpdate(@RequestBody SaveReservationRequestDTO requestDTO){
        System.out.println(requestDTO.getDates());
        return ResponseEntity.ok(reservationService.saveReservation(requestDTO)) ;
    }
}
