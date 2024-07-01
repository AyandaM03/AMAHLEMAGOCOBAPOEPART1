
package amahlemagocoba.poepart1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
public class EasyKanbanTest {
    
    public EasyKanbanTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of main method, of class EasyKanban.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        EasyKanban.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of register method, of class EasyKanban.
     */
    @Test
    public void testRegister() {
        System.out.println("register");
        EasyKanban.register();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkUserName method, of class EasyKanban.
     */
    @Test
    public void testCheckUserName() {
        System.out.println("checkUserName");
        String username = "";
        boolean expResult = false;
        boolean result = EasyKanban.checkUserName(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkPasswordComplexity method, of class EasyKanban.
     */
    @Test
    public void testCheckPasswordComplexity() {
        System.out.println("checkPasswordComplexity");
        String password = "";
        boolean expResult = false;
        boolean result = EasyKanban.checkPasswordComplexity(password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of login method, of class EasyKanban.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        boolean expResult = false;
        boolean result = EasyKanban.login();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loginUser method, of class EasyKanban.
     */
    @Test
    public void testLoginUser() {
        System.out.println("loginUser");
        String enteredUsername = "";
        String enteredPassword = "";
        boolean expResult = false;
        boolean result = EasyKanban.loginUser(enteredUsername, enteredPassword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of processTasks method, of class EasyKanban.
     */
    @Test
    public void testProcessTasks() {
        System.out.println("processTasks");
        EasyKanban.processTasks();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createTask method, of class EasyKanban.
     */
    @Test
    public void testCreateTask() {
        System.out.println("createTask");
        Task expResult = null;
        Task result = EasyKanban.createTask();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayTaskDetails method, of class EasyKanban.
     */
    @Test
    public void testDisplayTaskDetails() {
        System.out.println("displayTaskDetails");
        Task task = null;
        EasyKanban.displayTaskDetails(task);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateTaskID method, of class EasyKanban.
     */
    @Test
    public void testGenerateTaskID() {
        System.out.println("generateTaskID");
        Task task = null;
        String expResult = "";
        String result = EasyKanban.generateTaskID(task);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
