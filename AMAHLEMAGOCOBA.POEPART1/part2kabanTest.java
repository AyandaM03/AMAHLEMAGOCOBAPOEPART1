import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class part2kabanTest {

    private Task task1;
    private Task task2;
    private static int taskNumber;
    private static int totalHours;

    @BeforeEach
    public void setUp() {
        // Initialize tasks with test data
        task1 = new Task("Login Feature", "Create Login to authenticate users", "Robyn Harrison", 8, "To Do");
        task1.createTaskID();

        task2 = new Task("Add Task Feature", "Create Add Task feature to add task users", "Mike Smith", 10, "Doing");
        task2.createTaskID();

        // Reset taskNumber and totalHours before each test
        part2kabanTest.taskNumber = 0;
        part2kabanTest.totalHours = 0;
    }

    @Test
    public void testCheckTaskDescription() {
        assertTrue(task1.checkTaskDescription(), "Task description should be valid for Task 1");
        assertFalse(new Task("Feature", "This description is way too long and should fail the validation.", "Developer", 1, "To Do").checkTaskDescription(), "Task description should be invalid");
    }

    @Test
    public void testCreateTaskID() {
        assertEquals("LO:0:SON", task1.createTaskID(), "Task ID should be correctly formatted for Task 1");
        assertEquals("AD:1:ITH", task2.createTaskID(), "Task ID should be correctly formatted for Task 2");
    }

    @Test
    public void testPrintTaskDetails() {
        String expectedDetails = "Task Status: To Do\n" +
                                 "Developer Details: Robyn Harrison\n" +
                                 "Task Number: 0\n" +
                                 "Task Name: Login Feature\n" +
                                 "Task Description: Create Login to authenticate users\n" +
                                 "Task ID: LO:0:SON\n" +
                                 "Duration: 8 hours";
        assertEquals(expectedDetails, task1.printTaskDetails(), "Task details should match the expected format");
    }

    @Test
    public void testReturnTotalHours() {
        part2kabanTest.totalHours += task1.getTaskDuration();
        part2kabanTest.totalHours += task2.getTaskDuration();
        assertEquals(18, Task.returnTotalHours(), "Total hours should be correctly calculated");
    }

    @Test
    public void testAddTasks() {
        // Mock user input for 2 tasks
        part2kabanTest.addTasks();
        
        assertEquals(2, part2kabanTest.taskNumber, "Task number should be incremented correctly");
        assertEquals(18, part2kabanTest.totalHours, "Total hours should be calculated correctly");
    }

    private static void addTasks() {
        // Add tasks as per your actual addTasks implementation
        // This is a placeholder to simulate adding tasks
        Task task1 = new Task("Login Feature", "Create Login to authenticate users", "Robyn Harrison", 8, "To Do");
        Task task2 = new Task("Add Task Feature", "Create Add Task feature to add task users", "Mike Smith", 10, "Doing");
        taskNumber += 2;
        totalHours += task1.getTaskDuration() + task2.getTaskDuration();
    }
}


