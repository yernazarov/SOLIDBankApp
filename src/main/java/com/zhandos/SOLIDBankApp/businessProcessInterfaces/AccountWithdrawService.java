package com.zhandos.SOLIDBankApp.businessProcessInterfaces;

import com.zhandos.SOLIDBankApp.accountTypes.AccountWithdraw;

public interface AccountWithdrawService {
    void withdraw(double amount, AccountWithdraw account);
}
