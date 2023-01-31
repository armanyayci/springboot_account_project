package com.project1.account.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Accounts")
public class Account {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "acc_balance")
    private int balance;

    @Column(name = "acc_creation_date")
    private String creation_date;

}