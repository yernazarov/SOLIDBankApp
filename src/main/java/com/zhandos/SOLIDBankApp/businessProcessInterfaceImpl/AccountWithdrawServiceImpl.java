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
        if (account.getBalance() > amount) {
            account.setBalance(amount-account.getBalance());
        } else {
            System.out.println("You do not have sufficient funds for this operation");
        }
    }
}
