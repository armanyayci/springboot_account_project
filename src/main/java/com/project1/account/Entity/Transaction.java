package com.project1.account.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Transaction")
@Data
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "amount")
    private int amount;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            optional = false
    )
    @JoinColumn(
            name = "Account_ID",
            foreignKey = @ForeignKey(
                    name = "FK_Account_ID"
            )
    )
    private Account account;

    public Transaction(int amount, Date date, Account account) {
        this.amount = amount;
        this.date = date;
        this.account = account;
    }
}
