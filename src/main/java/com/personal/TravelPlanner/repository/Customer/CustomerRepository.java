package com.personal.TravelPlanner.repository.Customer;

import com.personal.TravelPlanner.entity.customer.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customer,String> {



    Customer findByEmail(String email);


    Customer deleteByEmail(String email);

}
