package com.personal.TravelPlanner.service.customer.impl;

import com.personal.TravelPlanner.dto.cutomer.CustomerDTO;
import com.personal.TravelPlanner.entity.customer.Customer;
import com.personal.TravelPlanner.repository.Customer.CustomerRepository;
import com.personal.TravelPlanner.service.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    @Override
    public CustomerDTO save(CustomerDTO customer) {

        Customer saveCustomer = Customer.builder()
                .firstname(customer.getFirstname())
                .lastname(customer.getLastname())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .build();

        customerRepository.save(saveCustomer);
        return customer;

    }
}
