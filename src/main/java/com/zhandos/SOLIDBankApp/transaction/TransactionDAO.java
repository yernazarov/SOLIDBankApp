package com.zhandos.SOLIDBankApp.transaction;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionDAO extends CrudRepository<Transaction, Long> {
    @Query("SELECT * FROM Transaction ORDER BY transaction")
    List<Transaction> getTransactions();

    @Modifying
    @Query(
            "INSERT INTO Transaction (transaction) VALUES (:transaction)"
    )
    void addTransaction(String transaction);
}
