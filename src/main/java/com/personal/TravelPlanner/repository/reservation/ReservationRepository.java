package com.personal.TravelPlanner.repository.reservation;

import com.personal.TravelPlanner.entity.reservation.Reservation;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ReservationRepository extends MongoRepository<Reservation,String> {

}
