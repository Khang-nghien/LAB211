/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191371_v06;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * V06 - Array and string manipulations.
 *
 * The class that run the program.
 *
 * @author Vu Minh Khang - CE191371 - 13/2/25
 */
public class Program {
    
    // Create all field and set it to private.
    // The Scanner is using for getting input from the user.
    // The field run is using to running the program until the user stop.
    // The field check is the input from user.
    // The Object checker is using for checking error from input.
    // The ArrayList is using for storage all the student.
    // The Object Student temp is using for swapping 2 student.
    private Scanner input = new Scanner(System.in);
    private boolean run;
    private String check;
    private IOChecking checker = new IOChecking();
    private ArrayList<Student> studentList = new ArrayList<>();
    private Student temp;

    /**
     * Method to run the program.
     */
    public void run() {

        // Set the loop to infinity.
        run = true;
        System.out.println("=========== Student Management ==========\n");

        while (run) {

            // Print out the menu.
            menu();

            // Get the choice of user until it valid.
            while (true) {

                // Get the choice from user.
                System.out.print("Enter your choice: ");
                check = input.nextLine().trim();

                // Check if the choice is null or not.
                if (checker.checkNullValue(check, "Please enter a choice.")) {

                    // Check if the choice contain character.
                } else if (checker.checkContainCharacterAndSymbol(check)) {
                    System.out.println("Please do not enter character.");

                    // If not then break the loop.
                } else {
                    System.out.println("");
                    break;
                }
            }

            // Run the 
            switch (check) {

                // Run the choice 1.
                case "1":

                    // Add new student name to the list.
                    add();
                    break;

                // Run the choice 2.
                case "2":

                    // Remove a student name from the list.
                    remove();
                    break;

                // Run the choice 3.
                case "3":

                    // Search a student name from the list.
                    search();
                    break;

                // Run the choice 4.
                case "4":

                    // Print out all the student name from the list.
                    print();
                    break;

                // Run the choice 5.
                case "5":

                    // Stop the program.
                    run = false;
                    break;

                // If the user choose the choice that dont exist then notify it to user.
                default:
                    System.out.println("Please only enter valid choice (1-5).");
            }
        }

        System.out.println("Thank for using the program.");
    }

    /**
     * Method print out the menu.
     */
    public void menu() {

        System.out.println("*****************************************");
        System.out.println("1 - Add a student.");
        System.out.println("2 - Remove a student.");
        System.out.println("3 - Search a student.");
        System.out.println("4 - Print list student in an ascending folder.");
        System.out.println("5 - Exit.");
        System.out.println("*****************************************\n");
    }

    /**
     * Method to add new student name to the list.
     */
    public void add() {

        // Run until get a valid student name.
        while (true) {
            System.out.print("Enter student name: ");
            check = input.nextLine().trim();

            // Check if the name is null or not.
            if (checker.checkNullValue(check, "Please enter a name.")) {

                // Check if the name is valid or not.
            } else if (checker.checkName(check, "Please enter a valid name.")) {

                // If it was a valid name then create a new student with that name and add it to the list and break the loop.
            } else {

                // Add new student to the list.
                studentList.add(new Student(check, check.length()));

                // Sort the student name by there length.
                sort();
                System.out.println("Student has been added to list successfully!\n");
                break;
            }
        }

    }

    /**
     * Method to remove a student name from the list.
     */
    public void remove() {

        // Check if the list is empty or not.
        if (studentList.isEmpty()) {

            // If yes then notify it to user.
            System.out.println("There are no student in the list currently.");
            return;
        }

        // If the list is contain at least 1 student then ask the student name to remove.
        // Get the valid name from user.
        while (true) {

            // Get the student name.
            System.out.print("Enter student name to remove: ");
            check = input.nextLine().trim();

            // Check if the student name is null or not.
            if (checker.checkNullValue(check, "Please enter a name.")) {

                // Check if the student name is a valid name or not.
            } else if (checker.checkName(check, "Please enter a valid name.")) {

                // If it was a valid name then stop the loop.
            } else {
                break;
            }
        }

        // Run from the first student in the list to the last student in the list.
        for (int i = 0; i < studentList.size(); i++) {

            // Check the student name in the list joint with the user input (ingnore the case all letter). 
            if (check.equalsIgnoreCase(studentList.get(i).getName())) {

                // Remove the first student suit with the input from user.
                studentList.remove(i);
                System.out.println("Student name has been removed successfully!\n");
                return;
            }
        }

        // If there are no student name in the list joint with the user input then notify it to the user.
        System.out.println("Student name not exist in the list!\n");

    }

    /**
     * Method to find a student in the list and print out it position in the
     * list.
     */
    public void search() {

        // Check if the list is empty or not.
        if (studentList.isEmpty()) {

            // If yes then notify it to user.
            System.out.println("There are no student in the list currently.");
            return;
        }

        // If the list is contain at least 1 student then ask the student name to remove.
        // Get the valid name from user.
        while (true) {
            
            // Get the student name.
            System.out.print("Enter student name to search: ");
            check = input.nextLine().trim();

            // Check if the student name is null or not.
            if (checker.checkNullValue(check, "Please enter a name.")) {

                // Check if the student name is a valid name or not.
            } else if (checker.checkName(check, "Please enter a valid name.")) {

                // If it was a valid name then break the loop.
            } else {
                //System.out.println(check);
                break;
            }
        }
        
        // Run from the first student in the list to the last student in the list.
        for (int i = 0; i < studentList.size(); i++) {
            
            // Check the student name in the list joint with the user input (ingnore the case all letter). 
            if (studentList.get(i).getName().toLowerCase().contains(check.toLowerCase())) {
                
                // Print out the position of that student in the list.
                System.out.println("The position of student name in list is " + (i + 1) + ".");
                System.out.println("");
                return;
            }
        }

        // If there are no student name in the list joint with the user input then notify it to the user.
        System.out.println("Student name not exist in the list!\n");
    }
    
    /**
     * Print out all the student in the list.
     */
    public void print() {

        // Check if the list is empty or not.
        if (studentList.isEmpty()) {

            // If yes then notify it to user.
            System.out.println("There are no student in the list currently.");
            return;
        }
        
        // Print out the quantity student in the list.
        System.out.println("Total student: " + studentList.size());
        
        // Run from the first student in the list to the last student in the list.
        for (int i = 0; i < studentList.size(); i++) {
            
            // Print out the student name.
            System.out.println((i + 1) + ". " + studentList.get(i).getName());
        }
        System.out.println("");
    }

    /**
     * Method to sorting the list with student name length using bubble sort.
     */
    public void sort() {
        
        // Check if the list is empty or only contain 1 name or not.
        if (studentList.isEmpty() || studentList.size() == 1) {
            
            // If yes then return.
            return;
        }

        // Sorting the list without the last element.
        for (int i = studentList.size() - 1; i > 0; i--) {

            // Get each student from list for checking.
            for (int j = 0; j < i; j++) {

                // If the next student name length bigger than student name length then swap them.
                if (studentList.get(j).getNameLength() > studentList.get(j + 1).getNameLength()) {

                    // Swap two student using temp variable.
                    // Set the value of the current student to temp.
                    temp = studentList.get(j);

                    // Set the value of the next student next to curent student to student.
                    studentList.set(j, studentList.get(j + 1));

                    // Set the value of temp to the next student next to curent student.
                    studentList.set(j + 1, temp);
                }
            }
        }
    }

}
