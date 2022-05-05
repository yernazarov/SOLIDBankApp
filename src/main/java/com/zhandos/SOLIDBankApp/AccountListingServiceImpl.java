package com.zhandos.SOLIDBankApp;

import java.util.List;

public class AccountListingServiceImpl implements AccountListingService{
    private AccountDAO accountDAO;

    @Override
    public Account getClientAccount(String clientID, String accountID) {
        return null;
    }

    @Override
    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID) {
        return null;
    }

    @Override
    public List<Account> getClientAccounts(String clientID) {
        List<Account> result = persons.stream()
                .filter(p -> p.getAge() > 16).collect(Collectors.toList());
        return null;
    }

    @Override
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType) {
        return null;
    }
}
