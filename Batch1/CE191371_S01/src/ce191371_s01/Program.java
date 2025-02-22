/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191371_s01;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * S01 - Program to insert new element into an existing array.
 * 
 * The class that run the program.
 *
 * @author Vu Minh Khang - CE191371 - 16/1/25
 */
public class Program {
    
    // Private all field.
    // Scanner for getting the input from user.
    // The number field is using for input.
    // The validNumber field is the new element to the array.
    // The check is using to check the input from user.
    // The size field is the size of the array.
    // The temp field is using for sorting.
    // The location field is the position that insert new element.
    // The array is the array that user create.
    private Scanner input = new Scanner(System.in);
    private String number;
    private int validNumber;
    private IOChecking check = new IOChecking();
    private int size;
    private int temp;
    private int location;
    private ArrayList<Integer> array = new ArrayList<>();

    /**
     * Run the program.
     */
    public void run() {
        
        
    }

    /**
     * Create a new array with the size from user and get value for each element
     * from user.
     */
    public void creatArray() {
        
        // Run the loop until the array is succesfully create.
        while (true) {

            // Get the input from user and trim it.
            System.out.print("Please enter size of array:");
            number = input.nextLine().trim();

            // Checking if user enter any special character or symbol.
            if (check.checkValid(number)) {

                // Checking if user enter negative number.
            } else if (check.checkOutOfRange(number, 1, 999999999)) {
                System.out.println("Please only enter positive number.");

                // If the user enter valid number and break the loop.
            } else {
                size = Integer.parseInt(number);
                break;
            }
        }

        // Add value to the array.
        for (int i = 0; i < size; i++) {

            // Get the valid number for each element in array.
            while (true) {
                System.out.printf("Enter element[%d]:", i);
                number = input.nextLine().trim();

                // Checking if the input is a valid number.
                if (!check.checkValid(number)) {

                    // If the input is valid then break add it to the array and the break loop.
                    array.add(Integer.parseInt(number));
                    break;
                }
            }
        }
    }

    /**
     * Sorting the array using bubble sort.
     */
    public void sort() {

        System.out.println("The array after sorting:");

        // Sorting the array without the last element.
        for (int i = size - 1; i > 0; i--) {

            // Get each element from array for checking.
            for (int j = 0; j < i; j++) {

                // If the next element bigger than current element then swap them.
                if (array.get(j) > array.get(j + 1)) {

                    // Swap two elemnt using temp variable.
                    // Set the value of the j element to temp.
                    temp = array.get(j);
                    
                    // Set the value of the next element next to j element to j.
                    array.set(j, array.get(j + 1));
                    
                    // Set the value of temp to the element next to j.
                    array.set(j + 1, temp);
                }
            }
        }
    }

    /**
     * Show every element that contain in the array.
     */
    public void show() {

        // Running from the first element to the last element and print out.
        for (int i = 0; i < size; i++) {
            System.out.print(array.get(i) + "     ");
        }

        System.out.println("");
    }
    
    /**
     * Add new element to the array.
     */
    public void add() {

        // Get a valid number to add in array.
        while (true) {
            System.out.print("Please enter new value:");
            number = input.nextLine().trim();

            // Checking if the input is a valid number.
            if (!check.checkValid(number)) {

                // If the input is valid then break add it to the array and the break loop.
                validNumber = Integer.parseInt(number);
                break;
            }
        }

        // Increase the size of the array to 1.
        size++;
        
        // Checking if the new number is bigger than the last number.
        // If its bigger then add it at the last array and stop. 
        if (validNumber > array.get(size - 2)) {
            array.add(validNumber);
            return;
        }
        
        // If its not bigger then adding the new number to the last of the array and continue the program.
        array.add(validNumber);
        
        // Running from the first element to the last element to the get location that need to add.
        for (int i = 0; i < size - 1; i++) {

            // If the new element smaller than current element then get the location of it and break the loop.
            if (validNumber < array.get(i)) {
                location = i;
                break;
            }
        }

        // Insert the new element to the array.
        for (int i = location; i < size - 1; i++) {

            // Swapping the current element and the last element in the array.
            // Set the value of element that stand after the new element to temp.
            temp = array.get(i);
            
            // Set the value of the last element to the element that location at new element that insert.
            array.set(i, array.get(size - 1));
            
            // Set the value of temp to the last element.
            array.set(size - 1, temp);
        }
    }
}



