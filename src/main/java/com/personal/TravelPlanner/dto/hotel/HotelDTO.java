package com.personal.TravelPlanner.dto.hotel;

import com.personal.TravelPlanner.entity.hotel.Room;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HotelDTO {
    private String email;
    private String city;
    private String address;
    private String name;
    private String contact;
    private RoomDTO room;

    public HotelDTO(String email, String city, String address, String name, String contact) {
        this.email = email;
        this.city = city;
        this.address = address;
        this.name = name;
        this.contact = contact;
    }
}
