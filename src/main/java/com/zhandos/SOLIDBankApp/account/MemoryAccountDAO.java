package com.zhandos.SOLIDBankApp.account;

import com.zhandos.SOLIDBankApp.account.accountTypes.AccountWithdraw;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MemoryAccountDAO implements AccountDAO{
    private List<Account> accountList = new ArrayList<>();

    @Override
    public List<Account> getClientAccounts(String clientID) {
        return this.accountList.stream()
                .filter(x -> x.getClientID().equals(clientID))
                .collect(Collectors.toList());
    }

    @Override
    public void createNewAccount(Account account) {
        this.accountList.add(account);
    }

    @Override
    public void updateAccount(Account account, double amount) {
        account.setBalance(amount);
    }

    @Override
    public List<Account> getClientAccountsByType(String clientID, String accountType) {
        return this.accountList.stream()
                .filter(x -> x.getAccountType() == accountType)
                .filter(x -> x.getClientID().equals(clientID))
                .collect(Collectors.toList());
    }

    @Override
    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID) {
        return (AccountWithdraw) accountList.stream()
                .filter(x -> x.getClientID().equals(clientID))
                .filter(x -> x.getId().equals(accountID))
                .filter(x -> x.isWithdrawAllowed())
                .findAny()
                .orElse(null);
    }

    @Override
    public Account getClientAccount(String clientID, String accountID) {
        return accountList.stream()
                .filter(x -> x.getClientID().equals(clientID))
                .filter(x -> x.getId().equals(accountID))
                .findAny()
                .orElse(null);
    }

    @Override
    public <S extends Account> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Account> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Account> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Account> findAll() {
        return null;
    }

    @Override
    public Iterable<Account> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Account entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Account> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
