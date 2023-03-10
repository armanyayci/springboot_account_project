package com.project1.account.Api;

import com.project1.account.Business.abstracts.AccountService;
import com.project1.account.DTO.Account.AccountViewDTO;
import com.project1.account.DTO.Account.CreateAccountDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("create")
    public ResponseEntity<AccountViewDTO> createAccount(@RequestBody CreateAccountDTO createAccountDTO){

        AccountViewDTO account = accountService.createAccount(createAccountDTO);
        return ResponseEntity.ok(account);
    }

    @GetMapping("list")
    public ResponseEntity<List<AccountViewDTO>> listAccounts()
    {
        return ResponseEntity.ok(accountService.listAccount());
    }



}
