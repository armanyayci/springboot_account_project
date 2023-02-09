package com.project1.account.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

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
    @Temporal(TemporalType.DATE)
    private Date transaction_date;

    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            optional = false
    )
    @JoinColumn(
            name = "Account_ID",
            foreignKey = @ForeignKey(
                    name = "FK_Account_ID",
                    value = ConstraintMode.CONSTRAINT
            )
    )
    private Account account;





}
