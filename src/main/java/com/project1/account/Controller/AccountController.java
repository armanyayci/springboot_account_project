package com.project1.account.Controller;

import com.project1.account.Business.abstracts.AccountService;
import com.project1.account.DTO.AccountViewDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/get-account/{id}")
    public ResponseEntity<AccountViewDTO> account(@PathVariable int id){

        AccountViewDTO account = accountService.getAccountById(id);
        return ResponseEntity.ok(account);
    }

}
