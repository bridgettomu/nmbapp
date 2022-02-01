package com.nmb.nmbApp.controller;

import com.nmb.nmbApp.calculations.TransactionFeeCalculator;
import com.nmb.nmbApp.dto.AddBranchDTO;
import com.nmb.nmbApp.dto.TransactionCreateDTO;
import com.nmb.nmbApp.dto.UpdateBranchDTO;
import com.nmb.nmbApp.model.Account;
import com.nmb.nmbApp.model.Branch;
import com.nmb.nmbApp.model.Transaction;
import com.nmb.nmbApp.service.iface.AccountService;
import com.nmb.nmbApp.service.iface.BranchService;
import com.nmb.nmbApp.service.iface.TransactionService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/transaction",produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class TransactionController {
    private final TransactionService service;
    private final AccountService accountService;
    private final ModelMapper modelMapper;

    @PostMapping("/add")
    public ResponseEntity<Transaction> addTransaction(@RequestBody TransactionCreateDTO transactionCreateDTO){
        Transaction transaction = modelMapper.map(transactionCreateDTO,Transaction.class);
        //getAccounts
        Account creditAccount = accountService.findAccountByAccountNumber(transactionCreateDTO.getCreditAccountNumber());
        Account debitAccount = accountService.findAccountByAccountNumber(transactionCreateDTO.getDebitAccountNumber());

        //setAccounts
        transaction.setCreditAccount(creditAccount);
        transaction.setDebitAccount(debitAccount);

        //calculate charges
        TransactionFeeCalculator transactionFeeCalculator = new TransactionFeeCalculator();
        transactionFeeCalculator.getDebitTransactionCharge(transaction.getDebitAmount());

        return ResponseEntity.ok(service.add(transaction));
    }

    @GetMapping("/get-all")
    @ResponseStatus(HttpStatus.OK)
    public List<Transaction> getAllTransactions(){
        return service.getAll();
    }

    @DeleteMapping("/one/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOneTransaction(@PathVariable("id") Long id){
        service.deleteOne(id);
    }

    @DeleteMapping("/delete-all")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAllTransactions(){
        service.deleteAll();
    }
}
