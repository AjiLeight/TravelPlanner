package com.personal.TravelPlanner.controller.reservation;

import com.personal.TravelPlanner.dto.hotel.HotelDTO;
import com.personal.TravelPlanner.dto.reservation.AvailabilityByCityDTO;
import com.personal.TravelPlanner.dto.reservation.ReservationDTO;
import com.personal.TravelPlanner.entity.reservation.Reservation;
import com.personal.TravelPlanner.exception.Reservation.ReservationException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reserve")
public interface ReservationController {
    @GetMapping()
    ResponseEntity<List<HotelDTO>> searchAvailableHotelByCIty(@RequestBody AvailabilityByCityDTO dto);


    @PostMapping
    ResponseEntity<Reservation> reserveHotel(@RequestBody @Valid ReservationDTO reservationDTO) throws ReservationException;


    @GetMapping("/{email}")
    ResponseEntity<List<Reservation>> allReservation(@PathVariable @Email String email);

    @DeleteMapping("/id/{id}")
    ResponseEntity<Boolean> cancelReservation(@PathVariable String id) throws ReservationException;

    @GetMapping ("/id/{id}")
    ResponseEntity<Reservation> GetReservationById(@PathVariable String id) throws ReservationException;

}