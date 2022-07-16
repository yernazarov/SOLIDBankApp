package com.zhandos.SOLIDBankApp.services.cli;

import com.zhandos.SOLIDBankApp.entities.Account;
import com.zhandos.SOLIDBankApp.services.BankCore;
import com.zhandos.SOLIDBankApp.services.AccountListingService;
import com.zhandos.SOLIDBankApp.services.CreateAccountOperationUI;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class AccountBasicCLI {
    private CreateAccountOperationUI createAccountOperationUI;
    private BankCore bankCore;
    private AccountListingService accountListing;

    public void createAccountRequest(int clientID) {
        String accountType = createAccountOperationUI.requestAccountType();
        if (accountType == null) {
            return;
        }
        bankCore.createNewAccount(accountType, clientID);
    }

    public void getAccounts(int clientID) {
        List<Account> clientAccounts = accountListing.getClientAccounts(clientID);
        System.out.print("[");
        System.out.print(clientAccounts.stream().
                map(Object::toString).
                collect(Collectors.joining(", ")));
        System.out.println(']');
    }
}
