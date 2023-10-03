package com.personal.TravelPlanner.service.reservation;

import com.personal.TravelPlanner.dto.hotel.HotelDTO;
import com.personal.TravelPlanner.dto.reservation.AvailabilityByCityDTO;
import com.personal.TravelPlanner.dto.reservation.ReservationDTO;
import com.personal.TravelPlanner.entity.reservation.Reservation;
import com.personal.TravelPlanner.exception.Reservation.ReservationException;

import java.util.List;

public interface ReservationService {
//    HotelDTO saveReservation(SaveReservationRequestDTO saveReservationRequestDTO);

    List<HotelDTO> searchHotelForAvailabilityByCity(AvailabilityByCityDTO dto);

    Reservation reserveHotel(ReservationDTO reservationDTO) throws ReservationException;
}
