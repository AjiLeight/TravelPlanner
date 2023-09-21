package com.personal.TravelPlanner.repository.Customer;

import com.personal.TravelPlanner.entity.customer.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer,String> {

}
