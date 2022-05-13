package com.zhandos.SOLIDBankApp.businessProcessInterfaces;

import com.zhandos.SOLIDBankApp.account.Account;
import com.zhandos.SOLIDBankApp.account.AccountType;
import com.zhandos.SOLIDBankApp.account.accountTypes.AccountWithdraw;

import java.util.List;

public interface AccountListingService {
    Account getClientAccount(String clientID, String accountID);
    AccountWithdraw getClientWithdrawAccount(String clientID, String accountID);
    List<Account> getClientAccounts(String clientID);
    List<Account> getClientAccountsByType(String clientID, AccountType accountType);
}
