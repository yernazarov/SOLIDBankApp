package com.zhandos.SOLIDBankApp;

import com.zhandos.SOLIDBankApp.cli.AccountBasicCLI;
import com.zhandos.SOLIDBankApp.cli.TransactionDepositCLI;
import com.zhandos.SOLIDBankApp.cli.TransactionWithdrawCLI;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        AccountBasicCLI accountBasicCLI = context.getBean(AccountBasicCLI.class);
        TransactionWithdrawCLI transactionWithdrawCLI = context.getBean(TransactionWithdrawCLI.class);
        TransactionDepositCLI transactionDepositCLI = context.getBean(TransactionDepositCLI.class);
        printManual();
        Scanner scanner = new Scanner(System.in);
        String clientID = "1"; // We are working with only one user and after the exit, all data would be wiped out.
                               // Therefore, no need for generating new clientIDs. For this project, at least.
        while (true) {
            System.out.print("> ");
            String number = scanner.nextLine();
            switch (number) {
                case "1" -> accountBasicCLI.getAccounts(clientID);
                case "2" -> accountBasicCLI.createAccountRequest(clientID);
                case "3" -> transactionDepositCLI.depositMoney(clientID);
                case "4" -> transactionWithdrawCLI.withdrawMoney(clientID);
                case "5" -> printNotImplemented();
                case "6" -> printManual();
                case "7" -> exit();
                default -> System.out.println("Please enter valid number");
            }
        }
    }

    public static void printNotImplemented() {
        System.out.println("This feature is not implemented in the UML diagram");
    }

    private static void printManual() {
        try {
            File read_file = new File("src/main/resources/manual.txt");
            Scanner scanner = new Scanner(read_file);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static void exit() {
        System.out.println("Application Closed");
        System.exit(0);
    }
}
