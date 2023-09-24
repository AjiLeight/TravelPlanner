package com.personal.TravelPlanner.repository.hotel;

import com.personal.TravelPlanner.entity.hotel.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingRepository extends MongoRepository<Booking, String> {

}
