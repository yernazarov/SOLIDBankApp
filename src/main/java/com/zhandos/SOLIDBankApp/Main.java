package com.zhandos.SOLIDBankApp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        printManual();
        MyCLI myCLI = new MyCLI();
        while (true) {
            System.out.print("> ");
            String number = myCLI.scanner.nextLine();
            switch (number) {
                case "1" -> myCLI.showAccounts();
                case "2" -> myCLI.createAccount();
                case "3" -> printNotImplemented();
                case "4" -> printNotImplemented();
                case "5" -> printNotImplemented();
                case "6" -> printManual();
                case "7" -> exit();
                default -> System.out.println("Please enter valid number");
            }
        }
    }

    public static void printNotImplemented() {
        System.out.println("This feature is not implemented in the UML diagram (Grey Area)");
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
