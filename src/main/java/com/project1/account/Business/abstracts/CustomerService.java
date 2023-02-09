package com.project1.account.Business.abstracts;

import com.project1.account.DTO.CreateCustomerDTO;
import com.project1.account.DTO.CustomerViewDTO;
import com.project1.account.Repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerService {


    CustomerViewDTO createCustomer(CreateCustomerDTO createCustomerDTO);

    CustomerViewDTO getCustomer(int id);

    List<CustomerViewDTO> getCustomerList();






}
