package com.zhandos.SOLIDBankApp;

import com.zhandos.SOLIDBankApp.accountTypes.AccountWithdraw;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemoryAccountDAO implements AccountDAO{
    private List<Account> accountList = new ArrayList<Account>();

    @Override
    public List<Account> getClientAccounts(String clientID) {
        return this.accountList.stream()
                .filter(x -> x.getClientID() == clientID)
                .collect(Collectors.toList());
    }

    @Override
    public void createNewAccount(Account account) {
        this.accountList.add(account);
    }

    @Override
    public void updateAccount(Account account) {
        Account accountToBeUpdated = accountList.stream()
                .filter(x -> account.getId() == x.getId())
                .findAny()
                .orElse(null);
        System.out.println("This feature is not represented properly in the UML diagram");
    }

    @Override
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType) {
        List<Account> accountsByType = this.accountList.stream()
                .filter(x -> x.getAccountType() == accountType)
                .filter(x -> x.getClientID() == clientID)
                .collect(Collectors.toList());
        return accountsByType;
    }

    @Override
    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID) {
        return (AccountWithdraw) accountList.stream()
                .filter(x -> x.getClientID() == clientID)
                .filter(x -> x.getId() == accountID)
                .filter(x -> x.getAccountType().name == "CHECKING" || x.getAccountType().name == "SAVING")
                .findAny()
                .orElse(null);
    }

    @Override
    public Account getClientAccount(String clientID, String accountID) {
        return accountList.stream()
                .filter(x -> x.getClientID() == clientID)
                .filter(x -> x.getId() == accountID)
                .findAny()
                .orElse(null);
    }
}
