package com.personal.TravelPlanner.controller;

import com.personal.TravelPlanner.dto.cutomer.CustomerDTO;
import com.personal.TravelPlanner.entity.customer.Customer;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer")
public interface CustomerController {
    @PostMapping()
    ResponseEntity<CustomerDTO> saveCustomer(@RequestBody @Valid CustomerDTO customer) throws Exception;
}
