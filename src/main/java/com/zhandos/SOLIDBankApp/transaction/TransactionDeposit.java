package com.zhandos.SOLIDBankApp.transaction;

import com.zhandos.SOLIDBankApp.account.Account;
import com.zhandos.SOLIDBankApp.businessProcessInterfaces.AccountDepositService;
import lombok.AllArgsConstructor;
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
