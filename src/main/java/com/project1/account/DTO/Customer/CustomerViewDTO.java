package com.project1.account.DTO.Customer;


import com.project1.account.Entity.Customer;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class CustomerViewDTO implements Serializable {

    private String name;
    private String surname;

    public CustomerViewDTO(String name,String surname){
        this.name=name;
        this.surname=surname;
    }

    public static CustomerViewDTO CustomerConverter(Customer customer){

        return new CustomerViewDTO(customer.getName(),customer.getSurname());
    }
}
