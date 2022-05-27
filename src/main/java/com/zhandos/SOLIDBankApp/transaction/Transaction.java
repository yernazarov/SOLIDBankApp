package com.zhandos.SOLIDBankApp.transaction;

import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@AllArgsConstructor
public class Transaction {

    @Column("account_id")
    private long accountID;

    @Column("amount")
    private double amount;

    @Column("type")
    public String type;
}