package com.zhandos.SOLIDBankApp.businessProcessInterfaces;

import com.zhandos.SOLIDBankApp.Account;

public interface AccountDepositService {
    void deposit(double amount, Account account);
}
