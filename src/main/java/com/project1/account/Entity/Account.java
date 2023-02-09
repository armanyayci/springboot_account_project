package com.project1.account.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "Accounts")
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(generator = "account",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "account", sequenceName = "account_generator")
    private int id;

    @Column(name = "acc_balance")
    private int balance;

    @Column(name = "acc_creation_date")
    @Temporal(TemporalType.DATE)
    private Date creation_date;

    @JoinColumn(
            name = "Customer_id",
            foreignKey = @ForeignKey(
                    name = "FK_Customer_ID",
                    value = ConstraintMode.CONSTRAINT
            )
    )
    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false
    )
    private Customer customer;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "account",
            targetEntity = Transaction.class
    )
    private Set<Transaction> transactions = new HashSet();

    public Account(int balance, Date creation_date, Customer customer) {
        this.balance = balance;
        this.creation_date = creation_date;
        this.customer = customer;
    }
}
