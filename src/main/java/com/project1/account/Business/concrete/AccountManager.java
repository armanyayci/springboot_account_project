package com.project1.account.Business.concrete;

import com.project1.account.Business.abstracts.AccountService;
import com.project1.account.DTO.AccountViewDTO;
import com.project1.account.Entity.Account;
import com.project1.account.Exception.NotFoundException;
import com.project1.account.Repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountManager implements AccountService {

    private AccountRepository accountRepository;
    public AccountManager(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountViewDTO getAccountById(int id) {

        Account account = accountRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Invalid id !"));
        return AccountViewDTO.AccountConverter(account);
    }






}





















