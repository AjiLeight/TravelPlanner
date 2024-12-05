package com.personal.TravelPlanner.controller.customer.impl;

import com.personal.TravelPlanner.controller.customer.CustomerController;
import com.personal.TravelPlanner.dto.cutomer.CustomerDTO;
import com.personal.TravelPlanner.service.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CustomerControllerImpl implements CustomerController {

    private final CustomerService customerService;
    @Override
    public ResponseEntity<CustomerDTO> saveCustomer(CustomerDTO customer ) throws Exception {

        return ResponseEntity.ok(customerService.save(customer));
    }

    @Override
    public ResponseEntity<CustomerDTO> updateCustomer(CustomerDTO customer) throws Exception {
        return ResponseEntity.ok(customerService.update(customer));
    }

    @Override
    public ResponseEntity<String> delete(String email) throws Exception {
        return ResponseEntity.ok(customerService.delete(email));
    }

    @Override
    public ResponseEntity<List<CustomerDTO>> getAllUsers() throws Exception {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @Override
    public ResponseEntity<CustomerDTO> getCustomerByEmail(String email) throws Exception {
        return ResponseEntity.ok(customerService.getCustomerByEmail(email));
    }
}
