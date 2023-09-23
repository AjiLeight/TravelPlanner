package com.personal.TravelPlanner.repository.hotel;

import com.personal.TravelPlanner.entity.hotel.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoomRepository extends MongoRepository<Room, String> {
    Optional<Room> findByRoomNo(int roomNo);
    Room deleteByRoomNo(int roomNo);
}
