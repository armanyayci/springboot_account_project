package com.project1.account.Controller;

import com.project1.account.Business.abstracts.AccountService;
import com.project1.account.DTO.Account.AccountViewDTO;
import com.project1.account.DTO.Account.CreateAccountDTO;
import com.project1.account.DTO.Account.BalanceAccountDTO;
import com.project1.account.shared.GenericResponse;
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

    @PutMapping("update/{id}")
    public ResponseEntity<GenericResponse> updateBalance(
            @PathVariable("id") int id, @RequestBody BalanceAccountDTO balanceAccountDTO)
    {
        accountService.updateBalance(id,balanceAccountDTO);
        int new_balance = accountService.getAccountById(id).getBalance();
        return ResponseEntity.ok(new GenericResponse("Updated Balance: " + new_balance));
    }



}
