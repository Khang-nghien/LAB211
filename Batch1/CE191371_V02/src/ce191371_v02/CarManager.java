/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191371_v02;

import java.util.Scanner;

/**
 * V02- Showroom car.
 * 
 * The class run the program.
 *
 * @author Vu Minh Khang - CE191371 - 4/3/25
 */
public class CarManager {

    // Create all field and set it to private.
    // The Scanner is using for gettting input from the user.
    // The field check is using to check if the user want to continue or not.
    // The field type is the type of the car.
    // The field color is the color of the car.
    // The field price is the price of the car.
    // The field day sell is the day sell of the car.
    // The Object checker is using to check the information input car from user.
    private Scanner input = new Scanner(System.in);
    private String check;
    private String type;
    private String color;
    private String price;
    private String day;
    private ExceptionCar checker = new ExceptionCar();

    /**
     * Method to run the program.
     */
    public void run() {

        do {
            System.out.println("===== Showroom car program =====");
            System.out.println("Input Information of Car");

            // Get the information of the car.
            getCar();
            getColor();
            getPrice();
            getDay();

            // Check the information of the car is valid or not.
            checkCar();

            // Check if the user want to continue or not.
            checkContinue();
            
            // If user enter Y then continue.
        } while (check.equals("Y"));
    }

    /**
     * Method to get the type of car.
     */
    public void getCar() {
        System.out.print("Name: ");
        type = input.nextLine().trim().toUpperCase();
    }

    /**
     * Method to get the color of car.
     */
    public void getColor() {
        System.out.print("Color: ");
        color = input.nextLine().trim().toUpperCase();
    }

    /**
     * Method to get the price of car.
     */
    public void getPrice() {
        System.out.print("Price: ");
        price = input.nextLine().trim();
    }

    /**
     * Method to get the day sell of car.
     */
    public void getDay() {
        System.out.print("Today: ");
        day = input.nextLine().trim().toUpperCase();
    }

    /**
     * Method to check the information of the car input is valid or not.
     */
    public void checkCar() {

        // Check the information.
        if (checker.checkValidCar(type, color, day, price)) {
            
            // If the car is valid then notify it.
            System.out.println("Sell Car");
        }
    }

    /**
     * Method to check if user want to continue or not.
     */
    public void checkContinue() {
        while (true) {
            
            // Get choice from user.
            System.out.print("Do you want find more?(Y/N):");
            check = input.nextLine().trim().toUpperCase();

            // If user enter enter Y or N then break the loop.
            if (check.equals("Y") || check.equals("N")) {
                break;
            }

            // If user enter not enter Y or N then notify and ask them to re-enter.
            System.out.println("Please only enter Y or N");
        }
    }
}
