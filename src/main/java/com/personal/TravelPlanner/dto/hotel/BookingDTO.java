package com.personal.TravelPlanner.dto.hotel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {
    private Date from;
    private Date to;
}
