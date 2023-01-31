package com.project1.account.DTO;



import com.project1.account.Entity.Account;
import lombok.Getter;


import java.time.LocalDateTime;

@Getter
public class AccountViewDTO {

    private final int balance;
    private final LocalDateTime creation_date;

    private AccountViewDTO(int balance, LocalDateTime creation_date)
    {
        this.balance = balance;
        this.creation_date = creation_date;
    }

    public static AccountViewDTO AccountConverter(Account account)
    {
        return new AccountViewDTO(account.getBalance(),account.getCreation_date());
    }


}
