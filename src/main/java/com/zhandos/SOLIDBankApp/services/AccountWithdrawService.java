package com.zhandos.SOLIDBankApp.services;

import com.zhandos.SOLIDBankApp.entities.AccountWithdraw;

public interface AccountWithdrawService {
    void withdraw(double amount, AccountWithdraw account);
}
