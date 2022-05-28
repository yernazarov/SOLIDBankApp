package com.zhandos.SOLIDBankApp.transaction;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    @Query("SELECT * FROM Transaction ORDER BY id DESC")
    List<Transaction> getTransactions();

    @Query("SELECT * FROM Transaction WHERE account_id = :accountID")
    List<Transaction> findTransactionsByAccountID(long accountID);

    @Modifying
    @Query("DELETE FROM Transaction WHERE account_id = :accountID")
    void deleteTransactionsByAccountID(long accountID);

    @Modifying
    @Query(
            "INSERT INTO Transaction (account_id, amount, type) VALUES (:accountID, :amount, :type)"
    )
    void addTransaction(long accountID, double amount, String type);


}
