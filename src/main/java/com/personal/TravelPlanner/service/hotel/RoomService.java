package com.personal.TravelPlanner.service.hotel;

import com.personal.TravelPlanner.dto.hotel.AddRoomRequest;
import com.personal.TravelPlanner.dto.hotel.RoomDTO;
import com.personal.TravelPlanner.exception.room.DuplicateRoomException;
import com.personal.TravelPlanner.exception.room.RoomNotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RoomService {
    RoomDTO saveRoom(RoomDTO roomDTO);
    String saveRoom(AddRoomRequest request) throws DuplicateRoomException;

    List<RoomDTO> getRoomsByHotelId(String email);

    String deleteRoom(AddRoomRequest request) throws RoomNotFoundException;
}
