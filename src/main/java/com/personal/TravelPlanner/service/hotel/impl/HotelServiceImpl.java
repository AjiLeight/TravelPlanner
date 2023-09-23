package com.personal.TravelPlanner.service.hotel.impl;

import com.personal.TravelPlanner.constants.UpdateRoomsAction;
import com.personal.TravelPlanner.dto.hotel.CapacityResponseDTO;
import com.personal.TravelPlanner.dto.hotel.HotelDTO;
import com.personal.TravelPlanner.dto.hotel.UpdateCapacityRequestDTO;
import com.personal.TravelPlanner.entity.hotel.Hotel;
import com.personal.TravelPlanner.exception.auth.EmailNotFoundException;
import com.personal.TravelPlanner.repository.UserRepository;
import com.personal.TravelPlanner.repository.hotel.HotelRepository;
import com.personal.TravelPlanner.service.hotel.HotelService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    public final HotelRepository hotelRepository;
    public final UserRepository userRepository;
    Logger logger = LoggerFactory.getLogger(HotelService.class);
    ModelMapper modelMapper = new ModelMapper();

    @Override
    public HotelDTO saveHotel(HotelDTO hotel) {
        Hotel newHotel = modelMapper.map(hotel, Hotel.class);
        newHotel = hotelRepository.save(newHotel);
        return modelMapper.map(newHotel, HotelDTO.class);
    }


    @Override
    public String deleteHotel(String email) {
        userRepository.deleteByEmail(email);
        Hotel hotel = hotelRepository.deleteByEmail(email);
        return hotel.getEmail();
    }

    @Override
    public HotelDTO updateHotel(HotelDTO hotel) {
        Hotel existingHotel = hotelRepository.findByEmail(hotel.getEmail());
        existingHotel.setAddress(hotel.getAddress());
        existingHotel.setCity(hotel.getCity());
        existingHotel.setName(hotel.getName());
        existingHotel.setEmail(hotel.getEmail());
        existingHotel.setContact(hotel.getContact());
        Hotel savedHotel = hotelRepository.save(existingHotel);
        return modelMapper.map(savedHotel,HotelDTO.class);
    }

    @Override
    public List<HotelDTO> getAllHotels() {
         List<Hotel> hotels = hotelRepository.findAll();
         List<HotelDTO> response = new ArrayList<>();
         hotels.forEach(hotel -> {
             response.add(modelMapper.map(hotel, HotelDTO.class));
         });
         return response;
    }

    @Override
    public HotelDTO getHotelByEmail(String email) throws EmailNotFoundException {
        try {
            return modelMapper.map(
                    hotelRepository.findByEmail(email), HotelDTO.class);
        }
        catch (Exception exception){
            throw new EmailNotFoundException("email not found");
        }
    }

    @Override
    public String addCapacity(String hotelEmail, Integer capacity) {
        Hotel hotel = hotelRepository.findByEmail(hotelEmail);
        hotel.setCapacity(capacity);
        hotelRepository.save(hotel);
        return "successfully updated number of rooms to "+capacity;
    }

    @Override
    public CapacityResponseDTO getCapacity(String hotel) {
        return CapacityResponseDTO.builder()
                .numberOfRooms(hotelRepository
                        .findByEmail(hotel)
                        .getCapacity()
                )
                .build();
    }

    @Override
    public CapacityResponseDTO updateCapacity(UpdateCapacityRequestDTO request) throws Exception {
        Hotel hotel = hotelRepository.findByEmail(request.getHotelId());
        if(request.getAction().equals(UpdateRoomsAction.ADD.getAction())){
            hotel.setCapacity(hotel.getCapacity() + request.getCapacity());
        }
        else if(request.getAction().equals(UpdateRoomsAction.DELETE.getAction())){
            hotel.setCapacity(hotel.getCapacity() - request.getCapacity());
        }
        else {
            throw new IllegalArgumentException("invalid action type");
        }
        if(hotel.getCapacity()<0){
            throw new Exception("capacity can not be less than zero");
        }
        hotelRepository.save(hotel);
        return CapacityResponseDTO.builder()
                .numberOfRooms(hotel.getCapacity())
                .build();
    }
}
