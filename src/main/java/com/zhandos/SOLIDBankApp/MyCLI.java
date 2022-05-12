package com.zhandos.SOLIDBankApp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
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

    private void tryAgain() {
        System.out.println("Error, that is not a valid input, try again!");
        this.scanner.next();
    }

    public double requestClientAmount() {
        System.out.println("Type amount of money");
        double amount = -1;
        while (true) {
            if (!this.scanner.hasNextDouble()) {
                tryAgain();
                continue;
            }
            amount = this.scanner.nextDouble();
            if (amount < 0) {
                tryAgain();
                continue;
            }
            break;
        }
        this.scanner.nextLine();
        return amount;
    }

    public String requestClientAccountNumber() {
        System.out.println("Type account ID");
        return this.scanner.nextLine();
    }

    public AccountType requestAccountType() {
        System.out.println("Choose account type\n[CHECKING, SAVING, FIXED]");
        String accountTypeName = this.scanner.nextLine();
        if (!accountTypeName.equals("CHECKING") && !accountTypeName.equals("SAVING") && !accountTypeName.equals("FIXED")) {
            System.out.println("Error, you entered wrong account type, try again!");
            return null;
        } else {
            return new AccountType(accountTypeName);
        }
    }
}
