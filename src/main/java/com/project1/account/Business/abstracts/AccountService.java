package com.project1.account.Business.abstracts;

import com.project1.account.DTO.AccountViewDTO;

public interface AccountService {

    AccountViewDTO getAccountById(int id);
}
