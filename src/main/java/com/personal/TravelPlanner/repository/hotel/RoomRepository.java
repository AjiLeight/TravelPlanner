package com.personal.TravelPlanner.repository.hotel;

import com.personal.TravelPlanner.entity.hotel.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoomRepository extends MongoRepository<Room, String> {
}
