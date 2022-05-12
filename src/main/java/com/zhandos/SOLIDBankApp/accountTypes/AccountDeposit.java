package com.zhandos.SOLIDBankApp.accountTypes;

import com.zhandos.SOLIDBankApp.Account;
import com.zhandos.SOLIDBankApp.AccountType;

public class AccountDeposit extends Account {
    public AccountDeposit(AccountType accountType, String id, String clientID, double balance) {
        super(accountType, id, clientID, balance, false);
    }
}
