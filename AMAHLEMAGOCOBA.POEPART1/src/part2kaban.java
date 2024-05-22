import javax.swing.JOptionPane;

public class part2kaban {
  
    
    static String username;
    static String password;
    static String firstName;
    static String lastName;
    static int totalHours = 0;
    static int taskNumber = 0;

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");
        login(); // Added login before proceeding to menu

        boolean loggedIn = true; // Assume the user is logged in after successful login
        if (loggedIn) {
            processMenu(); // Call the menu function
        } else {
            JOptionPane.showMessageDialog(null, "Login failed. Exiting program.");
        }
    }

    public static void login() {
        // Your existing login code here
    }

    public static void processMenu() {
        while (true) { // Run until user selects quit
            String option = JOptionPane.showInputDialog("Select an option:\n" +
                                                         "1. Add tasks\n" +
                                                         "2. Show report (Coming Soon)\n" +
                                                         "3. Quit");
            switch (option) {
                case "1":
                    addTasks();
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, "Report feature is still in development. Coming Soon.");
                    break;
                case "3":
                    JOptionPane.showMessageDialog(null, "Exiting program.");
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please select a valid option.");
                    break;
            }
        }
    }

    public static void addTasks() {
        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks do you want to enter?"));

        for (int i = 0; i < numTasks; i++) {
            Task task = createTask();
            displayTaskDetails(task);
            totalHours += task.getTaskDuration();
        }

        JOptionPane.showMessageDialog(null, "Total hours across all tasks: " + totalHours);
    }

    public static Task createTask() {
        String taskName = "Add Login Feature"; // Hardcoded task name as per instructions
        String taskDescription = JOptionPane.showInputDialog("Enter Task Description (max 50 characters):");
        if (taskDescription.length() > 50) {
            JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
            System.exit(0);
        } else {
            JOptionPane.showMessageDialog(null, "Task successfully captured");
        }
        String developerDetails = JOptionPane.showInputDialog("Enter Developer Details (First Last):");
       String[] statusOptions = {"To Do", "Done", "Doing"};
        int option = JOptionPane.showOptionDialog(null, "Select Task Status", "Task Status",
                                                   JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                                                   null, statusOptions, statusOptions[0]);
        
        String taskStatus;
        switch (option) {
            case 0:
                taskStatus = "To Do";
                break;
            case 1:
                taskStatus = "Done";
                break;
            case 2:
                taskStatus = "Doing";
                break;
            default:
                JOptionPane.showMessageDialog(null, "Incorrect Input");
                return null;
        }
        int taskDuration = 0;

    
        var task = new Task(taskName, taskDescription, developerDetails, taskDuration, taskStatus);
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

    private static class task {

        public task() {
        }
    }
}

class Task {

    static short returnTotalHours() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    static short returnTotalHours() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
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

   public boolean checkTaskDescription() {
        return taskDescription.length() <= 50;
    }

    public String createTaskID() {
        return taskName.substring(0, 2).toUpperCase() + ":" + part2kaban.taskNumber + ":" +
               developerDetails.substring(developerDetails.length() - 3).toUpperCase();
    } 
    
    
    public String printTaskDetails() {
        return "Task Status: " + taskStatus + "\n" +
               "Developer Details: " + developerDetails + "\n" +
               "Task Number: " + part2kaban.taskNumber + "\n" +
               "Task Name: " + taskName + "\n" +
               "Task Description: " + taskDescription + "\n" +
               "Task ID: " + taskID + "\n" +
               "Duration: " + taskDuration + " hours";
    }
public static int returnTotalHoures(){
return part2kaban.totalHours;
}
}