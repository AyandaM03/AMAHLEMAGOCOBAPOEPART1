/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package amahlemagocoba.poepart1;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author RC_Student_lab
 */

package amahlemagocoba.poepart1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class EasyKanbanTest {

    private EasyKanban easyKanban;

    @Before
    public void setUp() {
        easyKanban = new EasyKanban();
        easyKanban.tasks = new ArrayList<>();

        easyKanban.tasks.add(new Task("Create Login", "Create a login screen", "Mike Smith", 5, "To Do"));
        easyKanban.tasks.add(new Task("Create Add Features", "Add new features to the app", "Edward Harrison", 8, "Doing"));
        easyKanban.tasks.add(new Task("Create Reports", "Generate monthly reports", "Samantha Paulson", 2, "Done"));
        easyKanban.tasks.add(new Task("Add Arrays", "Add array functionality", "Glenda Oberholzer", 11, "To Do"));

        for (int i = 0; i < easyKanban.tasks.size(); i++) {
            easyKanban.tasks.get(i).setTaskID("ID" + i);
        }
    }

    @Test
    public void testDeveloperArray() {
        List<String> expectedDevelopers = List.of("Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer");
        assertEquals(expectedDevelopers, easyKanban.getDevelopers());
    }

    @Test
    public void testDisplayDeveloperAndDurationForLongestTask() {
        Task expectedTask = new Task("Add Arrays", "Add array functionality", "Glenda Oberholzer", 11, "To Do");
        assertEquals(expectedTask.getDeveloperDetails(), easyKanban.getTaskWithLongestDuration().getDeveloperDetails());
        assertEquals(expectedTask.getTaskDuration(), easyKanban.getTaskWithLongestDuration().getTaskDuration());
    }

    @Test
    public void testSearchForTask() {
        Task task = easyKanban.searchTaskByName("Create Login");
        assertNotNull(task);
        assertEquals("Create Login", task.getTaskName());
        assertEquals("Mike Smith", task.getDeveloperDetails());
        assertEquals("To Do", task.getTaskStatus());
    }

    @Test
    public void testSearchForTaskReturnsNullIfNotFound() {
        Task task = easyKanban.searchTaskByName("Nonexistent Task");
        assertNull(task);
    }

    @Test
    public void testSearchByDeveloper() {
        List<Task> tasks = easyKanban.searchTasksByDeveloper("Mike Smith");
        assertEquals(1, tasks.size());
        assertEquals("Create Login", tasks.get(0).getTaskName());
    }

    @Test
    public void testDeleteTask() {
        assertTrue(easyKanban.deleteTaskByName("Create Login"));
        assertNull(easyKanban.searchTaskByName("Create Login"));
    }

    @Test
    public void testDeleteTaskReturnsFalseIfNotFound() {
        assertFalse(easyKanban.deleteTaskByName("Nonexistent Task"));
    }

    @Test
    public void testCheckUserName() {
        assertTrue(easyKanban.checkUserName("user_1"));
        assertFalse(easyKanban.checkUserName("user1"));
        assertFalse(easyKanban.checkUserName("username_1"));
    }

    @Test
    public void testCheckPasswordComplexity() {
        assertTrue(easyKanban.checkPasswordComplexity("Password1!"));
        assertFalse(easyKanban.checkPasswordComplexity("password1!"));
        assertFalse(easyKanban.checkPasswordComplexity("Password!"));
        assertFalse(easyKanban.checkPasswordComplexity("Password1"));
    }
}


 
