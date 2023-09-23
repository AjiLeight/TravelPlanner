package com.personal.TravelPlanner.entity.hotel;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Document(value = "hotel")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Hotel {

    @Id
    private String id;
    @Email
    @Indexed(unique = true)
    private String email;
    @NotNull
    private String city;
    @NotNull
    private String address;
    @NotNull
    private String name;
    @NotNull
    private String contact;
    private Integer capacity;
    private Map<Date, Integer> rooms;

}
