package com.zhandos.SOLIDBankApp.cli;

import com.zhandos.SOLIDBankApp.account.Account;
import com.zhandos.SOLIDBankApp.transaction.TransactionDeposit;
import com.zhandos.SOLIDBankApp.businessProcessInterfaces.AccountListingService;
import com.zhandos.SOLIDBankApp.ui.WithdrawDepositOperationCLIUI;

public class TransactionDepositCLI {
    TransactionDeposit transactionDeposit;
    WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    AccountListingService accountListing;

    public TransactionDepositCLI(TransactionDeposit transactionDeposit, WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI,
                                 AccountListingService accountListing) {
        this.transactionDeposit = transactionDeposit;
        this.withdrawDepositOperationCLIUI = withdrawDepositOperationCLIUI;
        this.accountListing = accountListing;
    }

    public void depositMoney(String clientID) {
        double amount = withdrawDepositOperationCLIUI.requestClientAmount();
        String accountID = withdrawDepositOperationCLIUI.requestClientAccountNumber();
        Account account = accountListing.getClientAccount(clientID, accountID);
        if (account == null) {
            System.out.println("Error, you entered wrong account number");
            return;
        }
        transactionDeposit.execute(account, amount);
    }
}
