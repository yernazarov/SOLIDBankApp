package com.zhandos.SOLIDBankApp;

import com.zhandos.SOLIDBankApp.accountTypes.AccountWithdraw;
import com.zhandos.SOLIDBankApp.businessProcessInterfaces.AccountDepositService;

public class TransactionDeposit {
    private AccountDepositService accountDepositService;
    private TransactionDAO transactionDAO;

    public TransactionDeposit(AccountDepositService accountDepositService, TransactionDAO transactionDAO) {
        this.accountDepositService = accountDepositService;
        this.transactionDAO = transactionDAO;
    }

    public void execute(Account account, double amount) {
        accountDepositService.deposit(amount, account);
        transactionDAO.addTransaction(new Transaction(String.format("%.2f$ transferred to %s account", amount, account.getId())));
        System.out.println(transactionDAO.getTransactions().get(transactionDAO.getTransactions().size() - 1).transaction);
    }
}
