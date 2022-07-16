package com.zhandos.SOLIDBankApp.services;

import com.zhandos.SOLIDBankApp.entities.AccountWithdraw;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TransactionWithdrawCLI {
    private TransactionWithdraw transactionWithdraw;
    private WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    private AccountListingService accountListing;

    public void withdrawMoney(int clientID) {
        double amount = withdrawDepositOperationCLIUI.requestClientAmount();
        String accountID = withdrawDepositOperationCLIUI.requestClientAccountID();
        AccountWithdraw account = accountListing.getClientWithdrawAccount(clientID, accountID);
        if (account == null) {
            System.out.println("Error, there was not Withdraw Account found by this ID");
            return;
        }
        try { //todo handle
            transactionWithdraw.execute(account, amount);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
