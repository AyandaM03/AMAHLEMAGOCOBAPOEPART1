package rc;


import javax.swing.JOptionPane;
public class SurnameLearnerTaskPrj {

   
    public static void main(String[] args) {
       
       String input1= JOptionPane.showInputDialog("Enter the first number");
       double num1 = Double.parseDouble(input1);
       
       String input2 = JOptionPane.showInputDialog("Enter the second number");
       int num2 = Integer.parseInt(input2);
       
        // Add the two numbers 
     double sum = num1 + num2;
     
     //. do the acalulation of the average 
     
     double average =sum / 2;
     
     JOptionPane.showMessageDialog(null, "The sum of " + num1 + " and " + num2 + " is: " + sum + "\n" + 
             "The average of " + num1 + " and " + num2 + " is: " + average);
  
    }
    
    
}
    

 
        
    


        
        
    
    

