package com.personal.TravelPlanner.dto.hotel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class HotelDTO {
    private String email;
    private String city;
    private String address;
    private String name;
    private String contact;

    public HotelDTO(String email, String city, String address, String name, String contact) {
        this.email = email;
        this.city = city;
        this.address = address;
        this.name = name;
        this.contact = contact;
    }
}
