package com.personal.TravelPlanner.dto.hotel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CapacityResponseDTO {
    private Integer numberOfRooms;
}
