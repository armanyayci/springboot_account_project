package com.project1.account.Business.abstracts;

import com.project1.account.DTO.Customer.CreateCustomerDTO;
import com.project1.account.DTO.Customer.CustomerViewDTO;
import com.project1.account.DTO.Customer.UpdateCustomerDTO;

import java.util.List;


public interface CustomerService {


    CustomerViewDTO createCustomer(CreateCustomerDTO createCustomerDTO);

    CustomerViewDTO getCustomer(int id);

    List<CustomerViewDTO> getCustomerList();

    CustomerViewDTO updateCustomer(int id , UpdateCustomerDTO updateCustomerDTO);

    void deleteCustomer(int id);






}
