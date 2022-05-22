package com.zhandos.SOLIDBankApp.account;

import com.zhandos.SOLIDBankApp.account.accountTypes.AccountWithdraw;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface AccountDAO extends CrudRepository<Account, Long>{

    @Query("SELECT * FROM Account WHERE client_id = :clientID")
    List<Account> getClientAccounts(String clientID);

    @Modifying
    @Query(
            "INSERT INTO Account (id, account_type, client_id, balance, withdraw_allowed) VALUES (:id, " +
                    ":accountType, :clientID, :balance, :withdrawAllowed)"
    )
    void createNewAccount(@Param("id") String id, String accountType, String clientID, double balance, boolean withdrawAllowed);

    @Modifying
    @Query("UPDATE Account SET balance= :amount WHERE id= :id")
    void updateAccount(String id, double amount);

    @Query("SELECT * FROM Account WHERE client_id = :clientID AND account_type = :accountType")
    List<Account> getClientAccountsByType(String clientID, String accountType);

    @Query("SELECT * FROM Account WHERE client_id = :clientID AND id = :accountID AND withdraw_allowed = true")
    AccountWithdraw getClientWithdrawAccount(String clientID, String accountID);

    @Query("SELECT * FROM Account WHERE client_id = :clientID AND id = :accountID")
    Account getClientAccount(String clientID, String accountID);
}
