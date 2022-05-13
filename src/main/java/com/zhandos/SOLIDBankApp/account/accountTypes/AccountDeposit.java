package com.zhandos.SOLIDBankApp.account.accountTypes;

import com.zhandos.SOLIDBankApp.account.Account;
import com.zhandos.SOLIDBankApp.account.AccountType;

public class AccountDeposit extends Account {
    public AccountDeposit(AccountType accountType, String id, String clientID, double balance) {
        super(accountType, id, clientID, balance, false);
    }
}
