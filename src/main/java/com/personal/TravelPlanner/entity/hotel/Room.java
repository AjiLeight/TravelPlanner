package com.personal.TravelPlanner.entity.hotel;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(value = "room")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Room {
    @Id
    private String id;
    @NotNull
    private int room_no;
    private boolean available;
    private Date from_date;
    private Date to_date;

    public Room(int room_no) {
        this.room_no = room_no;
        this.available = true;
    }
}
