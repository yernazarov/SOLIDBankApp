package com.zhandos.SOLIDBankApp.transaction;

import com.zhandos.SOLIDBankApp.account.accountTypes.AccountWithdraw;
import com.zhandos.SOLIDBankApp.businessProcessInterfaces.AccountWithdrawService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TransactionWithdraw {
    private AccountWithdrawService accountWithdrawService;
    private TransactionDAO transactionDAO;

    public void execute(AccountWithdraw account, double amount) {
        accountWithdrawService.withdraw(amount, account);
        if (account.getBalance() > amount) { // Костыль
            transactionDAO.addTransaction(new Transaction(String.format("%.2f$ transferred from %s account", amount, account.getId())));
            System.out.println(transactionDAO.getTransactions().get(transactionDAO.getTransactions().size() - 1).transaction);
        }

    }
}
