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
import java.util.List;

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
    @DBRef
    private List<Room> rooms;

    public Hotel( String email, String city, String address, String name, String contact) {
        this.email = email;
        this.city = city;
        this.address = address;
        this.name = name;
        this.contact = contact;
        this.rooms = new ArrayList<>();
    }
}
