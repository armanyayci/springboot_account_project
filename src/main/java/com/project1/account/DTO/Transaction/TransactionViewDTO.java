package com.project1.account.DTO.Transaction;

import com.project1.account.Entity.Transaction;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;

@Getter
public class TransactionViewDTO implements Serializable {
    private int amount;
    private Date date;

    public TransactionViewDTO(int amount, Date date) {
        this.amount = amount;
        this.date = date;
    }

    public static TransactionViewDTO TransactionConverter(Transaction transaction)
    {
        return new TransactionViewDTO(transaction.getAmount(),transaction.getDate());
    }

}
