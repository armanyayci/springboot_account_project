package com.project1.account.Business.concrete;

import com.project1.account.Business.abstracts.CustomerService;
import com.project1.account.DTO.CreateCustomerDTO;
import com.project1.account.DTO.CustomerViewDTO;
import com.project1.account.Entity.Customer;
import com.project1.account.Exception.NotFoundException;
import com.project1.account.Repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerManager implements CustomerService {

    private final CustomerRepository customerRepository;
    public CustomerManager(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public CustomerViewDTO createCustomer(CreateCustomerDTO createCustomerDTO) {

        Customer customer = customerRepository.save(new Customer(
                createCustomerDTO.getName(),
                createCustomerDTO.getSurname(),
                createCustomerDTO.getPassword()));

        return CustomerViewDTO.CustomerConverter(customer);
    }

    @Override
    public CustomerViewDTO getCustomer(int id) {

        Customer customer = customerRepository.findById(id).
                orElseThrow(()-> new NotFoundException("Invalid id"));

        return CustomerViewDTO.CustomerConverter(customer);
    }

    @Override
    public List<CustomerViewDTO> getCustomerList() {

        return customerRepository.findAll().stream()
                .map(CustomerViewDTO::CustomerConverter)
                .collect(Collectors.toList());
    }
}














