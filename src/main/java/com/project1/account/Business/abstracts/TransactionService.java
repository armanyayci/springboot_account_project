package com.project1.account.Business.abstracts;
import com.project1.account.DTO.Transaction.CreateTransactionDTO;
import com.project1.account.DTO.Transaction.TransactionViewDTO;

import java.util.List;

public interface TransactionService {

    TransactionViewDTO getTransaction(int id);

    TransactionViewDTO createTransaction(CreateTransactionDTO createTransactionDTO);

    List<TransactionViewDTO> listTransactions();



}
