package com.nmb.nmbApp.service.impl;

import com.nmb.nmbApp.calculations.InterestCalculator;
import com.nmb.nmbApp.model.Account;
import com.nmb.nmbApp.repository.AccountRepository;
import com.nmb.nmbApp.service.iface.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {


    private final AccountRepository repository;

    @Override
    public Account add(Account account) {
        return repository.save(account);
    }

    @Override
    public Account update(Account account) {
        Optional<Account> accountFromDB = Optional.ofNullable(getOne(account.getId()));
        if (accountFromDB.isEmpty()) throw new EntityNotFoundException("Account Not Found");
        account.setDateCreated(accountFromDB.get().getDateCreated());
        return repository.save(account);
    }

    @Override
    public Account getOne(Long accountId) {
        Optional<Account> account = repository.findById(accountId);
        if (account.isEmpty()) throw new EntityNotFoundException("Account Not Found");

        return account.get();
    }

    @Override
    public void deleteOne(Long accountId) {
        repository.deleteById(accountId);

    }

    @Override
    public void deleteAll() {
        repository.deleteAll();

    }

    @Override
    public List<Account> getAll() {
        List<Account> accounts = repository.findAll();
        if (accounts.isEmpty()) throw new EntityNotFoundException("Accounts Not Available");
        return accounts;
    }

    @Override
    public List<Account> findAllByBranch_Id(Long branchId) {
        List<Account> accounts = repository.findAllByBranch_Id(branchId);
        if (accounts.isEmpty()) throw new EntityNotFoundException("Accounts Not Available");
        return accounts;
    }

    @Override
    public Account findAccountByAccountNumber(String accountNumber) {
        Optional<Account> account = Optional.ofNullable(repository.findAccountByAccountNumber(accountNumber));
        if (account.isEmpty()) throw new EntityNotFoundException("Account Not Found");

        return account.get();
    }

    @Override
    public Account getBiweeklyInterest(Account account) {
        Optional<Account> accountFromDB = Optional.ofNullable(getOne(account.getId()));
        InterestCalculator interestCalculator = new InterestCalculator();
        if (accountFromDB.get().getDateCreated().isAfter(LocalDate.now().plusWeeks(2)))
            interestCalculator.getBiweeklyInterest(account.getInitialBalance(),account.getCreditAmount());
        account.setDateCreated(accountFromDB.get().getDateCreated());
        return repository.save(account);    }

    @Override
    public Account getMonthlyInterest(Account account) {
        Optional<Account> accountFromDB = Optional.ofNullable(getOne(account.getId()));
        InterestCalculator interestCalculator = new InterestCalculator();
        //calculate monthly interest
        if (accountFromDB.get().getDateCreated().isAfter(LocalDate.now().plusMonths(1)))
            interestCalculator.getMonthlyInterest(account.getInitialBalance(),account.getCreditAmount());
        account.setDateCreated(accountFromDB.get().getDateCreated());
        return repository.save(account);     }
}
