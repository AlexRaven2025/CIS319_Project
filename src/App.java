import java.sql.Date;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter tasks (or -1 to finish):");

        while (true) {
            System.out.print("Description: ");
            String description = scanner.nextLine();

            if (description.equals("-1")) {
                break; // Exit the loop if sentinel value is entered
            }

            System.out.print("Deadline (yyyy-MM-dd): ");
            String deadlineStr = scanner.nextLine();
            Date deadline = Date.valueOf(deadlineStr);

            System.out.print("Category: ");
            String category = scanner.nextLine();

            // Create new task
            Task task = new Task(description, deadline, category, false);
            taskManager.addTask(task);
        }

        // Save tasks to the database
        taskManager.saveTasksToDatabase();

        // Load tasks from the database
        taskManager.loadTasksFromDatabase();

        // Print task list
        taskManager.printTaskList();

        scanner.close(); // Close scanner
    }
}
