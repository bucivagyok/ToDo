package app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Loop();
    }

    private static void Loop() {
        String command = "";
        Scanner scanner = new Scanner(System.in);
        while (!command.equals("exit")) {
            System.out.println("What to do?");
            command = scanner.nextLine();
            ExecuteCommand(command);
        }
    }

    private static void ExecuteCommand(String command) {
        switch (command) {
            case "add": System.out.println("Add");
                break;
            case "redescribe": System.out.println("Redescribe");
                break;
            case "list": System.out.println("List");
                break;
            case "complete": System.out.println("Complete");
                break;
            case "delete": System.out.println("Delete");
                break;
            case "exit":
                break;
            default: System.out.println("Not real");
                break;
        }
        System.out.println(command);
    }
}