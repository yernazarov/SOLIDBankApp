package com.zhandos.SOLIDBankApp;

import java.util.Scanner;

public class MYCLI implements CLIUI{
    private Scanner scanner;

    public MYCLI(Scanner scanner) {
        this.scanner = scanner;
    }

    public double requestClientAmount() {
        //TODO: implement the method
        return 0.0;
    }

    public String requestClientAccountNumber() {
        //TODO: implement the method
        return "";
    }

    public AccountType requestAccountType() {
        //TODO: implement the method
        return new AccountType();
    }
}
