package com.personal.TravelPlanner.dto.hotel;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddRoomRequest {
    @Email
    private String hotelId;
    @NotNull
    private int roomNo;
}
