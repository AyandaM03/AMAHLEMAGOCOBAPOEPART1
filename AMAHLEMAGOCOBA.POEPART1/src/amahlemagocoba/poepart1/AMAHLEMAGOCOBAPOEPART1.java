package amahlemagocoba.poepart1;

import javax.swing.JOptionPane;

public class AMAHLEMAGOCOBAPOEPART1 {
    
    //Below is me declaring the necessary conditions required to create an account 

    static String username;
    static String password;
    static String firstName;
    static String lastSurname;

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome, please enter your details for the registration");
        
        // Capture username and password
        firstName = JOptionPane.showInputDialog("Enter your First Name");
        lastSurname = JOptionPane.showInputDialog("Enter your Surname");
        username = JOptionPane.showInputDialog("Create your own unique username: Your username must contain an underscore and must be no more than 5 characters long");
        password = JOptionPane.showInputDialog("""
                                               Create your own unique PRIVATE password. Password must be:
                                                - At least 8 characters long
                                                - Contain a capital letter
                                                - Contain a number
                                                - Contain a special character""");

        // Validate username
        if (checkUserName(username) && username.length() <= 5) {
            JOptionPane.showMessageDialog(null,"Username successfully captured");
        } else { 
            JOptionPane.showMessageDialog(null, "Username is not correctly formatted, "
                + "please ensure that your username contains an underscore and is no more than 5 characters in length");  
        }
        
        // Validate password
        if (checkPasswordComplexity(password)) {
            JOptionPane.showMessageDialog(null, "Password successfully captured");
        } else {
            JOptionPane.showMessageDialog(null, "Password is not correctly formatted, "
                + "please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.");
        }
        
        // Call login method
        login();
    }
      
    public static boolean  checkUserName(String username) {
        return username.contains("_");
    }
      
    public static boolean checkPasswordComplexity(String password) {
        // Check if password length is at least 8 characters
        boolean hasMinimumLength = password.length() >= 8;

        // Check if password contains at least one uppercase letter
        boolean hasUppercaseLetter = !password.equals(password.toLowerCase());

        // Check if password contains at least one digit
        boolean hasDigit = password.matches(".*\\d.*");

        // Check if password contains at least one special character
        boolean hasSpecialCharacter = !password.matches("[a-zA-Z0-9]*");

        // Return true if all conditions are met
        return hasMinimumLength && hasUppercaseLetter && hasDigit && hasSpecialCharacter;
        
    }
    
    public static void login() {
        // Prompt user to enter login credentials
        String enteredUsername = JOptionPane.showInputDialog("Enter your username for login:");
        String enteredPassword = JOptionPane.showInputDialog("Enter your password for login:");
        
        // Check if entered credentials match the registered ones
        if (enteredUsername.equals(username) && enteredPassword.equals(password)) {
            JOptionPane.showMessageDialog(null, "Welcome " + firstName + " " + lastSurname + ", you have successfullty logged in, it is great to see you again.");
        } else {
            JOptionPane.showMessageDialog(null, "Failed Login, Username or password incorrect, please try again");
            
        }
    }
    
      public static boolean loginUser(String enteredUsername, String enteredPassword) {
        // Verify login details
        return enteredUsername.equals(username) && enteredPassword.equals(password);
    }
    
    public static void returnLoginStatus(boolean loginSuccess) {
       
      

    }

    void register() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

