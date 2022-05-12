package com.zhandos.SOLIDBankApp.businessProcessInterfaceImpl;

import com.zhandos.SOLIDBankApp.Account;
import com.zhandos.SOLIDBankApp.AccountDAO;
import com.zhandos.SOLIDBankApp.businessProcessInterfaces.AccountDepositService;

public class AccountDepositServiceImpl implements AccountDepositService {
    private AccountDAO accountDAO;

    public AccountDepositServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public void deposit(double amount, Account account) {
        account.setBalance(account.getBalance()+amount);
    }
}
