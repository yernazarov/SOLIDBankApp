package com.zhandos.SOLIDBankApp.businessProcessInterfaceImpl;

import com.zhandos.SOLIDBankApp.account.Account;

import com.zhandos.SOLIDBankApp.account.AccountRepository;
import com.zhandos.SOLIDBankApp.businessProcessInterfaces.AccountDepositService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountDepositServiceImpl implements AccountDepositService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void deposit(double amount, Account account) {
        accountRepository.updateAccount(account.getId(), account.getBalance()+amount);
    }
}
