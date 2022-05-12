package com.zhandos.SOLIDBankApp.cli;

import com.zhandos.SOLIDBankApp.Account;
import com.zhandos.SOLIDBankApp.TransactionWithdraw;
import com.zhandos.SOLIDBankApp.accountTypes.AccountWithdraw;
import com.zhandos.SOLIDBankApp.businessProcessInterfaces.AccountListingService;
import com.zhandos.SOLIDBankApp.ui.WithdrawDepositOperationCLIUI;

public class TransactionWithdrawCLI {
    private TransactionWithdraw transactionWithdraw;
    private WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    private AccountListingService accountListing;

    public TransactionWithdrawCLI(TransactionWithdraw transactionWithdraw, WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI,
                           AccountListingService accountListing) {
        this.transactionWithdraw = transactionWithdraw;
        this.withdrawDepositOperationCLIUI = withdrawDepositOperationCLIUI;
        this.accountListing = accountListing;
    }

    public void withdrawMoney(String clientID) {
        double amount = withdrawDepositOperationCLIUI.requestClientAmount();
        String accountID = withdrawDepositOperationCLIUI.requestClientAccountNumber();
        AccountWithdraw account = accountListing.getClientWithdrawAccount(clientID, accountID);
        if (account == null) {
            System.out.println("Error, you entered wrong account number");
            return;
        }
        transactionWithdraw.execute(account, amount);
    }
}
