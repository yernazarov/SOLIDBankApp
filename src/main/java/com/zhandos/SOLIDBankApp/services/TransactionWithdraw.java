package com.zhandos.SOLIDBankApp.services;

import com.zhandos.SOLIDBankApp.entities.AccountWithdraw;
import com.zhandos.SOLIDBankApp.repositories.TransactionRepository;
import com.zhandos.SOLIDBankApp.services.AccountWithdrawService;
import org.springframework.beans.factory.annotation.Autowired;

public class TransactionWithdraw {
    private AccountWithdrawService accountWithdrawService;
    @Autowired
    private TransactionRepository transactionRepository;

    public TransactionWithdraw(AccountWithdrawService accountWithdrawService) {
        this.accountWithdrawService = accountWithdrawService;
    }

    public void execute(AccountWithdraw account, double amount) throws Exception {
        if (account.getBalance() > amount) {
            accountWithdrawService.withdraw(amount, account);
            transactionRepository.addTransaction(account.getId(), amount, "withdraw");
        } else {
            throw new Exception("You do not have sufficient funds for this operation");
        }

    }
}
