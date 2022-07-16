package com.zhandos.SOLIDBankApp.services;

import com.zhandos.SOLIDBankApp.repositories.AccountRepository;
import com.zhandos.SOLIDBankApp.entities.AccountWithdraw;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountWithdrawServiceImpl implements AccountWithdrawService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void withdraw(double amount, AccountWithdraw account) {
        accountRepository.updateAccount(account.getId(), account.getBalance()-amount);
    }
}
