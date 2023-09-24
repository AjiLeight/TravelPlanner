package com.personal.TravelPlanner.service.reservation.impl;

import com.personal.TravelPlanner.dto.hotel.HotelDTO;
import com.personal.TravelPlanner.dto.reservation.SaveReservationRequestDTO;
import com.personal.TravelPlanner.entity.hotel.Booking;
import com.personal.TravelPlanner.entity.hotel.Hotel;
import com.personal.TravelPlanner.repository.hotel.BookingRepository;
import com.personal.TravelPlanner.repository.hotel.HotelRepository;
import com.personal.TravelPlanner.service.reservation.ReservationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final HotelRepository hotelRepository;
    private final BookingRepository bookingRepository;
    private final ModelMapper modelMapper;

    @Override
    public HotelDTO saveReservation(SaveReservationRequestDTO saveReservationRequestDTO) {
        Hotel hotel = hotelRepository.findByEmail(saveReservationRequestDTO.getHotelId());
        List<Date> dates = saveReservationRequestDTO.getDates();
        List<Booking> bookings = new ArrayList<>();
        for(Date date : dates){
            Booking booking = Booking.builder()
                    .rooms(hotel.getCapacity())
                    .hotelId(hotel.getEmail())
                    .date(date)
                    .build();
            booking = bookingRepository.save(booking);
            bookings.add(booking);
        }
        hotel.setBooking(bookings);
        hotelRepository.save(hotel);
        return modelMapper.map(hotel, HotelDTO.class);
    }
}
