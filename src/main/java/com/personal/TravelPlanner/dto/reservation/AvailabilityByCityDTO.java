package com.personal.TravelPlanner.dto.reservation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvailabilityByCityDTO {
    private String city;
    private LocalDate from;
    private LocalDate to;
}
