/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191371_s08;

import java.util.Scanner;

/**
 * S08 - Convert hexadecimal, octal to binary.
 *
 * The class run the program.
 *
 * @author Vu Minh Khang - CE191371 - 12/2/25
 */
public class Program {

    // Create all field and set it to private.
    // The Scanner is using for getting input from the user.
    // The field check is the input from user.
    // The Object converter is using to checking and convert the input from user to binary number.
    private Scanner input = new Scanner(System.in);
    private String check;
    private Convert converter = new Convert();

    /**
     * Method to start the program.
     */
    public void run() {

        do {

            System.out.println("Convert Hexadecimal number / Octal number to Binary program");

            // Get input from user until it valid.
            while (true) {

                // Get the input from user.
                System.out.print("\tEnter a Hexadecimal (h) / Octal (q) number:");
                check = input.nextLine().trim().toLowerCase();

                // Check if the input from user is valid or not.
                if (converter.checkValidInput(check)) {

                    // If yes then break the loop.
                    break;
                }
            }

            // Print out the binary number that has been converted.
            System.out.println("\tBinary number: " + converter.convertToBinary(check) + "b");

            // Check if the user want to do it again or not.
        } while (go());

        System.out.println("Thank for using our application.");
    }

    /**
     * Method to check the user want to do the program again or not.
     *
     * @return true if the user want to do it again. No if not.
     */
    public boolean go() {
        
        // Get input from user.
        System.out.println("Press any key to do another conversion.");
        check = input.nextLine().trim();
        
        // Check if the user do not enter anything.
        // Dont enter anything = exit the program.
        if (check.length() == 0) {
            
            // Return false if the user dont enter anything.
            return false;
        }
        
        // Return true if the user enter any character.
        return true;

    }
}
