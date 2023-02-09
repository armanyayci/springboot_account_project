package com.project1.account.Business.concrete;

import com.project1.account.Business.abstracts.AccountService;
import com.project1.account.DTO.Account.AccountViewDTO;
import com.project1.account.DTO.Account.CreateAccountDTO;
import com.project1.account.Entity.Account;
import com.project1.account.Entity.Customer;
import com.project1.account.Exception.NotFoundException;
import com.project1.account.Repository.AccountRepository;
import com.project1.account.Repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountManager implements AccountService {

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;
    public AccountManager(AccountRepository accountRepository,CustomerRepository customerRepository) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public AccountViewDTO getAccountById(int id) {

        Account account = accountRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Invalid id !"));
        return AccountViewDTO.AccountConverter(account);
    }

    @Override
    public AccountViewDTO createAccount(CreateAccountDTO createAccountDTO) {

        Date date = new Date();
        Customer customer = customerRepository.findById(createAccountDTO.getCustomer_id()).
                orElseThrow(()-> new NotFoundException("Invalid CustomerID") );

        Account account = accountRepository.save(new Account(
                createAccountDTO.getBalance(),date,customer
        ));
        return AccountViewDTO.AccountConverter(account);
    }

    @Override
    public List<AccountViewDTO> listAccount() {

        return accountRepository.findAll().
                stream().map(AccountViewDTO::AccountConverter).collect(Collectors.toList());

    }
}





















