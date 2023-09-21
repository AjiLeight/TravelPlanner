package com.personal.TravelPlanner.controller.customer.impl;

import com.personal.TravelPlanner.controller.CustomerController;
import com.personal.TravelPlanner.dto.cutomer.CustomerDTO;
import com.personal.TravelPlanner.entity.customer.Customer;
import com.personal.TravelPlanner.service.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CustomerControllerImpl implements CustomerController {

    private final CustomerService customerService;
    @Override
    public ResponseEntity<CustomerDTO> saveCustomer(CustomerDTO customer ) throws Exception {

        return ResponseEntity.ok(customerService.save(customer));
    }
}
