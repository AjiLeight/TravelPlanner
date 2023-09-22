package com.personal.TravelPlanner.dto.hotel;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {
    private int roomNo;
    private boolean available;
    private Date from_date;
    private Date to_date;

    public RoomDTO(int roomNo){
        this.roomNo = roomNo;
        this.available = true;
    }
}
