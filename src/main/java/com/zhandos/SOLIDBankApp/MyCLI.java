package com.zhandos.SOLIDBankApp;

import org.springframework.lang.Nullable;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyCLI implements CLIUI{
    private Scanner scanner;

    public MyCLI() {
        this.scanner = new Scanner(System.in);
    }

    MyCLI(Scanner scanner) {
        this.scanner = scanner;
    }

    public double requestClientAmount() {
        System.out.println("This feature is not implemented in the UML diagram (Grey Area)");
        return 0.0;
    }

    public String requestClientAccountNumber() {
        System.out.println("This feature is not implemented in the UML diagram (Grey Area)");
        return "";
    }

    @Nullable
    public AccountType requestAccountType() {
        System.out.println("Choose account type\n[CHECKING, SAVING, FIXED]");
        String accountType = this.scanner.nextLine();
        if (accountType == "CHECKING") {

        } else if (accountType == "SAVING"){

        } else if (accountType == "FIXED") {

        } else {
            System.out.println("Please enter valid account type");
        }
        return new AccountType();
    }
}
