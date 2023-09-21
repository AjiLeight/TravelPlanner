package com.personal.TravelPlanner.dto.hotel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
