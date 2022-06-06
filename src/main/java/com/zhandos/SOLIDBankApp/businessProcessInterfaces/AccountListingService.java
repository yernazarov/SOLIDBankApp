package com.zhandos.SOLIDBankApp.businessProcessInterfaces;

import com.zhandos.SOLIDBankApp.account.Account;
import com.zhandos.SOLIDBankApp.account.accountTypes.AccountWithdraw;

import java.util.List;

public interface AccountListingService {
    Account getClientAccount(int clientID, String accountID);
    AccountWithdraw getClientWithdrawAccount(int clientID, String accountID);
    List<Account> getClientAccounts(int clientID);
    List<Account> getClientAccountsByType(int clientID, String accountType);
}
