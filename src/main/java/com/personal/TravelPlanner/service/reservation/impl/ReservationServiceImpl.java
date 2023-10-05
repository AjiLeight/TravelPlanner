package com.personal.TravelPlanner.service.reservation.impl;

import com.personal.TravelPlanner.dto.hotel.HotelDTO;
import com.personal.TravelPlanner.dto.reservation.AvailabilityByCityDTO;
import com.personal.TravelPlanner.dto.reservation.ReservationDTO;
import com.personal.TravelPlanner.entity.hotel.Booking;
import com.personal.TravelPlanner.entity.hotel.Hotel;
import com.personal.TravelPlanner.entity.reservation.Reservation;
import com.personal.TravelPlanner.exception.Reservation.ReservationException;
import com.personal.TravelPlanner.repository.hotel.BookingRepository;
import com.personal.TravelPlanner.repository.hotel.HotelRepository;
import com.personal.TravelPlanner.repository.reservation.ReservationRepository;
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
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final BookingRepository bookingRepository;
    private final ReservationRepository reservationRepository;
    private final ModelMapper modelMapper;
    private final MongoTemplate mongoTemplate;
    private final HotelRepository hotelRepository;
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

    @Override
    public Reservation reserveHotel(ReservationDTO reservationDTO) throws ReservationException {

        try{

            Reservation reservation = Reservation.builder()
                    .fromDate(reservationDTO.getFromDate())
                    .toDate(reservationDTO.getToDate())
                    .hotelId(reservationDTO.getHotelId())
                    .userId(reservationDTO.getUserId())
                    .build();




            List<LocalDate> dates = extractDates(reservationDTO.getFromDate(),reservationDTO.getToDate());

            Query findBookings = new Query(Criteria.where("hotelId").is(reservationDTO.getHotelId()).and("date").in(dates));
            List<Booking> bookings = mongoTemplate.find(findBookings, Booking.class);
            Hotel hotel=hotelRepository.findByEmail(reservationDTO.getHotelId());
            List<LocalDate> unbookedDates= nonBookedDates(dates,bookings);
            if (!bookings.isEmpty()) {
                bookings.forEach(booking -> {
                        booking.setRooms(booking.getRooms()-1);
                        bookingRepository.save(booking);});
                if(!unbookedDates.isEmpty()){
                    saveUnbookedDates(unbookedDates,reservation,hotel);
                }

            }else{
                saveUnbookedDates(dates,reservation,hotel);
            }
            reservationRepository.save(reservation);


            return reservation;
        }
        catch(Exception e){
            throw new ReservationException("Booking failed");
        }


    }

    @Override
    public List<Reservation> getAllReservation(String email) {
        return reservationRepository.findAllByUserId(email);
    }

    @Override
    public boolean cancelReservation(String id) throws ReservationException {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(()->new ReservationException("could not find reservation"));
        //extract dates
        List<LocalDate> dates=extractDates(reservation.getFromDate(),reservation.getToDate());
        //find booking from the reservation
        Query findBookings = new Query(Criteria.where("hotelId").is(reservation.getHotelId()).and("date").in(dates));
        List<Booking> bookings= mongoTemplate.find(findBookings,Booking.class);

        //increase no of rooms in booking records b 1
        bookings.forEach(booking -> {
            booking.setRooms(booking.getRooms()+1);
            bookingRepository.save(booking);
        });
        reservationRepository.deleteById(id);
        boolean result=reservationRepository.existsById(id);
        return !result;
    }

    @Override
    public Reservation getReservationById(String id) throws ReservationException {
        return reservationRepository.findById(id)
                .orElseThrow(
                        ()-> new ReservationException("could not find reservation"));
    }

    public void saveUnbookedDates(List<LocalDate> dates, Reservation reservation, Hotel hotel){
        dates.forEach(date->{
            Booking newBooking= Booking.builder()
                    .hotelId(reservation.getHotelId())
                    .rooms(hotel.getCapacity()-1)
                    .date(date)
                    .city(hotel.getCity())
                    .build();
            bookingRepository.save(newBooking);
        });

    }


    public List<LocalDate> nonBookedDates(List<LocalDate> dates, List<Booking> bookings){

        bookings.forEach(booking -> {
            dates.remove(booking.getDate());
        });
        return dates;
    }

    private boolean isDateExist(LocalDate date,List<LocalDate> dates){
        return dates.contains(date);
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
        while (!currentDate.isAfter(toDate)) {
            dates.add(currentDate);
            currentDate = currentDate.plusDays(1);
        }
        return dates;
    }
}
