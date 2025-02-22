/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191371_l02;

/**
 * L02 - Create a Java console program to manage students.
 * 
 * The class checking error.
 *
 * @author Vu Minh Khang - CE191371 - 13/2/25
 */
public class IOChecking {

    /**
     * Checking the null value (length = 0).
     *
     * @param input is the input from user.
     * @param msg is the message that will print out the user.
     *
     * @return true if there are null value. False if no.
     */
    public boolean checkNullValue(String input, String msg) {

        try {

            // If the input is null(length = 0) then throw an exception.
            if (input.length() == 0) {
                throw new Exception(msg);
            }

            // Return false if the input is not null.
            return false;

            // Catch the exception if there are a error occur.
        } catch (Exception e) {

            // Print out the error.
            System.out.println(e.getMessage());

            // Return true if the input is null.
            return true;
        }
    }

    /**
     * Checking the special character and symbol.
     *
     * @param input is the input from user.
     * @param msg is the error message.
     *
     * @return true if there are contain character. False if no.
     */
    public boolean checkContainCharacterAndSymbol(String input, String msg) {

        // Try to convert the input to integer.
        try {
            Integer.parseInt(input);

            // Return false if there are no exception occur.
            return false;

            // Catch the exception if there are a error occur.
        } catch (Exception e) {
            
            // Print out the error.
            System.out.println(msg);

            // Return false if there is an exception.
            return true;
        }
    }

    /**
     * Checking the range of the input.
     *
     * @param input is the input from user.
     * @param begin is the min of the input.
     * @param end is the max of the input.
     *
     * @return true if the input is out of range. False if no.
     */
    public boolean checkOutOfRange(String input, int begin, int end, String msg) {

        try {

            // If the input value is out of the range then throw a exception to the user.
            if (Integer.parseInt(input) < begin || Integer.parseInt(input) > end) {
                throw new Exception(msg);
            }

            // Return false if the input is in the range.
            return false;

            // Catch the exception if one is occur.
        } catch (Exception e) {

            // Print out the error.
            System.out.println(e.getMessage());

            // Return true if the input is out of range.
            return true;
        }

    }

    /**
     * Checking if there is any special character in the input string.
     *
     * @param input is the input from user.
     * @param msg is the message that will print out the user if a exception occur.
     *
     * @return true if the input contain a special character. False if the input
     * does not contain any special character.
     */
    public boolean checkSpecialCharacter(String input, String msg) {

        try {
            
            // Checking if there is a special character in the input string.
            if (!input.matches("[a-zA-Z0-9 ]+")) {
                
                // If there is a special character in the input string then throw a exception.
                throw new Exception(msg);
            }

            // Return false if the input does not contain any special character.
            return false;
        } catch (Exception e) {

            // Print out the error.
            System.out.println(e.getMessage());

            // Return true if the input contain a special character.
            return true;
        }
    }
    
    /**
     * Checking if there is any number in the input string.
     *
     * @param input is the input from user.
     *
     * @return true if the input contain a number. False if the input
     * does not contain any number.
     */
    public boolean checkNumber(String input) {

        try {
            
            // Checking if there is a number in the input string.
            if (input.matches("[0-9]")) {
                
                // If there is a number in the input string then throw a exception.
                throw new Exception("Plese do not enter number.");
            }

            // Return false if the input does not contain any number.
            return false;
        } catch (Exception e) {

            // Print out the error.
            System.out.println(e.getMessage());

            // Return true if the input contain a number.
            return true;
        }
    }
    
    /**
     * Checking if the name is valid or not.
     * 
     * @param input is the unchecked name.
     * @param msg is the error message.
     * 
     * @return true if the name is not valid. False if valid.
     */
    public boolean checkName(String input, String msg) {
        
        try {
            
            // Check if the name is only contain character and space or not.
            if (!input.matches("[0-9a-zA-Z ]+")) {
                
                // If there are special character then throw an exception.
                throw new Exception(msg);
            }
            
            // Return false if the name is valid.
            return false;
        } catch (Exception e) {
            
            // Print out the error.
            System.out.println(e.getMessage());

            // Return true if the name is not valid.
            return true;
        }
    }
    
    /**
     * Check if the id is valid or not.
     * 
     * @param input is the id of the student.
     * @param msg is the error message.
     * 
     * @return true if the id is not valid. False if yes.
     */
    public boolean checkId(String input, String msg) {
        try {
            
            // Check if the id is right format or not (SV****).
            if (!input.matches("^SV(\\d\\d\\d\\d)$")) {
                
                // If not then throw an exception with an message.
                throw new Exception(msg);
            }
            
            // Return false if the id is valid.
            return false;
        } catch (Exception e) {
            
            // Print out the error.
            System.out.println(e.getMessage());
            

            // Return true if the id is not valid.
            return true;
           
        }
    }
    
    /**
     * Check if the semester is valid or not.
     * 
     * @param input is the input semester.
     * @param msg is the error message.
     * 
     * @return true if the semester is not valid. False if it valid.
     */
    public boolean checkSemester(String input, String msg) {
        try {
            
            // Check if the semester is right format or not.
            if (!input.matches("^(SP|SU|FA)\\d\\d$")) {
                
                // If not then throw an exception with an message.
                throw new Exception(msg);
            }
            
            // Return false if the semester is valid.
            return false;
        } catch (Exception e) {
            
            // Print out the error.
            System.out.println(e.getMessage());
            

            // Return true if the semester is not valid.
            return true;
        }
    }
    
    
}
