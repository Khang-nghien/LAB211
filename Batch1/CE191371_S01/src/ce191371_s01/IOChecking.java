/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191371_s01;

/**
 * S01 - Program to insert new element into an existing array.
 *
 * This class is using for checking the valid input and handle the error occur.
 *
 * @author Vu Minh Khang - CE191371 - 16/1/25
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

        // Return the boolean base on the comparison between lenght of the string with 0.
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
}
