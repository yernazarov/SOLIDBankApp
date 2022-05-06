package com.zhandos.SOLIDBankApp;

import com.zhandos.SOLIDBankApp.accountTypes.AccountWithdraw;

import java.util.List;

public interface AccountDAO {
    public List<Account> getClientAccounts(String clientID);
    public void createNewAccount(Account account);
    public void updateAccount(Account account);
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType);
    AccountWithdraw getClientWithdrawAccount(String clientID, String accountID);
    Account getClientAccount(String clientID, String accountID);
}
