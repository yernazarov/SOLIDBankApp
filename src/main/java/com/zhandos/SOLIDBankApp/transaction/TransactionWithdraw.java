package com.zhandos.SOLIDBankApp.transaction;

import com.zhandos.SOLIDBankApp.account.accountTypes.AccountWithdraw;
import com.zhandos.SOLIDBankApp.businessProcessInterfaces.AccountWithdrawService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

public class TransactionWithdraw {
    private AccountWithdrawService accountWithdrawService;
    @Autowired
    private TransactionRepository transactionRepository;

    public TransactionWithdraw(AccountWithdrawService accountWithdrawService) {
        this.accountWithdrawService = accountWithdrawService;
    }

    public void execute(AccountWithdraw account, double amount) {
        if (account.getBalance() > amount) {
            accountWithdrawService.withdraw(amount, account);
            transactionRepository.addTransaction(account.getId(), amount, "withdraw");
//            Transaction lastTransaction = transactionDAO.getTransactions().get(transactionDAO.getTransactions().size()-1);
//            System.out.println(String.format("%.2f$ transferred from %s account", amount, account.getId()));
        } else {
            System.out.println("You do not have sufficient funds for this operation");
        }

    }
}
