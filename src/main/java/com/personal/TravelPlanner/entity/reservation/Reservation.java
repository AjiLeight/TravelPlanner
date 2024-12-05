package com.personal.TravelPlanner.entity.reservation;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Reservation{

    @Id
    private String id;

    private LocalDate fromDate;

    private LocalDate toDate;

    private String hotelId;

    private String userId;


}
