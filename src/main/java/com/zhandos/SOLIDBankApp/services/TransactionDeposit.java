package com.zhandos.SOLIDBankApp.services;

import com.zhandos.SOLIDBankApp.entities.Account;
import com.zhandos.SOLIDBankApp.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TransactionDeposit {
    private AccountDepositService accountDepositService;
    @Autowired
    private TransactionRepository transactionRepository;

    public TransactionDeposit(AccountDepositService accountDepositService) {
        this.accountDepositService =accountDepositService;
    }

    public void execute(Account account, double amount) {
        accountDepositService.deposit(amount, account);
        transactionRepository.addTransaction(account.getId(), amount, "deposit");
//        System.out.println(transactionDAO.getTransactions().get(transactionDAO.getTransactions().size() - 1).transaction);
    }
}
