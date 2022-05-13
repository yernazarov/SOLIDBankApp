package com.zhandos.SOLIDBankApp.businessProcessInterfaceImpl;

import com.zhandos.SOLIDBankApp.account.Account;
import com.zhandos.SOLIDBankApp.account.AccountDAO;
import com.zhandos.SOLIDBankApp.account.AccountType;
import com.zhandos.SOLIDBankApp.account.accountTypes.AccountWithdraw;
import com.zhandos.SOLIDBankApp.businessProcessInterfaces.AccountListingService;

import java.util.List;

public class AccountListingServiceImpl implements AccountListingService {
    private AccountDAO accountDAO;

    //this constructor is not specified in the UML diagram, however I added it because without it, logic would be incomplete
    public AccountListingServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public Account getClientAccount(String clientID, String accountID) {
        return accountDAO.getClientAccount(clientID, accountID);
    }

    @Override
    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID) {
        return accountDAO.getClientWithdrawAccount(clientID, accountID);
    }

    @Override
    public List<Account> getClientAccounts(String clientID) {
        return accountDAO.getClientAccounts(clientID);
    }

    @Override
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType) {
        return accountDAO.getClientAccountsByType(clientID, accountType);
    }
}
