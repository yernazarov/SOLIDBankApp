package com.zhandos.SOLIDBankApp.cli;

import com.zhandos.SOLIDBankApp.transaction.TransactionWithdraw;
import com.zhandos.SOLIDBankApp.account.accountTypes.AccountWithdraw;
import com.zhandos.SOLIDBankApp.businessProcessInterfaces.AccountListingService;
import com.zhandos.SOLIDBankApp.ui.WithdrawDepositOperationCLIUI;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TransactionWithdrawCLI {
    private TransactionWithdraw transactionWithdraw;
    private WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    private AccountListingService accountListing;

    public void withdrawMoney(String clientID) {
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
