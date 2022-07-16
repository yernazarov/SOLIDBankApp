package com.zhandos.SOLIDBankApp.entities;

public class SavingAccount extends AccountWithdraw {
    public SavingAccount(String accountType, String id, int clientID, double balance) {
        super(accountType, id, clientID, balance);
    }
}
