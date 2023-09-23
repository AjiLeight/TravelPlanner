package com.personal.TravelPlanner.dto.hotel;

import com.personal.TravelPlanner.entity.hotel.Booking;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.awt.print.Book;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {
    private int roomNo;
    private BookingDTO bookingDTO;
}
