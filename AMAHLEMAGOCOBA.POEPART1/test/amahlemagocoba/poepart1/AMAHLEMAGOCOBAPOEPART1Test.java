package amahlemagocoba.poepart1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AMAHLEMAGOCOBAPOEPART1Test {

    @Test
    public void testCheckUserName_ValidUsername() {
        assertTrue(AMAHLEMAGOCOBAPOEPART1.checkUserName("user_name"));
    }

    @Test
    public void testCheckUserName_InvalidUsername() {
        assertFalse(AMAHLEMAGOCOBAPOEPART1.checkUserName("username"));
    }

    @Test
    public void testCheckPasswordComplexity_ValidPassword() {
        assertTrue(AMAHLEMAGOCOBAPOEPART1.checkPasswordComplexity("Password1!"));
    }

    @Test
    public void testCheckPasswordComplexity_InvalidPassword() {
        assertFalse(AMAHLEMAGOCOBAPOEPART1.checkPasswordComplexity("password"));
    }

   
    }

