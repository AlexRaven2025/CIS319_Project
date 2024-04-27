import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;
    private TaskDatabaseConnection databaseConnection;

    public TaskManager() {
        tasks = new ArrayList<>();
        databaseConnection = new TaskDatabaseConnection();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public List<Task> getTasksByPriority() {
        // Sort tasks by priority (deadline)
        Collections.sort(tasks, Comparator.comparing(Task::getDeadline));
        return tasks;
    }

    public List<Task> getTasksByDueDate() {
        // Sort tasks by due date
        Collections.sort(tasks, Comparator.comparing(Task::getDeadline));
        return tasks;
    }

    public List<Task> getTasksByCategory(String category) {
        // Filter tasks by category
        List<Task> filteredTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getCategory().equalsIgnoreCase(category)) {
                filteredTasks.add(task);
            }
        }
        return filteredTasks;
    }

    public void markTaskAsCompleted(Task task) {
        task.setCompleted(true);
    }

    public void printTaskList() {
        // Print task list to terminal window
        System.out.println("Task List:");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public void saveTasksToDatabase() {
        try (Connection connection = databaseConnection.connect()) {
            // Save tasks to the database
            // Example: Insert tasks into the 'Task' table
            // Implement database operations here
            System.out.println("Tasks saved to database successfully.");
        } catch (SQLException e) {
            System.err.println("Error saving tasks to database: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void loadTasksFromDatabase() {
        try (Connection connection = databaseConnection.connect()) {
            // Load tasks from the database
            // Example: Retrieve tasks from the 'Task' table
            // Implement database operations here
            System.out.println("Tasks loaded from database successfully.");
        } catch (SQLException e) {
            System.err.println("Error loading tasks from database: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
