package com.personal.TravelPlanner.service.customer.impl;

import com.personal.TravelPlanner.dto.cutomer.CustomerDTO;
import com.personal.TravelPlanner.entity.customer.Customer;
import com.personal.TravelPlanner.repository.Customer.CustomerRepository;
import com.personal.TravelPlanner.repository.UserRepository;
import com.personal.TravelPlanner.service.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final UserRepository userRepository;
    ModelMapper modelMapper = new ModelMapper();
    @Override
    public CustomerDTO save(CustomerDTO customer) {

        Customer saveCustomer =  modelMapper.map(customer,Customer.class);
        customerRepository.save(saveCustomer);
        return customer;

    }

    @Override
    public CustomerDTO update(CustomerDTO customer) {
        Customer existingUser=customerRepository.findByEmail(customer.getEmail());
        existingUser.setFirstname(customer.getFirstname());
        existingUser.setLastname(customer.getLastname());
        existingUser.setPhone(customer.getPhone());
        existingUser.setEmail(customer.getEmail());
        customerRepository.save(existingUser);
       return  modelMapper.map(existingUser,CustomerDTO.class);
    }

    @Override
    public String delete(String email) {
        //delete from auth table
        userRepository.deleteByEmail(email);
        //delete from customer table
        Customer customer =customerRepository.deleteByEmail(email);
        return customer.getEmail();
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {

        return customerRepository
                .findAll()
                .stream()
                .map(customer->modelMapper.map(customer,CustomerDTO.class))
                .toList();

    }

    @Override
    public CustomerDTO getCustomerByEmail(String email) {
        Customer customer =customerRepository.findByEmail(email);
        return modelMapper.map(customer,CustomerDTO.class);



    }
}
