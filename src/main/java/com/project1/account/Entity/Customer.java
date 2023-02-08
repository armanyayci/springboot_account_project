package com.project1.account.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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


    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "customer",
            targetEntity = Account.class
    )
    private Set Account = new HashSet();
    // private List<Account> accounts;




}
