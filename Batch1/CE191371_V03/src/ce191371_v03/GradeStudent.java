/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191371_v03;

import java.util.Scanner;

/**
 * V03 - Grade Student
 *
 * This class is show the user menu and run program.
 *
 * @author Vu Minh Khang - CE191371 - 12/1/2025
 */
public class GradeStudent {

    // Create all field and set it to private.
    // The Scanner is using for gettting input from the user.
    // The number field is using for checking if the user enter a valid number or not.
    // The validNumber field is using to set the field value of the student.
    // The assignment field array is using to check the enter of the homeword score and max is valid or not.
    // The finalScore is using for showing the total point that student get from midterm, finalterm and homework.
    // The numberAssignment is using for check how many homework student had.
    private Scanner input = new Scanner(System.in);
    private Student student = new Student();
    private String number;
    private int validNumber;
    private String assignment[];
    private double finalScore;
    private int numberAssignment;

    /*
     * Display the program and start the program.
     */
    public void begin() {

        // Set the finalScore to 0.
        finalScore = 0;
        System.out.println("“This program reads exam/homework scores and reports your overall course grade”.\n");

        // Start get the score from mid-term and calculate it.
        midTerm();
        System.out.println("");

        // Start get the score from final-term and calculate it.
        finalTerm();
        System.out.println("");

        // Start get the score from homework and calculate it.
        homework();
        System.out.println("");

        // Print out the result of that student.
        report();
    }

    /**
     * Get the score from mid-term and calculate it.
     */
    public void midTerm() {

        // Set the number to null.
        // Set the validNumber to 0.
        number = null;
        validNumber = 0;
        System.out.println("MidTerm:");

        // Get valid weight number.
        getWeightValid();

        // Adding that valid weight number to totalWeight.
        student.setTotalWeight(student.getTotalWeight() + validNumber);

        // Get valid score number.
        getScoreValid();

        // Shifted the score.
        shiftedScore();

        // Print out the result total point of mid-term and the weight score of mid-term.
        System.out.println("Total point: " + student.getScore() + " / 100");
        System.out.printf("Weighted score = %.1f / %d\n", student.calculateWeightScore(), student.getWeight());

        // Add the weight score to the finalScore.
        finalScore += student.calculateWeightScore();
    }

    /**
     * Get the score from final-term and calculate it.
     */
    public void finalTerm() {

        // Set the number to null.
        // Set the validNumber to 0.
        number = null;
        validNumber = 0;
        System.out.println("Final:");

        // Get valid weight number.
        while (true) {
            getWeightValid();

            // If the totalWeight is bigger than 100 then request the user re-enter the weight. 
            if (student.getTotalWeight() + validNumber > 100) {
                System.out.println("The total weight can not bigger than 100.");

                // If not then stop.
            } else {
                break;
            }
        }

        // Adding that valid weight number to totalWeight.
        student.setTotalWeight(student.getTotalWeight() + validNumber);

        // Get valid score number.
        getScoreValid();

        // Shifted the score.
        shiftedScore();

        // Print out the result total point of final-term and the weight score of final-term.
        System.out.println("Total point: " + student.getScore() + " / 100");
        System.out.printf("Weighted score = %.1f / %d\n", student.calculateWeightScore(), student.getWeight());

        // Add the weight score to the finalScore.
        finalScore += student.calculateWeightScore();
    }

    /**
     * Get the score from homework and sections and calculate it.
     */
    public void homework() {

        // Set the number to null.
        // Set the validNumber to 0.
        number = null;
        validNumber = 0;
        System.out.println("Homework:");

        // Get valid weight number.
        while (true) {
            getWeightValid();

            // If the totalWeight is exactly = 100 then continue. 
            if (student.getTotalWeight() + validNumber == 100) {
                student.setTotalWeight(student.getTotalWeight() + validNumber);
                break;

                // If not then request the user to re-enter.
            } else {
                System.out.println("The total weight need to be exactly 100.");
            }
        }

        // Get valid assignment score.
        getValidAssignmentScore();

        // Get valid sections score (1 section = 5 section score).
        while (true) {
            System.out.print("How many sections did you attend? ");
            number = input.nextLine().trim();

            // Checking the input is valid or not.
            if (!checkValid(number)) {

                // Checking the input is in range or not (max section = 6, min is 0)
            } else if (validNumber > 6 || validNumber < 0) {
                checkValid("not ok");

                // If the input section is valid then continue.
            } else {
                student.setSectionsScore(validNumber * 5);
                break;
            }
        }

        // Print out the section points, total point of homework, weight score of homework.
        System.out.printf(
                "Section points = %d / 30\n", student.getSectionsScore());
        System.out.printf(
                "Total points = %d / %d\n", (student.getTotalAssignmentScore() + student.getSectionsScore()), (student.getMaxAssignmentScore() + 30));
        System.out.printf(
                "Weighted score = %.1f / %d\n", student.calculateHomeworkWeightScore(), student.getWeight());;
        // Add the weight score to the finalScore.
        finalScore += student.calculateHomeworkWeightScore();
    }

    /**
     * Print out the overall weight score and min grade of that student.
     */
    public void report() {

        // Print out the total overall percentage point of that student.
        System.out.printf("Overall percentage = %.1f\n", finalScore);

        // If total overall percentage is bigger than 85 then send out that student grade will be at least 3.0.
        if (finalScore >= 85.0) {
            System.out.println("Your grade will be at least: 3.0");

            // If total overall percentage is bigger than 75 and smaller than 65 then send out that student grade will be at least 2.0.
        } else if (finalScore >= 75.0) {
            System.out.println("Your grade will be at least: 2.0");

            // If total overall percentage is bigger than 60 and smaller than 75 then send out that student grade will be at least 0.7.
        } else if (finalScore >= 60.0) {
            System.out.println("Your grade will be at least: 0.7");

            // If that student dont reach any require above then send out that student grade will be at least 0.0.
        } else {
            System.out.println("Your grade will be at least: 0.0");
        }

        // Congrat the student on that grade.
        System.out.println("Congratulation on your grade.");
    }

    /**
     * Get valid score from user.
     */
    public void getScoreValid() {

        // Request the user enter score until it is a valid value.
        while (true) {

            System.out.print("Score earned? ");
            number = input.nextLine().trim();

            // Checking if the score is character or not.
            if (!checkValid(number)) {

                // Checking if the score is in range or not.
            } else if (validNumber < 0 || validNumber > 100) {
                checkValid("not ok");

                // If the score is a valid number then break the loop.
            } else {
                student.setScore(validNumber);
                break;
            }
        }
    }

    /**
     * Get valid weight from user.
     */
    public void getWeightValid() {

        // Request the user enter weight until it is a valid value.
        while (true) {

            // Get input from user.
            System.out.print("Weight (0-100)? ");
            number = input.nextLine().trim();

            // Checking if the score is character or not.
            if (!checkValid(number)) {

                // Checking if the score is in range or not.
            } else if (validNumber < 0 || validNumber > 100) {
                checkValid("not ok");

                // If the score is a valid number then break the loop.
            } else {
                student.setWeight(validNumber);
                break;
            }

        }
    }

    /**
     * Shift the score of the student.
     */
    public void shiftedScore() {

        // Set the number to null.
        // Set the validNumber to 0.
        validNumber = 0;
        number = null;

        // Request the user enter weight until it is a valid choice.
        while (true) {

            // Get input from user.
            System.out.print("Were score shifted (1=yes, 2=no)? ");
            number = input.nextLine().trim();

            // Checking if the score is character or not.
            if (!checkValid(number)) {

                // Checking if the score is a valid choice.
            } else if (validNumber < 1 || validNumber > 2) {
                checkValid("not ok");

                // If the score is a valid choice then break the loop.
            } else {

                // If the user choose 1 then shifter the score of the student by the amount of the user enter.
                if (validNumber == 1) {

                    // Run the loop to get the valid shift amount.
                    while (true) {

                        // Get the shift amount from user.
                        System.out.printf("Shift amount? ");
                        number = input.nextLine().trim();

                        // Checking if the score input is a valid number or not.
                        if (!checkValid(number)) {

                            // If the score + shift score < 0 then set 0 to the score of the student and break the loop.
                        } else if (Integer.parseInt(number) + student.getScore() < 0) {
                            student.setScore(0);
                            break;

                            // If the score + shift score > 100 then set 100 to the score of the student and break the loop.
                        } else if (Integer.parseInt(number) + student.getScore() > 100) {
                            student.setScore(100);
                            break;

                            // Adding the shift amount to student score and break the loop.
                        } else {
                            student.setScore(Integer.parseInt(number) + student.getScore());
                            break;
                        }
                    }
                }

                // Exit the shift score method after get changing the score with the shift amount.
                break;
            }
        }
    }

    /**
     * Get a valid assignment score.
     */
    public void getValidAssignmentScore() {

        // Request the user enter number of assignment until it is a valid number.
        while (true) {
            System.out.print("Number of assignments? ");
            number = input.nextLine().trim();

            // Checking if the number of assignment is valid or not.
            if (checkValid(number)) {
                numberAssignment = Integer.parseInt(number);

                // If the assignment number is a negative number then notify to the user.
                if (numberAssignment < 0) {
                    System.out.println("Please only enter valid assignment number.");

                    // If the assignment number is valid then continue.
                } else {
                    break;
                }
            }
        }

        // Get the score and max point for each assignment.
        for (int i = 0; i < numberAssignment; i++) {

            // Request the user enter score and max point of assignment until it is a valid.
            while (true) {
                System.out.print("Assigment " + (i + 1) + " score and max? ");
                number = input.nextLine().trim();

                // Cutting the input assignment at space character.
                assignment = number.split(" ");

                // If the user enter not exactly 2 number then notify it to user.
                if (assignment.length != 2) {
                    System.out.println("You need to enter exactly 2 number.");

                    // Checking if the score of the assignment is valid or not.
                } else if (!checkValid(assignment[0])) {

                    // Checking if the max score of the assignment is valid or not.
                } else if (!checkValid(assignment[1])) {

                    // Checking if the max score and the score of the assignment is negative or not.
                } else if (Integer.parseInt(assignment[0]) < 0 || Integer.parseInt(assignment[1]) < 0) {
                    checkValid("ok");

                    // Checking if the score of the assignment is bigger the max score of the assignment
                } else if (Integer.parseInt(assignment[0]) > Integer.parseInt(assignment[1])) {
                    System.out.println("Assignment score cannot bigger than score max and score max can not bigger than 150");

                    // If the score and max score of assignment is valid.
                } else {

                    // If the max score assignment of student is pass 150 then set it 150 (max assignment score is 150).
                    if (student.getMaxAssignmentScore() >= 150) {
                        student.setMaxAssignmentScore(150);

                        // Adding the assignment score of the student to the total assignment score and the max assignment score to the max assignment score.
                    } else {
                        student.setMaxAssignmentScore(Integer.parseInt(assignment[1]) + student.getMaxAssignmentScore());
                        student.setTotalAssignmentScore(Integer.parseInt(assignment[0]) + student.getTotalAssignmentScore());
                    }

                    // After set adding the valid max assignment and the valid student score assignment to student then break.
                    break;
                }
            }
        }
    }

    /**
     * Checking the input number is a valid number or not.
     *
     * @param number is a input number need to check.
     *
     * @return true if the number is a valid number, false if the number is
     * invalid.
     */
    public boolean checkValid(String number) {

        // Try to convert the string to integer.
        try {

            // Check if the user do not enter anything then throw an exception.
            if (number.length() == 0) {
                throw new Exception();
            }

            // Convert the parameter to integer.
            validNumber = Integer.parseInt(number);

            // If it can convert to integer then return true.
            return true;

            // If the convert to integer cause error then notify it to user.
        } catch (Exception e) {
            System.out.println("Please only enter valid number.");
            return false;
        }

    }

}
