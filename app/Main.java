package app;

import java.util.Scanner;


public class Main {
    static JobList active;

    public static void main(String[] args) {
        active = new JobList();
        Loop();
    }

    private static void Loop() {
        String command = "";
        Scanner scanner = new Scanner(System.in);
        while (!command.equals("exit")) {
            System.out.println("---\nWhat to do (add, redescribe, list, complete, delete)?");
            command = scanner.nextLine();
            switch (command.toLowerCase()) {
                case "add": System.out.println("Add");
                    Add(scanner);
                    break;
                case "redescribe":
                    Redescribe(scanner);
                    break;
                case "list":
                    active.ListJobs();
                    break;
                case "complete": 
                    Complete(scanner);
                    break;
                case "delete":
                    Delete(scanner);
                    break;
                case "exit":
                    active.Save();
                    break;
                default: System.out.println("Invalid command!");
                    break;
            }
        }
    } 

    private static void Add(Scanner scanner) {
        System.out.printf("Name of the task: ");
        String title = scanner.nextLine();
        System.out.printf("Description of the task: ");
        String description = scanner.nextLine();
        active.AddJob(new Job(title, description));
    }

    private static void Redescribe(Scanner scanner) {
        while (true) {
            try {
                active.ListJobs();
                System.out.printf("Index of the task to redescribe (-1 to leave): ");
                int rewrite = Integer.parseInt(scanner.nextLine());
                if (rewrite != -1) {
                    System.out.printf("New description: ");
                    String description = scanner.nextLine();
                    active.ReDescribe(rewrite, description);
                }
                break;
            }
            catch (Exception e) {
                System.out.println("The task has to exist!");
            }
        }
    }

    private static void Complete(Scanner scanner) {
        while (true) {
            try {
                active.ListJobs();
                System.out.printf("Index of the finished task (-1 to leave): ");
                int completed = Integer.parseInt(scanner.nextLine());
                if (completed != -1) {
                    active.JobDone(completed);
                }
                break;
            }
            catch (Exception e) {
                System.out.println("The task has to be unfinished and existing!");
            }
        }
    }

    private static void Delete(Scanner scanner) {
        while (true) {
            try {
                active.ListJobs();
                System.out.printf("Index of the task to delete (-1 to leave): ");
                int delete = Integer.parseInt(scanner.nextLine());
                if (delete != -1) {
                    active.DeleteJob(delete);
                }
                break;
            }
            catch (Exception e) {
                System.out.println("The task has to be finished and existing!");
            }
        }
    }
}