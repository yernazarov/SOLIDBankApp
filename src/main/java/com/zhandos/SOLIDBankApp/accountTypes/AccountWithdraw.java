package com.zhandos.SOLIDBankApp.accountTypes;

import com.zhandos.SOLIDBankApp.Account;
import com.zhandos.SOLIDBankApp.AccountType;

public class AccountWithdraw extends Account {

    public AccountWithdraw(AccountType accountType, String id, String clientID, double balance) {
        super(accountType, id, clientID, balance, true);
    }

    @Override
    public boolean isWithdrawAllowed() {
        return this.withdrawAllowed;
    }

    @Override
    public void setWithdrawAllowed(boolean withdrawAllowed) {
        this.withdrawAllowed = true;
    }
}
