package com.zhandos.SOLIDBankApp.account.accountTypes;

import com.zhandos.SOLIDBankApp.account.Account;

public class AccountWithdraw extends Account {
    public AccountWithdraw(String accountType, String id, int clientID, double balance) {
        super(accountType, id, clientID, balance, true);
    }
}
