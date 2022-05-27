package com.zhandos.SOLIDBankApp.businessProcessInterfaceImpl;

import com.zhandos.SOLIDBankApp.account.Account;
import com.zhandos.SOLIDBankApp.account.AccountRepository;
import com.zhandos.SOLIDBankApp.account.accountTypes.AccountWithdraw;
import com.zhandos.SOLIDBankApp.businessProcessInterfaces.AccountListingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AccountListingServiceImpl implements AccountListingService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account getClientAccount(String clientID, long accountID) {
        return accountRepository.getClientAccount(clientID, accountID);
    }

    @Override
    public AccountWithdraw getClientWithdrawAccount(String clientID, long accountID) {
        return accountRepository.getClientWithdrawAccount(clientID, accountID);
    }

    @Override
    public List<Account> getClientAccounts(String clientID) {
        return accountRepository.getClientAccounts(clientID);
    }

    @Override
    public List<Account> getClientAccountsByType(String clientID, String accountType) {
        return accountRepository.getClientAccountsByType(clientID, accountType);
    }
}
