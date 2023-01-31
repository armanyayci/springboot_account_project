package com.project1.account.Entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Transaction")
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "transaction_amount")
    private int amount;
    @Column(name = "transaction_date")
    private LocalDateTime transaction_date;

}
