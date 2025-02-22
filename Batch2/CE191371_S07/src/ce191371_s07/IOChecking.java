/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191371_s07;

/**
 * S07 - Employee management program.
 * 
 * The class check error.
 *
 * @author Vu Minh Khang - CE191371 - 12/2/25
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
            System.out.print(e.getMessage());

            // Return true if the input is null.
            return true;
        }
    }

    /**
     * Checking the special character and symbol.
     *
     * @param input is the input from user.
     *
     * @return true if there are contain character. False if no.
     */
    /**
     * Checking the special character and symbol.
     * 
     * @param input input is the input from user.
     * @param msg is the error message. 
     * 
     * @return true if there are contain character. False if no.
     */
    public boolean checkContainCharacterAndSymbol(String input, String msg) {

        // Try to convert the input to integer.
        try {
            Double.parseDouble(input);

            // Return false if there are no exception occur.
            return false;

            // Catch the exception if there are a error occur.
        } catch (Exception e) {
            
            // Print out the message
            System.out.print(msg);

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
     * @param msg is the error message.
     *
     * @return true if the input is out of range. False if no.
     */
    public boolean checkOutOfRange(String input, double begin, double end, String msg) {

        try {

            // If the input value is out of the range then throw a exception to the user.
            if (Double.parseDouble(input) < begin || Double.parseDouble(input) > end) {
               
                // If the input is out of range then throw an exception.
                throw new Exception(msg);
            }

            // Return false if the input is in the range.
            return false;

            // Catch the exception if one is occur.
        } catch (Exception e) {

            // Print out the error.
            System.out.print(e.getMessage());

            // Return true if the input is out of range.
            return true;
        }

    }

    /**
     * Checking if there is any special character in the input string.
     *
     * @param input is the input from user.
     * @param msg is the message that will print out the user if a exception
     * occur.
     *
     * @return true if the input contain a special character. False if the input
     * does not contain any special character.
     */
    public boolean checkSpecialCharacter(String input, String msg) {

        try {

            // Checking if there is a special character in the input string.
            if (!input.matches("[a-zA-Z0-9]+")) {

                // If there is a special character in the input string then throw a exception.
                throw new Exception(msg);
            }

            // Return false if the input does not contain any special character.
            return false;
        } catch (Exception e) {

            // Print out the error.
            System.out.print(e.getMessage());

            // Return true if the input contain a special character.
            return true;
        }
    }

    /**
     * Checking if there is any number in the input string.
     *
     * @param input is the input from user.
     *
     * @return true if the input contain a number. False if the input does not
     * contain any number.
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
            System.out.print(e.getMessage());

            // Return true if the input contain a number.
            return true;
        }
    }

    /**
     * Checking if the id is valid or not.
     *
     * @param input is the id need to check.
     * @param msg is the error message.
     *
     * @return true if the id is a valid. False if the id is not.
     */
    public boolean checkValidID(String input, String msg) {

        try {

            // Check if the user enter a valid id or not.
            if (!input.matches("^(NV|nv)(\\d\\d\\d\\d)$")) {

                // If the id is not valid then throw a exception with a message.
                throw new Exception(msg);
            }

            // Return false if the input is a valid id.
            return false;
        } catch (Exception e) {
            
            // Print out the error.
            System.out.print(e.getMessage());

            // Return true if the input not a valid id.
            return true;
        }
    }
    
    /**
     * Checking if the name is valid or not.
     * 
     * @param input is the name need to check.
     * @param msg is the error message.
     * 
     * @return true if the name is not a valid name. False if not.
     */
    public boolean checkValidName(String input, String msg) {
        
        try {
            
            // Check if the user enter a valid name or not.
            if (!input.matches("[a-zA-z ]+")) {

                // If the name is not valid then throw a exception with a message.
                throw new Exception(msg);
            }

            // Return false if the input is a valid name.
            return false;
        } catch (Exception e) {
            
            // Print out the error.
            System.out.print(e.getMessage());

            // Return true if the input not a valid name.
            return true;
        }
    }
}
