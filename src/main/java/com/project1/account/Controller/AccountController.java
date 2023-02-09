package com.project1.account.Controller;

import com.project1.account.Business.abstracts.AccountService;
import com.project1.account.DTO.AccountViewDTO;
import com.project1.account.DTO.CreateAccountDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("get/{id}")
    public ResponseEntity<AccountViewDTO> getAccount(@PathVariable int id){

        AccountViewDTO account = accountService.getAccountById(id);
        return ResponseEntity.ok(account);
    }

    @PostMapping("post")
    public ResponseEntity<AccountViewDTO> createAccount(@RequestBody CreateAccountDTO createAccountDTO){

        AccountViewDTO account = accountService.createAccount(createAccountDTO);
        return ResponseEntity.ok(account);
    }






}
