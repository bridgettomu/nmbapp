package com.nmb.nmbApp.controller;

import com.nmb.nmbApp.dto.AddAccountDTO;
import com.nmb.nmbApp.dto.UpdateAccountDTO;
import com.nmb.nmbApp.model.Account;
import com.nmb.nmbApp.service.iface.AccountService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/account",produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class AccountController {
    private final AccountService accountService;
    private final ModelMapper modelMapper;

    @PostMapping("/add")
    public ResponseEntity<Account> addAccount(@RequestBody AddAccountDTO addAccountDTO){
        Account account = modelMapper.map(addAccountDTO,Account.class);
        return ResponseEntity.ok(accountService.add(account));
    }

    @PutMapping("/update")
    public ResponseEntity<Account> updateAccount(@RequestBody UpdateAccountDTO updateAccountDTO){
        Account account = modelMapper.map(updateAccountDTO,Account.class);
        return ResponseEntity.ok(accountService.update(account));
    }
    @GetMapping("/get-all")
    @ResponseStatus(HttpStatus.OK)
    public List<Account> getAllAccounts(){
        return accountService.getAll();
    }

    @GetMapping("/all/{branch-id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Account> getAllAccountByBranch(@PathVariable("branch-id") Long branchId){
        return accountService.findAllByBranch_Id(branchId);
    }

    @GetMapping("/all/{account-number}")
    @ResponseStatus(HttpStatus.OK)
    public Account getAccountByAccountNumber(@PathVariable("account-number") String accountNumber){
        return accountService.findAccountByAccountNumber(accountNumber);
    }


    @GetMapping("/one/{account-id}")
    @ResponseStatus(HttpStatus.OK)
    public Account getOneAccount(@PathVariable("account-id") Long id){
       return accountService.getOne(id);
    }


    @PutMapping("/one/biweekly-interest{account-id}")
    @ResponseStatus(HttpStatus.OK)
    public Account getAccountBiweeklyInterest(@PathVariable("account-id") Long id){
        Account account =  accountService.getOne(id);
        return accountService.getBiweeklyInterest(account);
    }


    @PutMapping("/one/monthly-interest{account-id}")
    @ResponseStatus(HttpStatus.OK)
    public Account getAccountMonthlyInterest(@PathVariable("account-id") Long id){
        Account account =  accountService.getOne(id);

        return accountService.getMonthlyInterest(account);
    }

    @DeleteMapping("/one/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOneAccount(@PathVariable("id") Long id){
       accountService.deleteOne(id);
    }

    @DeleteMapping("/delete-all")
    @ResponseStatus(HttpStatus.OK)
    public void getOneAccount(){
        accountService.deleteAll();
    }

}
