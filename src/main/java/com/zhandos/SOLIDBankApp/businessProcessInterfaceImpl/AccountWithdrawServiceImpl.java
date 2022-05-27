package com.zhandos.SOLIDBankApp.businessProcessInterfaceImpl;

import com.zhandos.SOLIDBankApp.account.AccountRepository;
import com.zhandos.SOLIDBankApp.account.accountTypes.AccountWithdraw;
import com.zhandos.SOLIDBankApp.businessProcessInterfaces.AccountWithdrawService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountWithdrawServiceImpl implements AccountWithdrawService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void withdraw(double amount, AccountWithdraw account) {
        accountRepository.updateAccount(account.getId(), account.getBalance()-amount);
    }
}
