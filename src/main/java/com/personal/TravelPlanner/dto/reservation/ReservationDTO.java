package com.personal.TravelPlanner.dto.reservation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDTO {


    private LocalDate fromDate;

    private LocalDate toDate;

    private String hotelId;

    private String userId;

}
