/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191371_v04;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * V04 - Doctor manage program.
 *
 * The class that run the program.
 *
 * @author Vu Minh Khang - CE191371 - 18/1/25
 */
public class DoctorHash {

    // Create all field and set it to private.
    // The Scanner is using for getting input from the user.
    // The Object checker is using for checking error from input.    
    // The field run is using to running the program until the user stop.
    // The field choice is the choice from user.
    // The HashMap doctorList is the list of all doctor.
    // The field id is the id of the doctor.
    // The field name is the name of the doctor.
    // The field specializaition is the specialization of the doctor.
    // The field loop is using for run the program until the user exit.
    // The Doctor doctor is using to storage the value of a doctor.
    // The field search is the information that user want to search from the doctor.
    // The HashMap searchDoctorList is using for storage all the doctor suit with the search.
    private Scanner input = new Scanner(System.in);
    private IOChecking checker = new IOChecking();
    private String choice;
    private HashMap<String, Doctor> doctorList = new HashMap();
    private String id;
    private String name;
    private String specialization;
    private String availability;
    private boolean loop;
    private Doctor doctor;
    private String search;
    private HashMap<String, Doctor> searchDoctorList = new HashMap();

    /**
     * Start the program.
     */
    public void program() {

        // Set the loop to true.
        loop = true;

        // Run the program until the user enter option 5 (exit the program.
        while (loop) {

            // Print out the menu.
            menu();

            // Get the valid choice from user.
            while (true) {
                System.out.print("Your choice: ");
                choice = input.nextLine().trim();

                // If the valid choice then break the loop.
                if (!checker.checkValid(choice)) {
                    break;
                }
            }

            // Check the choice from user and run it (option 1 to 5).
            switch (Integer.parseInt(choice)) {

                // If the user choose option 1.
                case 1:

                    // Input new doctor.
                    add();

                    // If the input doctor is valid then add it to the list.
                    if (addDoctor(doctor = new Doctor(id, name, specialization, availability))) {
                        System.out.println("Add new doctor successfully.");
                        doctorList.put(id, doctor);
                    }
                    break;

                // If the user choose option 2.
                case 2:

                    // Input new information of a doctor with an id of a doctor.
                    update();

                    // If the list is empty then return.
                    if (doctorList.isEmpty()) {
                        break;
                    }

                    // If the input doctor is valid then change the information of that doctor to new information.
                    if (updateDoctor(doctor = new Doctor(id, name, specialization, availability))) {
                        System.out.println("Change new data successfully.");
                        doctorList.replace(id, doctor);
                    }
                    break;

                // If the user choose option 3.
                case 3:

                    // Delete a doctor in the list using the doctor code.
                    delete();

                    // If the list is empty then return.
                    if (doctorList.isEmpty()) {
                        break;
                    }

                    // If the input code of doctor is valid then delete that doctor from the list.
                    if (deleteDoctor(doctor = new Doctor(id, name, specialization, availability)) && !doctorList.isEmpty()) {
                        System.out.println("Remove doctor successfully.");
                        doctorList.remove(id);
                    }
                    break;

                // If the user choose option 4.
                case 4:

                    // Search a doctor in the list.
                    // Get the information that need to search.
                    search();

                    // If the list is empty then return.
                    if (doctorList.isEmpty()) {
                        break;
                    }

                    // Get all the doctor that suit with it.
                    searchDoctor(search);

                    // Print all the doctor.
                    printData();

                    break;

                // If the user choose option 5.
                case 5:

                    // Exit the program.
                    loop = false;
                    break;
                // If the user enter a invalid choice.
                default:

                    // Notify to the user.
                    System.out.println("Not a valid choice.");
                    break;

            }
        }
    }

    /**
     * Method to print the menu.
     */
    public void menu() {
        System.out.println("========= Doctor Management =========");
        System.out.println("          1. Add Doctor");
        System.out.println("          2. Update Doctor");
        System.out.println("          3. Delete Doctor");
        System.out.println("          4. Search Doctor");
        System.out.println("          5. Exit");
    }

    /**
     * Add new doctor to the list.
     */
    public void add() {
        System.out.println("--------- Add Doctor ---------");

        // Get the id(code) of the doctor from user.
        System.out.print("Enter Code: ");
        id = input.nextLine().trim().toUpperCase();

        // Get the name of the doctor from user.
        System.out.print("Enter Name: ");
        name = input.nextLine().trim();

        // Get the specialization of the doctor from user.
        System.out.print("Enter Specialization: ");
        specialization = input.nextLine().trim();

        // Get the availability of the doctor from user.
        System.out.print("Enter Availability: ");
        availability = input.nextLine().trim();

    }

    /**
     * Method to check the doctor is valid or not.
     *
     * @param doctor is the new doctor that need to check.
     *
     * @return true if the doctor is valid. False if not.
     */
    public boolean addDoctor(Doctor doctor) {

        try {

            // If all the information of the doctor is null.
            if (checker.checkNullValue(id) && checker.checkNullValue(name) && checker.checkNullValue(specialization) && checker.checkNullValue(availability)) {
                throw new Exception("Please fill out all the information.");
            }

            // If one of the information of the doctor is null.
            if (checker.checkNullValue(id) || checker.checkNullValue(name) || checker.checkNullValue(specialization) || checker.checkNullValue(availability)) {

                // Check if the id of the doctor is null or not.
                if (checker.checkNullValue(id)) {
                    System.out.println("Id cant be null.");
                }

                // Check if the name of the doctor is null or not.
                if (checker.checkNullValue(name)) {
                    System.out.println("Name cant be null.");
                }

                // Check if the sepcialization of the doctor is null or not.
                if (checker.checkNullValue(specialization)) {
                    System.out.println("Specialization cant be null");
                }

                // Check if the availability of the doctor is null or not.
                if (checker.checkNullValue(availability)) {
                    System.out.println("Availability cant be null");
                }

                // Throw an exception.
                throw new Exception("");
            }

            // Check if the id of the doctor is valid or not.
            if (!doctor.getId().matches("^(DOC|doc).+")) {

                // If the doctor id is not valid then throw an exception with a message.
                throw new Exception("The code of the doctor must begin with DOC*");
            }

            // Check if the doctor is existed in the list or not.
            if (doctorList.containsKey(id)) {

                // If it existed then throw an exception with a message.
                throw new Exception("Doctor code " + doctor.getId() + " is duplicate.");
            }
            
            // Check if the name is not valid.
            if (checker.checkName(name, "Please enter an valid name.")) {
                throw new Exception("");
            }

            // Check if the availability of the doctor is contain any character .
            if (checker.checkContainCharacterAndSymbol(availability)) {
                throw new Exception("The availability can not contains special character.");
            }

            // Check if the availability of the doctor is negative.
            if (checker.checkOutOfRange(availability, 0, 999999999)) {
                throw new Exception("The availability can not be negative.");
            }

            // If the doctor is valid then return true.
            return true;
        } catch (Exception e) {

            // If the doctor is not valid then notify to the user and return false.
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Method to update information of a doctor already in the list.
     */
    public void update() {

        // Check if the doctor list is empty or not.
        if (doctorList.isEmpty()) {

            // If it empty then notify it to the user.
            System.out.println("Database does not exist.");
            return;
        }

        System.out.println("--------- Update Doctor ---------");

        // Get the id(code) of the doctor from user.
        System.out.print("Enter Code: ");
        id = input.nextLine().trim().toUpperCase();

        // Get the name of the doctor from user.
        System.out.print("Enter Name: ");
        name = input.nextLine().trim();

        // Get the specialization of the doctor from user.
        System.out.print("Enter Specialization: ");
        specialization = input.nextLine().trim();

        // Get the availability of the doctor from user.
        System.out.print("Enter Availability: ");
        availability = input.nextLine().trim();

    }

    /**
     * Method to check the new update information of the doctor is valid or not.
     *
     * @param doctor is the doctor with new information.
     *
     * @return true if the new update information is valid. False if not.
     */
    public boolean updateDoctor(Doctor doctor) {
        
        try {
            
            // Check if there are any information of the doctor is null or not.
            if (checker.checkNullValue(id) || checker.checkNullValue(name) || checker.checkNullValue(specialization) || checker.checkNullValue(availability)) {

                // If yes then throw an exception with a message.
                throw new Exception("Any data can not null.");
            }

            // Check if the id of the doctor is valid or not.
            if (!doctor.getId().matches("^DOC.$")) {

                // If the doctor id is not valid then throw an exception with a message.
                throw new Exception("The code of the doctor must begin with DOC*");
            }

            // Check if the id of the doctor.
            if (!doctorList.containsKey(id)) {
                throw new Exception("Doctor code doesn’t exist.");
            }
            
            // Check if the name is not valid.
            if (checker.checkName(name, "Please enter an valid name.")) {
                throw new Exception("");
            }

            // Check if the availability of the doctor is contain any character .
            if (checker.checkContainCharacterAndSymbol(availability)) {
                throw new Exception("The availability can not contains special character.");
            }

            // Check if the availability of the doctor is negative.
            if (checker.checkOutOfRange(availability, 0, 999999999)) {
                throw new Exception("The availability can not be negative.");
            }

            // Return true if the doctor information is valid.
            return true;
        } catch (Exception e) {

            // If the doctor information is not valid then notify it to user and return false.
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Method to get the id of doctor that need to delete.
     */
    public void delete() {

        // Check if the doctor list is empty or not.
        if (doctorList.isEmpty()) {

            // If it empty then notify it to the user.
            System.out.println("Database does not exist.");
            return;
        }

        System.out.println("--------- Delete Doctor ---------");

        // Get the id(code) of the doctor from user.
        System.out.print("Enter Code: ");
        id = input.nextLine().trim().toUpperCase();
    }

    /**
     * Method to delete a doctor in the list.
     *
     * @param doctor is the doctor that need to delete.
     *
     * @return true if the information of that doctor is valid and can be
     * delete. False if not.
     */
    public boolean deleteDoctor(Doctor doctor) {

        try {

            // Check if the id of the doctor is valid or not.
            if (!doctor.getId().matches("^DOC.$")) {

                // If the doctor id is not valid then throw an exception with a message.
                throw new Exception("The code of the doctor must begin with DOC*");
            }

            // Check if the id of the doctor exisited in the list or not.
            if (!doctorList.containsKey(id)) {

                // If no then throw an exception with a message.
                throw new Exception("Doctor code doesn’t exist.");
            }

            // If the doctor can be delete then return true.
            return true;
        } catch (Exception e) {

            // If the doctor cant be delete then notify it to user and return false.
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Method to get information to search for a doctor in the list.
     */
    public void search() {

        // Check if the doctor list is empty or not.
        if (doctorList.isEmpty()) {

            // If it empty then notify it to the user.
            System.out.println("Database does not exist.");
            return;
        }

        System.out.println("--------- Search Doctor ---------");

        // Get the valid information of the doctor that need to search.
        while (true) {
            // Get the information of all doctor that need to find.
            System.out.print("Enter text: ");
            search = input.nextLine().trim();

            // If the input is null then ask the user to re-enter.
            // If not then break the loop.
            if (!checker.checkNullValue(search)) {
                break;
            }

            System.out.println("Please enter something.");
        }

    }

    /**
     * Method to get all the doctor that suit with the search from user.
     *
     * @param search is information of the doctor.
     *
     * @return the list that contain all the doctor suit with the search of
     * user.
     */
    public HashMap<String, Doctor> searchDoctor(String search) {

        // Clear all the doctor in the return list.
        searchDoctorList.clear();

        // Get each doctor from the doctor list.
        for (Doctor obj : doctorList.values()) {

            // Check if there any information of the doctor suit with the search (ignore the case).
            if ((String.valueOf(obj.getAvailability())).toLowerCase().contains(search.toLowerCase()) || obj.getName().toLowerCase().contains(search.toLowerCase()) || obj.getSpecialization().toLowerCase().contains(search.toLowerCase()) || obj.getId().toLowerCase().contains(search.toLowerCase())) {

                // Add all the doctor suit with the search to the return list.
                searchDoctorList.put(obj.getId(), obj);
            }
        }

        // Return all the doctor suit with the search.
        return searchDoctorList;

    }

    /**
     * Method to print out all the doctor in the list.
     */
    public void printData() {

        // Check if the doctor list is empty or not.
        if (searchDoctorList.isEmpty()) {

            // If empty then notify to user.
            System.out.println("There are no current doctor that suit for your search.");
            return;
        }

        System.out.println("--------- Result ---------");
        System.out.println("Code      Name                 Specialization           Availability");

        // Get each doctor from the list.
        for (Map.Entry<String, Doctor> doc : searchDoctorList.entrySet()) {

            // Get the value of the doctor.
            Doctor curr = doc.getValue();
            
            if (curr.getName().length() >= 21) {
                name = curr.getName().substring(0, 18) + "...";
            }

            // Print out the information of the doctor.
            System.out.printf("%-10s%-21s%-25s%-12s\n", curr.getId(), name, curr.getSpecialization(), curr.getAvailability());
        }
    }
}
