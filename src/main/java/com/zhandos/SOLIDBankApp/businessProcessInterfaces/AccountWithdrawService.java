package com.zhandos.SOLIDBankApp.businessProcessInterfaces;

import com.zhandos.SOLIDBankApp.account.accountTypes.AccountWithdraw;

public interface AccountWithdrawService {
    void withdraw(double amount, AccountWithdraw account);
}
