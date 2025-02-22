/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191371_v04;

/**
 * V04 - Doctor manage program.
 * 
 * The main class of the program.
 *
 * @author Vu Minh Khang - CE191371 - 18/1/25
 */
public class CE191371_V04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         // Create an instance of Menu.
        DoctorHash user = new DoctorHash();
        
        // Call the method to display the menu and start the user interaction.
        user.program();
    }

}
