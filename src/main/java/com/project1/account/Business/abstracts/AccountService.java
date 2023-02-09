package com.project1.account.Business.abstracts;

import com.project1.account.DTO.Account.AccountViewDTO;
import com.project1.account.DTO.Account.BalanceAccountDTO;
import com.project1.account.DTO.Account.CreateAccountDTO;

import java.util.List;

public interface AccountService {

    AccountViewDTO getAccountById(int id);
    AccountViewDTO createAccount(CreateAccountDTO createAccountDTO);
    List<AccountViewDTO> listAccount();

    AccountViewDTO updateBalance(int id, BalanceAccountDTO balanceAccountDTO);


}
