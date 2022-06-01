package com.zhandos.SOLIDBankApp.cli;

import com.zhandos.SOLIDBankApp.account.Account;
import com.zhandos.SOLIDBankApp.transaction.TransactionDeposit;
import com.zhandos.SOLIDBankApp.businessProcessInterfaces.AccountListingService;
import com.zhandos.SOLIDBankApp.ui.WithdrawDepositOperationCLIUI;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TransactionDepositCLI {
    TransactionDeposit transactionDeposit;
    WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    AccountListingService accountListing;

    public void depositMoney(String clientID) {
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
