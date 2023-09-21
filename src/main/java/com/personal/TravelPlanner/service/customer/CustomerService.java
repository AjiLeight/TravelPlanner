package com.personal.TravelPlanner.service.customer;

import com.personal.TravelPlanner.dto.cutomer.CustomerDTO;
import com.personal.TravelPlanner.entity.customer.Customer;

public interface CustomerService {
    CustomerDTO save(CustomerDTO customer);
}
