package com.project1.account.Business.abstracts;

import com.project1.account.DTO.AccountViewDTO;
import com.project1.account.DTO.CreateAccountDTO;
import com.project1.account.DTO.CreateCustomerDTO;

public interface AccountService {

    AccountViewDTO getAccountById(int id);

    AccountViewDTO createAccount(CreateAccountDTO createAccountDTO);

}
