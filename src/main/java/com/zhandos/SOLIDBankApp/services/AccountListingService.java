package com.zhandos.SOLIDBankApp.services;

import com.zhandos.SOLIDBankApp.entities.Account;
import com.zhandos.SOLIDBankApp.entities.AccountWithdraw;

import java.util.List;

public interface AccountListingService {
    Account getClientAccount(int clientID, String accountID);
    AccountWithdraw getClientWithdrawAccount(int clientID, String accountID);
    List<Account> getClientAccounts(int clientID);
    List<Account> getClientAccountsByType(int clientID, String accountType);
    Account getAccount(String accountID);

}
