package com.personal.TravelPlanner.controller.hotel;

import com.personal.TravelPlanner.dto.hotel.AddRoomRequest;
import com.personal.TravelPlanner.dto.hotel.RoomDTO;
import com.personal.TravelPlanner.exception.room.DuplicateRoomException;
import com.personal.TravelPlanner.exception.room.RoomNotFoundException;
import com.personal.TravelPlanner.service.hotel.RoomService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/room")
public interface RoomController {
    @PostMapping
    public ResponseEntity<String> addRoom(@RequestBody @Valid AddRoomRequest request) throws DuplicateRoomException;
    @GetMapping("{email}")
    public ResponseEntity<List<RoomDTO>> getRoomByHotelId(@PathVariable String email);
    @DeleteMapping
    public ResponseEntity<String> deleteRoom(@RequestBody @Valid AddRoomRequest request) throws RoomNotFoundException;
}
