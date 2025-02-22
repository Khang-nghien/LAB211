/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191371_s07;

/**
 * S07 - Employee management program.
 * 
 * The main class of the program.
 *
 * @author Vu Minh Khang - CE191371 - 12/2/25
 */
public class CE191371_S07 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Create an instance of Menu.
        Emp_Manager user = new Emp_Manager();
        
        // Call the method to display the menu and start the user interaction.
        user.run();

    }

}
