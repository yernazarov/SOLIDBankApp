package com.zhandos.SOLIDBankApp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyCLI implements CLIUI{
    private final Scanner scanner;

    public static void main(String[] args) {
        printManual();
        MyCLI myCLI = new MyCLI(new Scanner(System.in));
        while (true) {
            System.out.print("> ");
            String number = myCLI.scanner.nextLine();
            switch (number) {
                case "1" -> myCLI.showAccounts();
                case "2" -> myCLI.createAccount();
                case "3" -> myCLI.printNotImplemented();
                case "4" -> myCLI.printNotImplemented();
                case "5" -> myCLI.printNotImplemented();
                case "6" -> printManual();
                case "7" -> myCLI.exit();
                default -> System.out.println("Please enter valid number");
            }
        }
    }

    public MyCLI(Scanner scanner) {
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

    public void printNotImplemented() {
        System.out.println("This feature is not implemented in the UML diagram (Grey Area)");
    }

    private void showAccounts() {
    }

    private void createAccount() {
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
    public void exit() {
        System.out.println("Application Closed");
        System.exit(0);
    }
}
