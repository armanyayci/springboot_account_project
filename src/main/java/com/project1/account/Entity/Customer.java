package com.project1.account.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Customer")
public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "customer_name")
    private String c_name;

    @Column(name = "customer_surname")
    private String c_surname;




}
