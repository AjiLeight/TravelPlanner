package com.personal.TravelPlanner.dto.hotel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCapacityRequestDTO {
    private String hotelId;
    private String action;
    private int capacity;
}
