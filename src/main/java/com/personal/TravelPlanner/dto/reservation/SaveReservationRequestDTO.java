package com.personal.TravelPlanner.dto.reservation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class SaveReservationRequestDTO {
    @JsonProperty("hotel")
    private String hotelId;
    @JsonProperty("dates")
    private List<Date> dates;
}
