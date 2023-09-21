package com.personal.TravelPlanner.repository.hotel;

import com.personal.TravelPlanner.entity.hotel.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HotelRepository extends MongoRepository<Hotel, Long> {

}
