package com.personal.TravelPlanner.repository.hotel;

import com.personal.TravelPlanner.entity.hotel.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface BookingRepository extends MongoRepository<Booking, String> {
    @Query(value = "{'city' :  ?0, 'date' :  { $in : ?1 }, 'rooms' :  { $gt :  0 } }")
    List<Booking> findAvailableRoomsInCityForDates(String city, List<Date> dates);
}
