package com.zhandos.SOLIDBankApp;

import com.zhandos.SOLIDBankApp.businessProcessInterfaces.AccountCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public class BankCore {
    private static long id = 1;
    private long lastAccountNumber = 1;
    private AccountCreationService accountCreation;
    public BankCore(AccountCreationService accountCreation){ //AccountCreation in UML diagram
        this.accountCreation = accountCreation;
    }

    public void createNewAccount(String accountType, int clientID) {
        String accountID = String.format("%03d%06d", 1, lastAccountNumber);
        accountCreation.create(accountType, id, clientID, accountID);
        incrementLastAccountNumber();
        System.out.println("Bank account created");
    }

    private void incrementLastAccountNumber() {
        lastAccountNumber++;
    }
}
