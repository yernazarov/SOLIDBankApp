package com.zhandos.SOLIDBankApp.entities;

import com.zhandos.SOLIDBankApp.entities.Account;

public class AccountDeposit extends Account {
    public AccountDeposit(String accountType, String id, int clientID, double balance) {
        super(accountType, id, clientID, balance, false);
    }
}
