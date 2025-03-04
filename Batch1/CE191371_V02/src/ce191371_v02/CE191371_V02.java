/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191371_v02;

/**
 * V02 - Showroom car.
 * 
 * The main class of the program.
 * 
 * @author Vu Minh Khang - CE191371 - 4/3/25
 */
public class CE191371_V02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Create an instance of program.
        CarManager manager = new CarManager();
        
        // Call the method to display the menu and start the user interaction.
        manager.run();
        
    }
    
}
