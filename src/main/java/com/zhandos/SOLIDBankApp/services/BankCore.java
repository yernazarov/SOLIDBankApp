package com.zhandos.SOLIDBankApp.services;

import com.zhandos.SOLIDBankApp.services.AccountCreationService;

public class BankCore {
    private static long id = 1;
    private long lastAccountNumber = 1;
    private AccountCreationService accountCreation;
    public BankCore(AccountCreationService accountCreation){ //AccountCreation in UML diagram
        this.accountCreation = accountCreation;
    }

    public void createNewAccount(String accountType, int clientID) {
        String accountID = String.format("%03d%06d", clientID, lastAccountNumber);
        accountCreation.create(accountType, id, clientID, accountID);
        incrementLastAccountNumber();
        System.out.println("Bank account created");
    }

    private void incrementLastAccountNumber() {
        lastAccountNumber++;
    }
}
