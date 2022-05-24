package com.zhandos.SOLIDBankApp.transaction;

import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@AllArgsConstructor
public class Transaction {

    @Column("transaction")
    public String transaction;
}
