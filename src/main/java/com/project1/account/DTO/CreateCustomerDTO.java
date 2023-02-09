package com.project1.account.DTO;

import lombok.Data;

@Data
public class CreateCustomerDTO {
    private String name;
    private String surname;
    private String password;
}
