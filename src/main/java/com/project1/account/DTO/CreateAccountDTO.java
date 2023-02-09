package com.project1.account.DTO;

import com.project1.account.Entity.Customer;
import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Data
public class CreateAccountDTO {
    private int balance;
    private int customer_id;
}
