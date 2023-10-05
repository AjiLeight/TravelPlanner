package com.personal.TravelPlanner.repository.reservation;

import com.personal.TravelPlanner.entity.reservation.Reservation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface ReservationRepository extends MongoRepository<Reservation,String> {

    List<Reservation> findAllByUserId(String email);
}
