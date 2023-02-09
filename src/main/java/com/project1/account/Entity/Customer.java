package com.project1.account.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;
    @Column(name = "password")
    private String password;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "customer",
            targetEntity = Account.class
    )
    //private Set Account = new HashSet();
    private List<Account> accounts;


    public Customer(String name, String surname, String password) {
        this.name = name;
        this.surname = surname;
        this.password=password;
    }
}
