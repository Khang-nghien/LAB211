/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191371_s07;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * S07 - Employee management program.
 *
 * The class that run the program.
 *
 * @author Vu Minh Khang - CE191371 - 12/2/25
 */
public class Emp_Manager {

    // Create all field and set it to private.
    // The Scanner is using for getting input from the user.
    // The Object checker is using for checking error from input.
    // The field choice is the choice of the user.
    // The field loop is using to run the program until the user exit.
    // The field check is the input from user.
    // The field numberEmployee is the number of employee to add to the list.
    // The field id is the id of the employee.
    // The field name is the name of the employee.
    // The field salary is the salary of the of the employee.
    // The field coe is the coefficient salary of the employee.
    // The HashMap employeeList is the list that contain all the employee.
    private Scanner input = new Scanner(System.in);
    private IOChecking checker = new IOChecking();
    private String choice;
    private boolean loop;
    private String check;
    private int numberEmployee;
    private String id;
    private String name;
    private double salary;
    private double coe;
    private HashMap<String, Employee> employeeList = new HashMap<>();
    private Employee employee;

    /**
     * Method to run the program.
     */
    public void run() {

        // Set the loop to infiity.
        loop = true;

        // Create a loop to run the program.
        while (loop) {
            menu();

            // Get choice from user.
            System.out.print("Please choose: ");
            choice = input.nextLine().trim();

            switch (choice) {

                // If the user choose option 1.
                case "1":

                    // Add new employee.
                    add();
                    break;

                // If the user choose option 2.
                case "2":

                    // Show all employee.
                    show();
                    break;

                // If the user choose option 0.
                case "0":

                    // Exit the program.
                    System.out.println("SEE YOU AGAIN!");
                    loop = false;
                    break;

                // If the user dont choose a valid options.
                default:
                    System.out.println("Not a valid option.");
            }

        }

    }

    /**
     * Method to print out the menu.
     */
    public void menu() {
        System.out.println("----------MENU----------");
        System.out.println("1. Input employee.\n"
                + "2. Show list employee.\n"
                + "0. Exit.");
    }

    /**
     * Method to add new employee to the list.
     */
    public void add() {

        // Get number of employee.
        getNumberEmployee();

        // Add the infomation of the employee to the list.
        for (int i = 0; i < numberEmployee; i++) {
            System.out.println("- Employee " + (i + 1) + ":");

            // Create a loop to get a id number.
            System.out.print("--Please enter id number: ");
            while (true) {
                check = input.nextLine().trim().toUpperCase();

                // Check if the user dont enter anything.
                if (checker.checkNullValue(check, "--------Erorr! Please id number again (Not Null):")) {

                    // Check if the user not enter a valid id.
                } else if (checker.checkValidID(check, "")) {
                    System.out.print("--------Erorr! Please id number again (NVxxxx):");

                    // Check if the id is exsit or not.
                } else if (employeeList.containsKey(check)) {
                    System.out.print("--------Erorr! Please id number again (Exist ID):");

                    // If the user enter a valid id then break the loop.
                } else {
                    id = check;
                    break;
                }
            }

            // Create a loop to get a name.
            System.out.print("--Please enter name: ");
            while (true) {
                check = input.nextLine().trim();

                // Check if the user dont enter anything.
                if (checker.checkNullValue(check, "--------Erorr! Please name again (Not Null):")) {

                    // Check if the user enter special character.
                } else if (checker.checkValidName(check, "--------Erorr! Please name again (No special character.):")) {

                    // If the user enter a valid name then break the loop.
                } else {
                    name = check;
                    break;
                }
            }
            
            // Create a loop to get basic salary.
            System.out.printf("--Please enter salary: ");
            while (true) {
                check = input.nextLine().trim();

                // Check if the user dont enter anything.
                if (checker.checkNullValue(check, "--------Erorr! Please salary again (Not Null):")) {

                    // Check if the user enter special character.
                } else if (checker.checkContainCharacterAndSymbol(check, "--------Erorr! Please name again (No special character.):")) {

                    // Check if the user enter a salary of out range (below 100).
                } else if (checker.checkOutOfRange(check, 101, 999999999, "-----Erorr! Please coefficients salary again (Salary > 100 USD):")) {

                    // If the user enter a valid salary then break the loop.
                } else {
                    salary = Double.parseDouble(check);
                    break;
                }
            }

            // Create a loop to get coe.
            System.out.printf("--Please enter coefficients salary: ");
            while (true) {
                check = input.nextLine().trim();

                // Check if the user dont enter anything.
                if (checker.checkNullValue(check, "--------Erorr! Please  salary again (Not Null):")) {

                    // Check if the user enter special character.
                } else if (checker.checkContainCharacterAndSymbol(check, "--------Erorr! Please name again (No special character.):")) {

                    // Check if the user enter a coe of out range (1 to 5).
                } else if (checker.checkOutOfRange(check, 1.0, 5.0, "-----Erorr! Please coefficients salary again (From 1 to 5):")) {

                    // If the user enter a valid coe then break the loop.
                } else {
                    coe = Double.parseDouble(check);
                    break;
                }
            }

            // Add new employee to the hashmap.
            employeeList.put(id, new Employee(id, name, salary, coe));
        }

    }

    /**
     * Method to get number of employee.
     */
    public void getNumberEmployee() {

        // Create a loop to get number of employee.
        while (true) {
            System.out.print("+ Enter number of Employee: ");
            check = input.nextLine().trim();

            // Check if the user enter null or not.
            if (checker.checkNullValue(check, "Please enter number of employee.\n")) {

                // Check if the user not enter integer number or not.
            } else if (checker.checkContainCharacterAndSymbol(check, "Please only enter valid integer number.\n")) {

                // Check if the user enter negative number.
            } else if (checker.checkOutOfRange(check, 1, 99999999, "Please enter positive integer number.\n")) {

                // If it a valid number of employee then break the loop.
            } else {
                numberEmployee = Integer.parseInt(check);
                break;
            }
        }
    }

    /**
     * Method to show all the employee in the list.
     */
    public void show() {
        
        if (employeeList.isEmpty()) {
            System.out.println("There are no employee in the list currently.");
            return;
        }
        
        System.out.println("===================List Employee=================================");
        System.out.println("|ID          |Name                |Salary      |COE| Total salary");

        // Get each employee from the hashmap and get its value.
        for (Map.Entry<String, Employee> currentEmployee : employeeList.entrySet()) {

            // Print out the information of each employee.
            System.out.printf("|%-12s|%-20s|%-12.0f|%-2.1f|%13.2f\n", currentEmployee.getValue().getId(), currentEmployee.getValue().getName(), currentEmployee.getValue().getSalaray(), currentEmployee.getValue().getCOE() , calSalary(currentEmployee.getValue().getSalaray(), currentEmployee.getValue().getCOE()));
        }
    }
    
    /**
     * Method to calculate the salary of the employee base on COE and basic
     * salary.
     *
     * @param salary is the basic salary of the employee.
     * @param COE is the coefficient of the employee.
     * 
     * @return the salary of the employee.
     */
    public double calSalary(double salary, double COE) {
        
        // Multiply the basic salary with the COE to get the salary.
        return salary * COE;
    }
}
