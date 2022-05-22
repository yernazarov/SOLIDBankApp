package com.zhandos.SOLIDBankApp.businessProcessInterfaceImpl;

import com.zhandos.SOLIDBankApp.account.AccountDAO;
import com.zhandos.SOLIDBankApp.account.MemoryAccountDAO;
import com.zhandos.SOLIDBankApp.account.accountTypes.AccountWithdraw;
import com.zhandos.SOLIDBankApp.businessProcessInterfaces.AccountWithdrawService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountWithdrawServiceImpl implements AccountWithdrawService {

    @Autowired
    private AccountDAO accountDAO;

    @Override
    public void withdraw(double amount, AccountWithdraw account) {
        accountDAO.updateAccount(account, account.getBalance()-amount);
    }
}
