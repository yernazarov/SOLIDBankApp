package com.zhandos.SOLIDBankApp.services;

import com.zhandos.SOLIDBankApp.entities.Account;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TransactionDepositCLI {
    TransactionDeposit transactionDeposit;
    WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    AccountListingService accountListing;

    public void depositMoney(int clientID) {
        double amount = withdrawDepositOperationCLIUI.requestClientAmount();
        String accountID = withdrawDepositOperationCLIUI.requestClientAccountID();
        Account account = accountListing.getClientAccount(clientID, accountID);
        if (account == null) {
            System.out.println("Error, you entered wrong account number");
            return;
        }
        transactionDeposit.execute(account, amount);
    }
}
