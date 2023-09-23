package com.personal.TravelPlanner.service.hotel.impl;

import com.personal.TravelPlanner.dto.hotel.AddRoomRequest;
import com.personal.TravelPlanner.dto.hotel.RoomDTO;
import com.personal.TravelPlanner.entity.hotel.Hotel;
import com.personal.TravelPlanner.entity.hotel.Room;
import com.personal.TravelPlanner.exception.room.DuplicateRoomException;
import com.personal.TravelPlanner.exception.room.RoomNotFoundException;
import com.personal.TravelPlanner.repository.hotel.HotelRepository;
import com.personal.TravelPlanner.repository.hotel.RoomRepository;
import com.personal.TravelPlanner.service.hotel.RoomService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper;
    @Override
    public RoomDTO saveRoom(RoomDTO roomDTO) {
        Room room = modelMapper.map(roomDTO, Room.class);
        Room savedRoom =  roomRepository.save(room);
        return modelMapper.map(savedRoom, RoomDTO.class);
    }

    @Override
    public String saveRoom(AddRoomRequest request) throws DuplicateRoomException {
        Hotel hotel = hotelRepository.findByEmail(request.getHotelId());
        Room room = Room.builder()
                .roomNo(request.getRoomNo())
                .build();
        List<Room> rooms = hotel.getRooms();
        if(rooms==null){
            rooms = new ArrayList<>();
        }
        Room exists = rooms.stream()
                .filter(room1 -> room1.getRoomNo()==request.getRoomNo())
                .findFirst()
                .orElse(null);
        if(exists!=null){
            throw new DuplicateRoomException("room already exists");
        }
        rooms.add(room);

        room = roomRepository.save(room);
        hotelRepository.save(hotel);
        return Integer.toString(room.getRoomNo());
    }

    @Override
    public List<RoomDTO> getRoomsByHotelId(String email) {
        List<Room> rooms = hotelRepository.findByEmail(email).getRooms();
        return rooms.stream()
                .map(room -> modelMapper.map(room, RoomDTO.class))
                .toList();
    }

    @Override
    public String deleteRoom(AddRoomRequest request) throws RoomNotFoundException {
        Hotel hotel = hotelRepository.findByEmail(request.getHotelId());
        Room room = hotel.getRooms()
                .stream().filter(room1 -> room1.getRoomNo()==request.getRoomNo())
                .findFirst()
                .orElseThrow(() -> new RoomNotFoundException("room not found"));
        hotel.getRooms()
                .removeIf(r -> r.getRoomNo() == request.getRoomNo());
        roomRepository.delete(room);
        hotelRepository.save(hotel);
        return Integer.toString(request.getRoomNo());
    }
}
