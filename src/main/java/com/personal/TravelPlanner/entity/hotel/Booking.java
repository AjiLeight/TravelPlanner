package com.personal.TravelPlanner.entity.hotel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Document
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class  Booking {
    @Id
    private String id;
    private String hotelId;
    private String city;
    private LocalDate date;
    private Integer rooms;
}
