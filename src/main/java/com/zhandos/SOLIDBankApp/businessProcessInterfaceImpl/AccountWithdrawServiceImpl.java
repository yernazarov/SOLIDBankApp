package com.zhandos.SOLIDBankApp.businessProcessInterfaceImpl;

import com.zhandos.SOLIDBankApp.Account;
import com.zhandos.SOLIDBankApp.AccountDAO;
import com.zhandos.SOLIDBankApp.accountTypes.AccountWithdraw;
import com.zhandos.SOLIDBankApp.businessProcessInterfaces.AccountWithdrawService;

public class AccountWithdrawServiceImpl implements AccountWithdrawService {
    private AccountDAO accountDAO;

    public AccountWithdrawServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public void withdraw(double amount, AccountWithdraw account) {
        if (account.getBalance() > amount) {
            account.setBalance(amount-account.getBalance());
        } else {
            System.out.println("You do not have sufficient funds for this operation");
        }
    }
}
