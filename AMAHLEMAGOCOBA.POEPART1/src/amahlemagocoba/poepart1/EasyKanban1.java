
package amahlemagocoba.poepart1;

    


import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class EasyKanban1 {

    static String username;
    static String password;
    static String firstName;
    static String lastName;
    static int totalHours = 0;
    static int taskNumber = 0;

    static List<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        // Welcome message
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

        // User registration
        register();

        // User login
        boolean loggedIn = login();
        if (loggedIn) {
            JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

            boolean running = true;
            while (running) {
                String menu = "1. Add tasks\n2. Show report\n3. Quit";
                String choice = JOptionPane.showInputDialog(menu);

                if (choice == null) {
                    // If the user closes the dialog
                    running = false;
                } else {
                    switch (choice) {
                        case "1":
                            processTasks();
                            break;
                        case "2":
                            JOptionPane.showMessageDialog(null, displayReport());
                            break;
                        case "3":
                            running = false;
                            JOptionPane.showMessageDialog(null, "Exiting program.");
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
                            break;
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Login failed. Exiting program.");
        }
    }

    public static void register() {
        JOptionPane.showMessageDialog(null, "Welcome, please enter your details for registration");

        firstName = JOptionPane.showInputDialog("Enter your First Name");
        lastName = JOptionPane.showInputDialog("Enter your Last Name");
        username = JOptionPane.showInputDialog("Create your username (must contain an underscore and be no more than 5 characters long)");
        password = JOptionPane.showInputDialog("Create your password (must be at least 8 characters long, contain a capital letter, a number, and a special character)");

        // Validate username
        if (checkUserName(username)) {
            JOptionPane.showMessageDialog(null, "Username successfully captured");
        } else {
            JOptionPane.showMessageDialog(null, "Username is not correctly formatted.");
            System.exit(0);
        }

        // Validate password
        if (checkPasswordComplexity(password)) {
            JOptionPane.showMessageDialog(null, "Password successfully captured");
        } else {
            JOptionPane.showMessageDialog(null, "Password is not correctly formatted.");
            System.exit(0);
        }
    }

    public static boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public static boolean checkPasswordComplexity(String password) {
        boolean hasMinimumLength = password.length() >= 8;
        boolean hasUppercaseLetter = !password.equals(password.toLowerCase());
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasSpecialCharacter = !password.matches("[a-zA-Z0-9]*");
        return hasMinimumLength && hasUppercaseLetter && hasDigit && hasSpecialCharacter;
    }

    public static boolean login() {
        String enteredUsername = JOptionPane.showInputDialog("Enter your username for login:");
        String enteredPassword = JOptionPane.showInputDialog("Enter your password for login:");
        return loginUser(enteredUsername, enteredPassword);
    }

    public static boolean loginUser(String enteredUsername, String enteredPassword) {
        return enteredUsername.equals(username) && enteredPassword.equals(password);
    }

    public static void processTasks() {
        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks do you want to enter?"));

        for (int i = 0; i < numTasks; i++) {
            Task task = createTask();
            displayTaskDetails(task);
            totalHours += task.getTaskDuration();
            tasks.add(task);
        }

        JOptionPane.showMessageDialog(null, "Total hours across all tasks: " + totalHours);
    }

    public static Task createTask() {
        String taskName = JOptionPane.showInputDialog("Enter Task Name:");
        String taskDescription = JOptionPane.showInputDialog("Enter Task Description (max 50 characters):");
        String developerDetails = JOptionPane.showInputDialog("Enter Developer Details:");
        int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter Task Duration (in hours):"));
        String taskStatus = JOptionPane.showInputDialog("Enter Task Status (To Do, Doing, Done):");

        Task task = new Task(taskName, taskDescription, developerDetails, taskDuration, taskStatus);
        task.setTaskID(generateTaskID(task));

        return task;
    }

    public static void displayTaskDetails(Task task) {
        JOptionPane.showMessageDialog(null, task.printTaskDetails());
    }

    public static String generateTaskID(Task task) {
        String taskID = task.getTaskName().substring(0, 2).toUpperCase() +
                        ":" + taskNumber + ":" +
                        task.getDeveloperDetails().substring(task.getDeveloperDetails().length() - 3).toUpperCase();
        taskNumber++;
        return taskID;
    }

    public static String displayReport() {
        StringBuilder report = new StringBuilder("All Tasks:\n");
        for (Task task : tasks) {
            report.append(task.printTaskDetails()).append("\n\n");
        }
        return report.toString();
    }

    public static List<String> getDevelopers() {
        List<String> developers = new ArrayList<>();
        for (Task task : tasks) {
            developers.add(task.getDeveloperDetails());
        }
        return developers;
    }

    public static Task getTaskWithLongestDuration() {
        Task longestTask = null;
        for (Task task : tasks) {
            if (longestTask == null || task.getTaskDuration() > longestTask.getTaskDuration()) {
                longestTask = task;
            }
        }
        return longestTask;
    }

    public static Task searchTaskByName(String taskName) {
        for (Task task : tasks) {
            if (task.getTaskName().equalsIgnoreCase(taskName)) {
                return task;
            } else {
            }
        }
        return null;
    }

    public static List<Task> searchTasksByDeveloper(String developer) {
        List<Task> developerTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getDeveloperDetails().equalsIgnoreCase(developer)) {
                developerTasks.add(task);
            }
        }
        return developerTasks;
    }

    public static boolean deleteTaskByName(String taskName) {
        Task task = searchTaskByName(taskName);
        if (task != null) {
            tasks.remove(task);
            return true;
        }
        return false;
    }
}


