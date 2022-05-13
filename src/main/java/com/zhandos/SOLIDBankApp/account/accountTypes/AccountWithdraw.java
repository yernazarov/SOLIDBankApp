package com.zhandos.SOLIDBankApp.account.accountTypes;

import com.zhandos.SOLIDBankApp.account.Account;
import com.zhandos.SOLIDBankApp.account.AccountType;

public class AccountWithdraw extends Account {

    public AccountWithdraw(AccountType accountType, String id, String clientID, double balance) {
        super(accountType, id, clientID, balance, true);
    }
}
