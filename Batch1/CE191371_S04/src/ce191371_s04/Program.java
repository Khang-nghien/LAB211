/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191371_s04;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * S04 - Check student’s data format.
 *
 * Class that run the program.
 *
 * @author Vu Minh Khang - CE191371 - 22/1/25
 */
class Program {

    // Private all field.
    // Scanner for getting the input from user.
    // The field check is the variable that contain input from user.
    // The field name is the name of the student.
    // The field classes is the class of the student.
    // The field mathScore is the math score of the student.
    // The field chemistryScore is the chemistry score of the student.
    // The field physicsScore is the physics score of the student.
    // The object checker is using to checking input from user.
    // The studentList is a hashmap that contain list of all student with the key is the name of the student and value is the info of the student.
    // The field loop to checkinf if the user want to continue using the program or not.
    private Scanner input = new Scanner(System.in);
    private String check;
    private String name;
    private String classes;
    private double mathsScore;
    private double chemistryScore;
    private double physicsScore;
    private IOChecking checker = new IOChecking();
    private HashMap<String, Student> studentsList = new HashMap<>();
    private String loop;

    /**
     * The method that run the program.
     */
    public void run() {

        // Using a do-while loop to re-enter the new student if the user want.
        do {
            System.out.println("====== Management Student Program ======");

            // Get all info of the student (name, class, math score, chemistry score, physics score).
            getStudentInfo();

            // After enter a student ask the user if they want to enter new student or not.
            // Re-enter if the user not enter y or n.
            do {
                System.out.print("Do you want to enter more student information?(Y/N):");
                loop = input.nextLine().trim().toUpperCase();

                // If the user enter y or n then break the loop.
            } while (!loop.equals("Y") && !loop.equals("N"));

            // If the user enter y then continue the program.
            // If the user enter n then stop the program.
        } while (loop.equals("Y"));

        // After enter all student then print all info of all student from the list.
        printInfo();

        // Print out the classification.
        printClassification();

    }

    /**
     * Get all the student info and add the student to the list.
     */
    public void getStudentInfo() {

        // Create a loop that dont break until the user enter name properly.
        while (true) {

            // Get the student name from user.
            System.out.print("Name:");
            check = input.nextLine().trim();

            // Checking if the user enter nothing.
            if (checker.checkNullValue(check, "Please enter something")) {

                // Checking if the user enter special character.
            } else if (checker.checkSpecialCharacter(check, "Plese do not enter special character.")) {

                // Checking the name already exist or not.
            } else if (checkName()) {

                // If the name is valid then assign it to name and break the loop.
            } else {
                name = check;
                break;
            }
        }

        // Create a loop that dont break until the user enter class properly.
        while (true) {
            System.out.print("Classes:");
            check = input.nextLine().trim();

            // Checking if the user enter nothing.
            if (checker.checkNullValue(check, "Please enter something")) {

                // Checking if the user enter special character.
            } else if (checker.checkSpecialCharacter(check, "Plese do not enter special character.")) {

                // If the class is valid then assign it to class and break the loop.
            } else {
                classes = check;
                break;
            }
        }

        // Create a loop that dont break until the user enter math score properly.
        while (true) {
            System.out.print("Maths:");
            check = input.nextLine().trim();

            // Checking if the user enter nothing.
            if (checker.checkNullValue(check, "Math is digits")) {

                // Checking if the user enter special character.          
            } else if (checker.checkContainCharacterAndSymbol(check, "Maths is digit")) {

                // Checking if the user enter negative number.
            } else if (Double.parseDouble(check) < 0) {
                System.out.println("Maths is greater than equal zero");

                // Checking if the user enter number that bigger than 10.
            } else if (Double.parseDouble(check) > 10) {
                System.out.println("Maths is less than equal ten");

                // If the math score is valid then assign it to math and break the loop.
            } else {
                mathsScore = Double.parseDouble(check);
                break;
            }
        }

        // Create a loop that dont break until the user enter chemistry score properly.
        while (true) {
            System.out.print("Chemistry:");
            check = input.nextLine().trim();

            // Checking if the user enter nothing.
            if (checker.checkNullValue(check, "Chemistry is digits")) {

                // Checking if the user enter special character.
            } else if (checker.checkContainCharacterAndSymbol(check, "Chemistry is digit")) {

                // Checking if the user enter negative number.
            } else if (Double.parseDouble(check) < 0) {
                System.out.println("Chemistry is greater than equal zero");

                // Checking if the user enter number that bigger than 10.
            } else if (Double.parseDouble(check) > 10) {
                System.out.println("Chemistry is less than equal ten");

                // If the chemistry score is valid then assign it to chemistry and break the loop.
            } else {
                chemistryScore = Double.parseDouble(check);
                break;
            }
        }

        // Create a loop that dont break until the user enter physics score properly.
        while (true) {
            System.out.print("Physics:");
            check = input.nextLine().trim();

            // Checking if the user enter nothing.
            if (checker.checkNullValue(check, "Physics is digits")) {

                // Checking if the user enter special character.
            } else if (checker.checkContainCharacterAndSymbol(check, "Physics is digit")) {

                // Checking if the user enter negative number.
            } else if (Double.parseDouble(check) < 0) {
                System.out.println("Physics is greater than equal zero");

                // Checking if the user enter number that bigger than 10.
            } else if (Double.parseDouble(check) > 10) {
                System.out.println("Physics is less than equal ten");

                // If the physics score is valid then assign it to physics and break the loop.
            } else {
                physicsScore = Double.parseDouble(check);
                break;
            }
        }

        // After enter all info student then add it to the list.
        studentsList.put(name,
                new Student(name, classes, mathsScore, chemistryScore, physicsScore));
    }

    /**
     * Checking the name that exist or not.
     *
     * @return true if the name is exist. False if the name is new.
     */
    public boolean checkName() {

        // Checking if the list contain this key.
        if (studentsList.containsKey(check)) {
            System.out.println("The name is exist.");

            // If it contain then return true.
            return true;
        }

        // If not then return false.
        return false;
    }

    /**
     * Print info of all student.
     */
    public void printInfo() {

        // Start from first student.
        int i = 1;

        // Get each student from the list using for-each.
        for (Map.Entry<String, Student> currentStudent : studentsList.entrySet()) {
            System.out.printf("------ Student%d Info ------\n", i);

            // Print out the info of that student.
            System.out.printf("%s\n", currentStudent.getValue().studentData());

            // Continue next student.
            i++;
        }
    }

    /**
     * Print out the classification.
     */
    public void printClassification() {

        // Set default quantity of all type student to 0.
        double A = 0;
        double B = 0;
        double C = 0;
        double D = 0;

        System.out.println("--------Classification Info -----");

        // Get each student from the list using for-each.
        for (Map.Entry<String, Student> currentStudent : studentsList.entrySet()) {

            // If the student is type A then increase quantity of A type by 1.
            if ("A".equals(currentStudent.getValue().typeCalculate())) {
                A++;

                // If the student is type B then increase quantity of B type by 1.
            } else if ("B".equals(currentStudent.getValue().typeCalculate())) {
                B++;

                // If the student is type C then increase quantity of C type by 1.
            } else if ("C".equals(currentStudent.getValue().typeCalculate())) {
                C++;

                // If the student is type D then increase quantity of D type by 1.
            } else {
                D++;
            }
        }

        // Print out the result of classificaiton of all student.
        // Each classification of each student type is calculate by quantity of that type divide to total student then multiply it with 100.
        System.out.printf("A:%.1f%%\n"
                + "B:%.1f%%\n"
                + "C:%.1f%%\n"
                + "D:%.1f%%\n", (A / studentsList.size()) * 100, (B / studentsList.size()) * 100, (C / studentsList.size()) * 100, (D / studentsList.size()) * 100);
    }
}
