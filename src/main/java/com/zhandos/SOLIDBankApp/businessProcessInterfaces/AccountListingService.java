package com.zhandos.SOLIDBankApp.businessProcessInterfaces;

import com.zhandos.SOLIDBankApp.Account;
import com.zhandos.SOLIDBankApp.AccountType;
import com.zhandos.SOLIDBankApp.accountTypes.AccountWithdraw;

import java.util.List;

public interface AccountListingService {
    public Account getClientAccount(String clientID, String accountID);
    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID);
    public List<Account> getClientAccounts(String clientID);
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType);
}
