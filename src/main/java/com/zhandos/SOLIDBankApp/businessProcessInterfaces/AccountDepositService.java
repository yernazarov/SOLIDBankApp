package com.zhandos.SOLIDBankApp.businessProcessInterfaces;

import com.zhandos.SOLIDBankApp.account.Account;

public interface AccountDepositService {
    void deposit(double amount, Account account);
}
