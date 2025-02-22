/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191371_s01;

/**
 * S01 - Program to insert new element into an existing array.
 * 
 * The main of the program
 *
 * @author Vu Minh Khang - CE191371 - 16/1/25
 */
public class CE191371_S01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Create an instance of Program.
        Program user = new Program();
        
        // Call the method to display the menu and start the user interaction.
        //user.run();
        // Creat new array.
        user.creatArray();
        
        // Sort the array.
        user.sort();
        
        // Print out the array.
        user.show();
        
        // Add new element to the array.
        user.add();
        System.out.println("New array:");
        
        // Print out the new array.
        user.show();
    }
    
}
