package com.nmb.nmbApp.service.impl;

import com.nmb.nmbApp.model.Branch;
import com.nmb.nmbApp.model.Transaction;
import com.nmb.nmbApp.repository.TransactionRepository;
import com.nmb.nmbApp.service.iface.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository repository;

    @Override
    public Transaction add(Transaction transaction) {
        return repository.save(transaction);
    }

    @Override
    public Transaction getOne(Long transactionId) {
        Optional<Transaction> transaction = repository.findById(transactionId);
        if (transaction.isEmpty()) throw new EntityNotFoundException("transaction Not Found");

        return transaction.get();
    }

    @Override
    public void deleteOne(Long transactionId) {
        repository.deleteById(transactionId);

    }

    @Override
    public void deleteAll() {
        repository.deleteAll();

    }

    @Override
    public List<Transaction> getAll() {
        List<Transaction> transactions = repository.findAll();
        if (transactions.isEmpty()) throw new EntityNotFoundException("transactions Not Available");
        return transactions;
    }
}
