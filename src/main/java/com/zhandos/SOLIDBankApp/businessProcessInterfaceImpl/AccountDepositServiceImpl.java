package com.zhandos.SOLIDBankApp.businessProcessInterfaceImpl;

import com.zhandos.SOLIDBankApp.account.Account;
import com.zhandos.SOLIDBankApp.account.AccountDAO;
import com.zhandos.SOLIDBankApp.account.MemoryAccountDAO;
import com.zhandos.SOLIDBankApp.businessProcessInterfaces.AccountDepositService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountDepositServiceImpl implements AccountDepositService {

    @Autowired
    private AccountDAO accountDAO;

    @Override
    public void deposit(double amount, Account account) {
        accountDAO.updateAccount(account, account.getBalance()+amount);
    }
}
