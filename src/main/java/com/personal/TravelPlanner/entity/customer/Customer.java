package com.personal.TravelPlanner.entity.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "customer")
public class Customer {

    @Id
    String id;
    private String firstname;
    private String lastname;
    @Indexed(unique = true)
    private String phone;
    @Indexed(unique = true)
    private String email;
}
