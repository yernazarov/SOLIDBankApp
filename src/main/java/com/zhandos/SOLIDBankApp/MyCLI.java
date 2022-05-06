package com.zhandos.SOLIDBankApp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.lang.Nullable;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class MyCLI implements CLIUI{
    private Scanner scanner;

    public MyCLI() {
        this.scanner = new Scanner(System.in);
    }

    public MyCLI(Scanner scanner) {
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

    public AccountType requestAccountType() {
        System.out.println("Choose account type\n[CHECKING, SAVING, FIXED]");
        while (true) {
            String accountTypeName = this.scanner.nextLine();
            if (!accountTypeName.equals("CHECKING") && !accountTypeName.equals("SAVING") && !accountTypeName.equals("FIXED")) {
                System.out.println("Please enter valid account type");
            } else {
                return new AccountType(accountTypeName);
            }
        }
    }
}
