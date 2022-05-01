package com.zhandos.SOLIDBankApp;

public class BankCore {
    private static long id = 1; //is the id same for every client?
    private long lastAccountNumber = 1;
    private AccountCreationService accountCreation;

    public BankCore(AccountCreationService accountCreation){ //AccountCreation in UML diagram
        this.accountCreation = accountCreation;
    }

    public void createNewAccount(AccountType accountType, String clientID) {
        //TODO: implement the method
    }

    private void incrementLastAccountNumber() {
        //TODO: implement the method
    }
}
