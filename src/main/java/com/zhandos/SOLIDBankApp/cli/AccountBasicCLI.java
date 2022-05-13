package com.zhandos.SOLIDBankApp.cli;

import com.zhandos.SOLIDBankApp.account.Account;
import com.zhandos.SOLIDBankApp.account.AccountType;
import com.zhandos.SOLIDBankApp.BankCore;
import com.zhandos.SOLIDBankApp.businessProcessInterfaces.AccountListingService;
import com.zhandos.SOLIDBankApp.ui.CreateAccountOperationUI;

import java.util.List;
import java.util.stream.Collectors;

public class AccountBasicCLI {
    private CreateAccountOperationUI createAccountOperationUI;
    private BankCore bankCore;
    private AccountListingService accountListing;

    public AccountBasicCLI(CreateAccountOperationUI createAccountOperationUI, BankCore bankCore, AccountListingService accountListing) {
        this.createAccountOperationUI = createAccountOperationUI;
        this.bankCore = bankCore;
        this.accountListing = accountListing;
    }

    public void createAccountRequest(String clientID) {
        AccountType accountType = createAccountOperationUI.requestAccountType();
        if (accountType == null) {
            return;
        }
        bankCore.createNewAccount(accountType, clientID);
    }

    public void getAccounts(String clientID) {
        List<Account> clientAccounts = accountListing.getClientAccounts(clientID);
        System.out.print("[");
        System.out.print(clientAccounts.stream().
                map(Object::toString).
                collect(Collectors.joining(", ")));
        System.out.println(']');
    }
}