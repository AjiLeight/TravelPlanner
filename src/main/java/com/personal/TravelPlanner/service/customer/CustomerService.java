package com.personal.TravelPlanner.service.customer;

import com.personal.TravelPlanner.dto.cutomer.CustomerDTO;
import com.personal.TravelPlanner.entity.customer.Customer;

import java.util.List;

public interface CustomerService {
    CustomerDTO save(CustomerDTO customer);

    CustomerDTO update(CustomerDTO customer);

    String delete(String email);

    List<CustomerDTO> getAllCustomers();

    CustomerDTO getCustomerByEmail(String email);
}
