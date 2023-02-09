package com.project1.account.Business.concrete;

import com.project1.account.Business.abstracts.TransactionService;
import com.project1.account.DTO.Transaction.CreateTransactionDTO;
import com.project1.account.DTO.Transaction.TransactionViewDTO;
import com.project1.account.Entity.Account;
import com.project1.account.Entity.Transaction;
import com.project1.account.Exception.NotFoundException;
import com.project1.account.Repository.AccountRepository;
import com.project1.account.Repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionsManager implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;
    public TransactionsManager(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }
    @Override
    public TransactionViewDTO getTransaction(int id) {

        Transaction transaction = transactionRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Invalid ID"));
        return TransactionViewDTO.TransactionConverter(transaction);
    }
    @Override
    public TransactionViewDTO createTransaction(CreateTransactionDTO createTransactionDTO) {

        Account account = accountRepository.findById(createTransactionDTO.getAccount_id()).
                orElseThrow(()-> new NotFoundException("Invalid Account ID"));
        Date date = new Date();

        if (account.getBalance() > createTransactionDTO.getAmount())
        {
            int new_balance = account.getBalance()-createTransactionDTO.getAmount();
            account.setBalance(new_balance);
            Transaction transaction = transactionRepository.save(new Transaction(
                    createTransactionDTO.getAmount(),
                    date,
                    account));
            return TransactionViewDTO.TransactionConverter(transaction);
        }
        else
            throw new ArithmeticException("Account balance can not be lower than transaction amount !");
    }

    @Override
    public List<TransactionViewDTO> listTransactions() {

        return transactionRepository.findAll().stream().map
                (TransactionViewDTO::TransactionConverter).collect(Collectors.toList());
    }


}
















