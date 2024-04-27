import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public class TaskDatabaseConnection {
    private static final String DATABASE_URL = "jdbc:sqlite:task_manager.db"; // SQLite database URL
    private Connection connection;

    // Method to establish a connection to the SQLite database
    public Connection connect() {
        try {
            // Load SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");

            // Establish a connection to the SQLite database
            connection = DriverManager.getConnection(DATABASE_URL);
            System.out.println("Connected to SQLite database.");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error connecting to SQLite database: " + e.getMessage());
        }
        return connection;
    }

    // Method to close the database connection
    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Disconnected from SQLite database.");
            }
        } catch (SQLException e) {
            System.err.println("Error disconnecting from SQLite database: " + e.getMessage());
        }
    }

    // Method to save a single task to the database
    public void saveTaskToDatabase(Task task) {
        try (Connection conn = connect()) {
            String sql = "INSERT INTO Task (description, deadline, category, completed) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, task.getDescription());
            statement.setDate(2, task.getDeadline());
            statement.setString(3, task.getCategory());
            statement.setBoolean(4, task.isCompleted());
            statement.executeUpdate();
            System.out.println("Task saved to database successfully.");
        } catch (SQLException e) {
            System.err.println("Error saving task to database: " + e.getMessage());
        }
    }
}
