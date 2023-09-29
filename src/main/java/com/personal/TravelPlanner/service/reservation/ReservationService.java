package com.personal.TravelPlanner.service.reservation;

import com.personal.TravelPlanner.dto.hotel.HotelDTO;
import com.personal.TravelPlanner.dto.reservation.AvailabilityByCityDTO;

import java.util.List;

public interface ReservationService {
//    HotelDTO saveReservation(SaveReservationRequestDTO saveReservationRequestDTO);

    List<HotelDTO> searchHotelForAvailabilityByCity(AvailabilityByCityDTO dto);
}
