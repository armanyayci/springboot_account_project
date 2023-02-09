package com.project1.account.DTO.Account;



import com.project1.account.Entity.Account;
import com.project1.account.Entity.Customer;
import lombok.Getter;


import java.io.Serializable;
import java.util.Date;

@Getter
public class AccountViewDTO implements Serializable {

    private int balance;
    private Date creation_date;
    private String customer;

    private AccountViewDTO(int balance, Date creation_date, Customer customer)
    {
        this.balance = balance;
        this.creation_date = creation_date;
        this.customer= customer.getName() + " " + customer.getSurname();
    }

    public static AccountViewDTO AccountConverter(Account account)
    {
        return new AccountViewDTO(account.getBalance(),account.getCreation_date(),account.getCustomer());
    }


}
