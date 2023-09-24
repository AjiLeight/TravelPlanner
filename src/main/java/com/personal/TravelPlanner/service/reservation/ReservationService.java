package com.personal.TravelPlanner.service.reservation;

import com.personal.TravelPlanner.dto.hotel.HotelDTO;
import com.personal.TravelPlanner.dto.reservation.SaveReservationRequestDTO;

public interface ReservationService {
    HotelDTO saveReservation(SaveReservationRequestDTO saveReservationRequestDTO);
}
