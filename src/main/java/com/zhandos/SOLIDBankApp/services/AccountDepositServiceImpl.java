package com.zhandos.SOLIDBankApp.services;

import com.zhandos.SOLIDBankApp.entities.Account;

import com.zhandos.SOLIDBankApp.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountDepositServiceImpl implements AccountDepositService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void deposit(double amount, Account account) {
        accountRepository.updateAccount(account.getId(), account.getBalance()+amount);
    }
}
