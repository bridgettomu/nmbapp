package com.nmb.nmbApp.service.iface;

import com.nmb.nmbApp.model.Account;
import com.nmb.nmbApp.model.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction add(Transaction transaction);
    Transaction getOne(Long transactionId);
     List<Transaction> getAll();
     void deleteOne(Long transactionId);
    void deleteAll();
}
