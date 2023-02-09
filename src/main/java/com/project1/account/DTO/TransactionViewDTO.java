package com.project1.account.DTO;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class TransactionViewDTO implements Serializable {
    private int amount;
    private String transaction_date;
}
