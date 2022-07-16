package com.zhandos.SOLIDBankApp.entities;

import com.zhandos.SOLIDBankApp.entities.Account;

public class AccountWithdraw extends Account {
    public AccountWithdraw(String accountType, String id, int clientID, double balance) {
        super(accountType, id, clientID, balance, true);
    }
}
