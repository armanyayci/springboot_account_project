package com.project1.account.Api;

import com.project1.account.Business.abstracts.TransactionService;
import com.project1.account.DTO.Transaction.CreateTransactionDTO;
import com.project1.account.DTO.Transaction.TransactionViewDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("get/{id}")
    public ResponseEntity<TransactionViewDTO> getTransaction(@PathVariable("id") int id){

        return ResponseEntity.ok(transactionService.getTransaction(id));
    }

    @PostMapping("create")
    public ResponseEntity<TransactionViewDTO> createTransaction(@RequestBody CreateTransactionDTO createTransactionDTO)
    {
        return ResponseEntity.ok(transactionService.createTransaction(createTransactionDTO));
    }

    @GetMapping("list")
    public ResponseEntity<List<TransactionViewDTO>> listTransactions()
    {
        return ResponseEntity.ok(transactionService.listTransactions());
    }















}
