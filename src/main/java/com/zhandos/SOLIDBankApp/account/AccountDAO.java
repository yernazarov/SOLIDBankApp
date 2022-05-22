package com.zhandos.SOLIDBankApp.account;

import com.zhandos.SOLIDBankApp.account.accountTypes.AccountWithdraw;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AccountDAO extends CrudRepository<Account, Long>{
//    @Modifying
    @Query("SELECT * FROM Account WHERE client_id = :clientID")
    List<Account> getClientAccounts(String clientID);

    @Query(
            "INSERT INTO Account (id, account_type, client_id, balance, withdraw_allowed) " +
                    "VALUES (:account.id, :account.accountType, :account.clientID, :account.balance, :account.withdrawAllowed)"
    )
    void createNewAccount(Account account);

    @Query("UPDATE Account SET balance= :amount WHERE id= :account.id")
    void updateAccount(Account account, double amount);

    @Query("SELECT * FROM Account WHERE client_id = :clientID AND account_type = :accountType")
    List<Account> getClientAccountsByType(String clientID, String accountType);

    @Query("SELECT * FROM Account WHERE client_id = :clientID AND account_type = :accountType AND withdraw_allowed = true")
    AccountWithdraw getClientWithdrawAccount(String clientID, String accountID);

    @Query("SELECT * FROM Account WHERE client_id = :clientID AND id = :accountID")
    Account getClientAccount(String clientID, String accountID);
}
