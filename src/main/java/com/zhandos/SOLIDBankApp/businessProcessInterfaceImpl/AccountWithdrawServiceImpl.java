package com.zhandos.SOLIDBankApp.businessProcessInterfaceImpl;

import com.zhandos.SOLIDBankApp.account.AccountDAO;
import com.zhandos.SOLIDBankApp.account.accountTypes.AccountWithdraw;
import com.zhandos.SOLIDBankApp.businessProcessInterfaces.AccountWithdrawService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AccountWithdrawServiceImpl implements AccountWithdrawService {
    private AccountDAO accountDAO;

    @Override
    public void withdraw(double amount, AccountWithdraw account) {
        account.setBalance(account.getBalance()-amount);
    }
}
