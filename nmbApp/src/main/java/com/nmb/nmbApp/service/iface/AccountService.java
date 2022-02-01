package com.nmb.nmbApp.service.iface;

import com.nmb.nmbApp.model.Account;

import java.util.List;

public interface AccountService {
    Account add(Account account);
    Account update(Account account);
    Account getOne(Long accountId);
    void deleteOne(Long accountId);
    void deleteAll();
    List<Account> getAll();
    List<Account> findAllByBranch_Id(Long branchId);
    Account findAccountByAccountNumber(String accountNumber);

    Account getBiweeklyInterest(Account account);

    Account getMonthlyInterest(Account account);


}
