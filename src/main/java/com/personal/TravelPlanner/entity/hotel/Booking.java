package com.personal.TravelPlanner.entity.hotel;

import com.personal.TravelPlanner.entity.authentication.User;
import com.personal.TravelPlanner.entity.customer.Customer;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(value = "booking")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {
    @Id
    private String id;
    @DBRef
    private Customer customer;
    @NotNull
    private Date from;
    @NotNull
    private Date to;
}
