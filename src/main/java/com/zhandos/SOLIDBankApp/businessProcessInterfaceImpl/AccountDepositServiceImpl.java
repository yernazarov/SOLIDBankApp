package com.zhandos.SOLIDBankApp.businessProcessInterfaceImpl;

import com.zhandos.SOLIDBankApp.account.Account;
import com.zhandos.SOLIDBankApp.account.AccountDAO;
import com.zhandos.SOLIDBankApp.businessProcessInterfaces.AccountDepositService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AccountDepositServiceImpl implements AccountDepositService {
    private AccountDAO accountDAO;

    @Override
    public void deposit(double amount, Account account) {
        account.setBalance(account.getBalance()+amount);
    }
}
