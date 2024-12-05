package com.personal.TravelPlanner.experimental;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Search{
    private String city;
    private LocalDate from;
    private LocalDate to;
}
