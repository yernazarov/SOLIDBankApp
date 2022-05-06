package com.zhandos.SOLIDBankApp;

public abstract class Account {
    private AccountType accountType;
    private String id;
    private String clientID;
    private double balance;
    protected boolean withdrawAllowed; //was changed to protected to implement the abstraction
    public double getBalance = this.balance;
    public String toString() { //this is defined as parameter in UML, but it is impossible for immutable object as String
                               //to be constantly changing (because of the balance) parameter, so I changed it to method
        return String.format("Account{accountType=%s, id='%s', clientID='%s', balance=%.1f}", accountType.name, id, clientID, balance);
    }

    public String getClientID() {
        return this.clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public Account(AccountType accountType, String id, String clientID, double balance, boolean withdrawAllowed) {
        this.accountType = accountType;
        this.id = id;
        this.clientID = clientID;
        this.balance = balance;
        this.withdrawAllowed = withdrawAllowed;
    }

    public abstract boolean isWithdrawAllowed();

    public abstract void setWithdrawAllowed(boolean withdrawAllowed);

    public AccountType getAccountType() {
        return this.accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
