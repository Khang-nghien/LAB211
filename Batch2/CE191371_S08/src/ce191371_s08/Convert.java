/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191371_s08;

/**
 * S08 - Convert hexadecimal, octal to binary.
 *
 * The class check valid number and convert number.
 *
 * @author Vu Minh Khang - CE191371 - 12/2/25
 */
public class Convert {

    // Set the value for each character from 0 to 9 and a to f.
    private String arr[] = new String[]{"0000", "0001", "0010", "0011",
        "0100", "0101", "0110", "0111",
        "1000", "1001", "1010", "1011",
        "1100", "1101", "1110", "1111"};

    // The field output is the converted number.
    // The field charValur is the value of each character in the input string from user.
    private String output;
    private String charValue;

    /**
     * Method to check the valid input from user.
     *
     * @param input is the input from user.
     *
     * @return true if the input is a valid number. False if not.
     */
    public boolean checkValidInput(String input) {

        try {

            // Check if the input is null or not.
            if (input.length() == 0) {

                // If yes then throw an exception with a message.
                throw new Exception("\tPlease enter something.");
            }

            // Check if the last character of the input is not 'h'(char for convert to hexa) or 'q'(char for convert to octal).
            if (input.charAt(input.length() - 1) != 'h' && input.charAt(input.length() - 1) != 'q') {

                // If yes then throw an exception with a message.
                throw new Exception("\tPlease enter valid type convert.");
            }

            // If the last character of the input is 'h' (char for convert to hexa).
            if (input.charAt(input.length() - 1) == 'h') {

                // Check if the input number is contain any character that not a hexa or not.
                if (!input.matches("^[0-7a-f]+h$")) {

                    // If yes then throw an exception with a message.
                    throw new Exception("\tPlease enter valid hexadecimal number.");
                }
            }

            // If the last character of the input is 'q' (char for convert to octal).
            if (input.charAt(input.length() - 1) == 'q') {

                // Check if the input number is contain any character that not a octal or not.
                if (!input.matches("^[0-7]+q$")) {

                    // If yes then throw an exception with a message.
                    throw new Exception("\tPlease enter valid octal number.");
                }
            }

            // Return true if the input is valid.
            return true;
        } catch (Exception e) {

            // If the input is not valid then return false and print out the error message.
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Method to convert hexadecimal number and octal number to binary number.
     *
     * @param input is the number need to convert.
     *
     * @return the binary number that has been converted.
     */
    public String convertToBinary(String input) {

        // Set the output to empty string.
        output = "";

        // If the last character of the input is h then convert the hexadecimal number to binary.
        if (input.charAt(input.length() - 1) == 'h') {

            // Get each character from the input.
            for (int i = 0; i < input.length() - 1; i++) {

                // Convert the character to binary number.
                charValue = getBinary(input.charAt(i), "0123456789abcdef");

                // Add the binary number to the output with format of 4 character..
                output += charValue.substring(0, 4) + " ";
            }

            // If the last character of the input is q then convert the octal number to binary number.
        } else {

            // Get each character from the input.
            for (int i = 0; i < input.length() - 1; i++) {

                // Convert the character to binary number.
                charValue = getBinary(input.charAt(i), "01234567");

                // Add the binary number to the output with format of 3 character.
                output += charValue.substring(1, 4) + " ";
            }

        }

        // Return binary number that has been converted.
        return output.trim();
    }

    /**
     * Method to convert each character to binary number.
     *
     * @param input is a character.
     * @param validInput is the value of that character.
     *
     * @return the binary number of that character base on the value of it in
     * the array.
     */
    public String getBinary(char input, String validInput) {

        // Return the string that contain value of binary number base on the index of it in the array.
        return arr[validInput.indexOf(input)];
    }

}
