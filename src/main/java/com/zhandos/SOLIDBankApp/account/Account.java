package com.zhandos.SOLIDBankApp.account;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
public class Account {
    private @Column("account_type") String accountType;
    private @Id @Column("account_id") String id;
    private @Column("client_id") String clientID;
    private @Column("balance") double balance;
    private @Column("withdraw_allowed") boolean withdrawAllowed;
    @Override
    public String toString() {
        return String.format("Account{accountType=%s, id='%s', clientID='%s', balance=%.1f}", accountType, id, clientID, balance);
    }

    public String getClientID() {
        return this.clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public Account(String accountType, String id, String clientID, double balance, boolean withdrawAllowed) {
        this.accountType = accountType;
        this.id = id;
        this.clientID = clientID;
        this.balance = balance;
        this.withdrawAllowed = withdrawAllowed;
    }
}
