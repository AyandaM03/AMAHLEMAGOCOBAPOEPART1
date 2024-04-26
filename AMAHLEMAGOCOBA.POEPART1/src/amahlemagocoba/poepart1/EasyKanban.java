package amahlemagocoba.poepart1;

import javax.swing.JOptionPane;

public class EasyKanban {
    static String username;
    static String password;
    static String firstName;
    static String lastName;
    static int totalHours = 0;
    static int taskNumber = 0;

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

        // User registration
        register();

        // User login
        boolean loggedIn = login();
        if (loggedIn) {
            // Process tasks
            processTasks();
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
}

class Task {
    private String taskName;
    private String taskDescription;
    private String developerDetails;
    private int taskDuration;
    private String taskID;
    private String taskStatus;

    public Task(String taskName, String taskDescription, String developerDetails, int taskDuration, String taskStatus) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getDeveloperDetails() {
        return developerDetails;
    }

    public int getTaskDuration() {
        return taskDuration;
    }

    public String getTaskID() {
        return taskID;
    }

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String printTaskDetails() {
        return "Task Status: " + taskStatus + "\n" +
               "Developer Details: " + developerDetails + "\n" +
               "Task Number: " + EasyKanban.taskNumber + "\n" +
               "Task Name: " + taskName + "\n" +
               "Task Description: " + taskDescription + "\n" +
               "Task ID: " + taskID + "\n" +
               "Duration: " + taskDuration + " hours";
    }
}
