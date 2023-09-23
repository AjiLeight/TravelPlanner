package com.personal.TravelPlanner.controller.customer;

import com.personal.TravelPlanner.dto.cutomer.CustomerDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public interface CustomerController {
    @PostMapping()
    ResponseEntity<CustomerDTO> saveCustomer(@RequestBody @Valid  CustomerDTO customer) throws Exception;

    @PutMapping
    ResponseEntity<CustomerDTO> updateCustomer(@RequestBody @Valid  CustomerDTO customer) throws Exception;

    @DeleteMapping("/{email}")
    ResponseEntity<String> delete(@PathVariable @Email String email) throws Exception;

    @GetMapping("")
    ResponseEntity<List<CustomerDTO>> getAllUsers() throws Exception;

    @GetMapping("/{email}")
    ResponseEntity<CustomerDTO> getCustomerByEmail(@PathVariable @Email String email) throws Exception;






}
