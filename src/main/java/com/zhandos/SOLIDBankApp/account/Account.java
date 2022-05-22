package com.zhandos.SOLIDBankApp.account;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public abstract class Account {
    private String accountType;
    private  @Id String id;
    private String clientID;
    private double balance;
    private boolean withdrawAllowed;
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
