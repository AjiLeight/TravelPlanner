package com.personal.TravelPlanner.controller.hotel.impl;

import com.personal.TravelPlanner.controller.hotel.RoomController;
import com.personal.TravelPlanner.dto.hotel.AddRoomRequest;
import com.personal.TravelPlanner.dto.hotel.RoomDTO;
import com.personal.TravelPlanner.exception.room.DuplicateRoomException;
import com.personal.TravelPlanner.exception.room.RoomNotFoundException;
import com.personal.TravelPlanner.service.hotel.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RoomControllerImpl implements RoomController {
    private final RoomService roomService;

    @Override
    public ResponseEntity<String> addRoom(AddRoomRequest request) throws DuplicateRoomException {
        return ResponseEntity.ok(roomService.saveRoom(request));
    }

    @Override
    public ResponseEntity<List<RoomDTO>> getRoomByHotelId(String email) {
        return ResponseEntity.ok(roomService.getRoomsByHotelId(email));
    }

    @Override
    public ResponseEntity<String> deleteRoom(AddRoomRequest request) throws RoomNotFoundException {
        return ResponseEntity.ok(roomService.deleteRoom(request));
    }
}
