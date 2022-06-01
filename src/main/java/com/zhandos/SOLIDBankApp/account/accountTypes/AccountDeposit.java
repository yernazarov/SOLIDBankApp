package com.zhandos.SOLIDBankApp.account.accountTypes;

import com.zhandos.SOLIDBankApp.account.Account;

public class AccountDeposit extends Account {
    public AccountDeposit(String accountType, String id, String clientID, double balance) {
        super(accountType, id, clientID, balance, false);
    }
}
