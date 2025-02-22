/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191371_s02;

import java.util.Scanner;

/**
 * S02 - Reverse a string.
 *
 * The class that run the program.
 *
 * @author Vu Minh Khang - CE191371 - 22/1/25
 */
public class Program {

    // Private all field.
    // Scanner for getting the input from user.
    // The str field is the input string from user.
    // The newStr field is the string that had been reversed.
    // The temp field is the position in the string that contain space or underscore.
    // The sub field is sub string that get from the input string that contain space or underscore before or after it.
    private Scanner input = new Scanner(System.in);
    private String str = "";
    private String newStr;
    private String choice;
    private int temp;
    private String sub;

    /**
     * The method that run the program.
     */
    public void run() {

        // Create a loop that run the program until the user is exit.
        do {

            // Get valid input from user.
            while (true) {

                // Get the input string from user.
                System.out.print("Please enter string: ");
                str = input.nextLine().trim();

                // Check if the user enter nothing then notify it to user.
                if (str.length() != 0) {
                    break;
                }
                System.out.println("Please enter something.");
            }

            // Print out the input string.
            System.out.println("The old string: " + str);

            // Reversed the string.
            reversed();

            // Print out the new reversed string.
            System.out.println("The reversed string: " + newStr.trim());

            // Ask the user if they want to continue or not.
            System.out.println("Please enter to continue another reverse, ESC to exit.");

            while (true) {
                // Get the choice from user.
                choice = input.nextLine().trim().toLowerCase();

                // If user not press enter or esc then continue ask the user to re-enter.
                // If not then break.
                if (choice.equals("") || choice.equals("esc")) {
                    break;
                }
            }

            // If user press enter then continue.
        } while (choice.equals(""));
    }

    /**
     * The method that revered the string into the new string when encounter
     * spaces or underlines.
     */
    public void reversed() {

        // Set the temp to the position of the last char of the input string.
        // Set the newStr to null value.
        temp = str.length();
        newStr = "";

        // Run from the last character of the string to the first character of the string.
        for (int i = str.length() - 1; i > 0; i--) {

            // When encounter space in the string.
            if (str.charAt(i) == ' ') {

                // Create a sub string from the character that stand after space to the temp position.
                sub = str.substring(i + 1, temp);

                // Concatenate it to the new string with the space.
                newStr += sub + ' ';

                // Set the temp postion to the space position.
                temp = i;
            }

            // When encounter underline in the string.
            if (str.charAt(i) == '_') {

                // Create a sub string from the character that stand after underline to the temp position.
                sub = str.substring(i + 1, temp);

                // Concatenate it to the new string with the underline.
                newStr += sub + "_";

                // Set the temp postion to the underline position.
                temp = i;
            }

        }

        // Create a sub string from the first character to the character that stand before the space or underline.
        sub = str.substring(0, temp);
        // Concatenate it to the new string.
        newStr += sub;
    }
}
