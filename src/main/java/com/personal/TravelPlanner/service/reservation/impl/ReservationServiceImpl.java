package com.personal.TravelPlanner.service.reservation.impl;

import com.personal.TravelPlanner.dto.hotel.HotelDTO;
import com.personal.TravelPlanner.dto.reservation.AvailabilityByCityDTO;
import com.personal.TravelPlanner.entity.hotel.Booking;
import com.personal.TravelPlanner.entity.hotel.Hotel;
import com.personal.TravelPlanner.repository.hotel.BookingRepository;
import com.personal.TravelPlanner.repository.hotel.HotelRepository;
import com.personal.TravelPlanner.service.reservation.ReservationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final HotelRepository hotelRepository;
    private final BookingRepository bookingRepository;
    private final ModelMapper modelMapper;
    private final MongoTemplate mongoTemplate;
    Logger logger = LoggerFactory.getLogger(ReservationServiceImpl.class);

    @Override
    public List<HotelDTO> searchHotelForAvailabilityByCity(AvailabilityByCityDTO dto) {
        List<LocalDate> dates = extractDates(dto.getFrom(), dto.getTo());
        List<String> hotelsNotAvailable = executeQuery(dto.getCity(), dates);

        Query allHotelQuery = new Query(Criteria.where("city").is(dto.getCity()));
        List<Hotel> allHotels = mongoTemplate.find(allHotelQuery, Hotel.class);
        List<HotelDTO> response = allHotels.stream()
                .filter(hotel -> !hotelsNotAvailable.contains(hotel.getEmail()))
                .map(hotel -> modelMapper.map(hotel, HotelDTO.class))
                .toList();

        if (!response.isEmpty()) {
            return response;
        }
        return null;
    }

    private List<String> executeQuery(String city, List<LocalDate> dates){
        Query searchQuery = new Query(Criteria.where("city").is(city).and("date").in(dates).and("rooms").is(0));
        List<Booking> bookings = mongoTemplate.find(searchQuery, Booking.class);

        return bookings.stream()
                .map(Booking::getHotelId)
                .collect(Collectors.toSet())
                .stream().toList();
    }

    private List<LocalDate> extractDates(LocalDate fromDate, LocalDate toDate) {
        List<LocalDate> dates = new ArrayList<>();

        LocalDate currentDate = fromDate;
        while (!currentDate.isEqual(toDate)) {
            dates.add(currentDate);
            currentDate = currentDate.plusDays(1);
        }
        return dates;
    }
}
