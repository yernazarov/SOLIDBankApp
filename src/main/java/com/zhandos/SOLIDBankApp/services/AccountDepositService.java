package com.zhandos.SOLIDBankApp.services;

import com.zhandos.SOLIDBankApp.entities.Account;

public interface AccountDepositService {
    void deposit(double amount, Account account);
}
