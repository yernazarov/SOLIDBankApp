package com.zhandos.SOLIDBankApp.repositories;

import com.zhandos.SOLIDBankApp.entities.AccountWithdraw;
import com.zhandos.SOLIDBankApp.entities.Account;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long>{

    @Query("SELECT * FROM Account WHERE client_id = :clientID")
    List<Account> getClientAccounts(int clientID);

    @Modifying
    @Query(
            "INSERT INTO Account (account_id, account_type, client_id, balance, withdraw_allowed) VALUES (:id, " +
                    ":accountType, :clientID, :balance, :withdrawAllowed)"
    )
    void createNewAccount(String id, String accountType, int clientID, double balance, boolean withdrawAllowed);

    @Modifying
    @Query("UPDATE Account SET balance= :amount WHERE account_id= :id")
    void updateAccount(String id, double amount);

    @Query("SELECT * FROM Account WHERE client_id = :clientID AND account_type = :accountType")
    List<Account> getClientAccountsByType(int clientID, String accountType);

    @Query("SELECT * FROM Account WHERE client_id = :clientID AND account_id = :accountID AND withdraw_allowed = true")
    AccountWithdraw getClientWithdrawAccount(int clientID, String accountID);

    @Query("SELECT * FROM Account WHERE client_id = :clientID AND account_id = :accountID")
    Account getClientAccount(int clientID, String accountID);

    @Modifying
    @Query("DELETE FROM Account WHERE account_id = :accountID")
    void deleteAccountByAccountID(String accountID);

    @Query("SELECT * FROM Account WHERE account_id = :accountID")
    Account getAccount(String accountID);
}
