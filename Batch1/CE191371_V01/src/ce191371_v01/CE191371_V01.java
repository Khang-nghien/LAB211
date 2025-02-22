/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191371_v01;

import java.util.Scanner;

/**
 * V01 - Lucky Number
 *
 * This class to start the program.
 *
 * @author Vu Minh Khang - CE191371 - 7/1/2025
 */
public class CE191371_V01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Create an instance of program
        Program user = new Program();

        // Call the method to display the menu and start the user interaction.
        user.program();

        Scanner input = new Scanner(System.in);
        String choice;
        System.out.println("-LUCKY NUMBER GAME-");

        // Play the game.
        do {

            // Create new game. 
            user.play();

            // Ask the user if they want to continue or not.
            // Get the choice from the user.
            do {
                System.out.print("Do you want to continue(Y/N)? ");
                choice = input.nextLine().trim().toLowerCase();
                System.out.println("");
                
            // If the user enter y/yes/n/no then break the loop.
            } while (!("no".equals(choice)) && !("n".equals(choice)) && !"yes".equals(choice) && !"y".equals(choice));

        } while ("yes".equals(choice) || "y".equals(choice)); // Check if the user want to continue (Y/y/Yes/yes for continue, others is stop).

        // If the user do not want to play anymore then print out the result from all game (total game, total guess, guess average, best game).
        System.out.println("\n-Here are the result-");
        System.out.println(user.getResult());
        System.out.println("Thanks for playing.");
    }

}
