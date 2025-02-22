/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191371_v04;

/**
 * V04 - Doctor manage program.
 * 
 * The class is using for checking the valid input.
 *
 * @author Vu Minh Khang - CE191371 - 18/1/25
 */
public class IOChecking {
    
    /**
     * Checking the input from user. Checking the null value input. Checking the
     * character value input.
     *
     * @param number is the input from user.
     *
     * @return a false value if there are no error occur.
     */
    public boolean checkValid(String number) {

        // Checking the null value.
        if (checkNullValue(number)) {
            System.out.println("Please enter something.");

            // Return the true value if the input is null.
            return true;

            // Checking the character value.
        } else if (checkContainCharacterAndSymbol(number)) {
            System.out.println("Please not enter character or special symbol.");

            // Return the true value if the input contain special character or symbol.
            return true;

            // If there are no error occur then return false.
        } else {
            return false;
        }

    }

    /**
     * Checking the null value (length = 0).
     *
     * @param number is the input from user.
     *
     * @return true if there are null value. False if no.
     */
    public boolean checkNullValue(String number) {

        // Return the boolean base on the length of the input.
        return (number.length() == 0);
    }

    /**
     * Checking the special character and symbol.
     *
     * @param number is the input from user.
     *
     * @return true if there are contain character. False if no.
     */
    public boolean checkContainCharacterAndSymbol(String number) {

        // Try to convert the input to integer.
        try {
            Integer.parseInt(number);

            // Return false if there are no exception occur.
            return false;

            // Catch the exception if there are a error occur.
        } catch (Exception e) {

            // Return false if there is an exception.
            return true;
        }
    }
    
    /**
     * Checking the range of the input.
     * 
     * @param number is the input from user.
     * @param begin is the min of the input.
     * @param end is the max of the input.
     * 
     * @return true if the input is out of range. False if no.
     */
    public boolean checkOutOfRange(String number, int begin, int end) {
        
        // Return boolean value base on the location of the value in the range.
        return (Integer.parseInt(number) < begin || Integer.parseInt(number) > end);
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
    
}
