/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191371_l01;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Vu Minh Khang - CE191371 <your.name at your.org>
 */
class Program {

    private Scanner input = new Scanner(System.in);
    private String check;
    private IOChecking checker = new IOChecking();
    private String loop;
    private int choice;
    private ArrayList<Candidates> candidatesList = new ArrayList<>();
    private ArrayList<String> candidateIdList = new ArrayList<>();
    private String candidateId;
    private String firstName;
    private String lastName;
    private int birthDate;
    private String address;
    private int phone;
    private String email;
    private int expInYear;
    private String proSkill;
    private int graduateDate;
    private String graduationRank;
    private String education;
    private String major;
    private int semester;
    private String universityName;

    public void run() {

        do {

            while (true) {
                System.out.println("\tCANDIDATE MANAGEMENT SYSTEM");
                System.out.println("1. Experience\n"
                        + "2. Fresher\n"
                        + "3. Internship\n"
                        + "4. Searching\n"
                        + "5. Exit");
                System.out.print("Please choose: ");
                check = input.nextLine().trim();

                if (checker.checkNullValue(check, "Please enter something.")) {

                } else if (checker.checkContainCharacterAndSymbol(check)) {
                    System.out.println("Please only valid choice.");
                } else if (checker.checkOutOfRange(check, 1, 5)) {
                    System.out.println("Please only choice from 1 to 5.");
                } else {
                    choice = Integer.parseInt(check);
                    break;
                }
            }

            switch (choice) {

                case 1:
                    addExperience();
                    newOrder();
                    break;

                case 2:
                    addFresher();
                    newOrder();
                    break;

                case 3:
                    addInternship();
                    newOrder();
                    break;

                case 4:
                    search();
                    newOrder();
                    break;

                case 5:
                    System.out.println("THANK FOR USING OUR PROGRAM.");
                    loop = "N";
                    break;

            }

        } while (loop.equals("Y"));
    }

    public void newOrder() {

        while (true) {
            System.out.println("Do you want to order now (Y/N)?: ");
            loop = input.nextLine().trim().toUpperCase();

            if (loop.equals("Y") || loop.equals("N")) {
                break;
            }

            System.out.println("Please only enter Y or N.");
        }
    }

    public void addExperience() {

        while (true) {
            addCandidateInfo();

            if (!checkContainId()) {
                Candidates newCandidate = new Candidates(candidateId, firstName, lastName, birthDate, address, phone, email, 0);
                candidatesList.add(new Experience(newCandidate, expInYear, proSkill));
                break;
            }
        }

    }

    public void addFresher() {

        while (true) {
            addCandidateInfo();

            if (!checkContainId()) {
                Candidates newCandidate = new Candidates(candidateId, firstName, lastName, birthDate, address, phone, email, 0);
                candidatesList.add(new Fresher(newCandidate, graduateDate, graduationRank, education));
                break;
            }
        }
    }

    public void addInternship() {

        while (true) {
            addCandidateInfo();

            if (!checkContainId()) {
                Candidates newCandidate = new Candidates(candidateId, firstName, lastName, birthDate, address, phone, email, 0);
                candidatesList.add(new Internship(newCandidate, major, semester, universityName));
                break;
            }
        }
    }

    public void search() {

    }

    public void addCandidateInfo() {

        while (true) {
            System.out.print("Enter candidate ID: ");
            check = input.nextLine().trim().toUpperCase();

            if (checker.checkNullValue(check, "Please enter something.")) {

            } else if (check.contains(" ")) {
                System.out.println("Please only enter valid id.");

            } else if (checker.checkSpecialCharacter(check, "Please only enter valid id.")) {

            } else {
                candidateId = check;
                break;
            }
        }

        while (true) {
            System.out.print("Enter candidate name: ");
            check = input.nextLine().trim().toUpperCase();

            if (checker.checkNullValue(check, "Please enter something.")) {

            } else if (checker.checkSpecialCharacter(check, "Please only enter valid id.")) {

            } else {

                String name[] = new String[2];
                name = check.split(" ");
                firstName = name[0];
                lastName = name[1];
                break;
            }
        }

        while (true) {
            System.out.print("Enter candidate birthdate (1900 - now): ");
            check = input.nextLine().trim();

            if (checker.checkNullValue(check, "Please enter something.")) {

            } else if (checker.checkContainCharacterAndSymbol(check)) {
                System.out.println("Please only enter valid number.");
            } else if (checker.checkOutOfRange(check, 1900, 2025)) {
                System.out.println("Please only enter number from 1900 to now.");
            } else {
                birthDate = Integer.parseInt(check);
                break;
            }
        }

        while (true) {
            System.out.print("Enter candidate address: ");
            check = input.nextLine().trim();

            if (checker.checkNullValue(check, "Please enter something.")) {

            } else if (checker.checkValidAddress(check, "Please enter valid address.")) {

            } else {
                address = check;
                break;
            }
        }

        while (true) {
            System.out.print("Enter candidate phone: ");
            check = input.nextLine().trim();

            if (checker.checkNullValue(check, "Please enter something.")) {

            } else if (checker.checkContainCharacterAndSymbol(check)) {
                System.out.println("Please only enter valid number.");
            } else if (check.length() != 10) {
                System.out.println("Pleas enter exactly 10 digit number.");
            } else {
                phone = Integer.parseInt(check);
                break;
            }
        }

        while (true) {
            System.out.print("Enter candidate email: ");
            check = input.nextLine().trim();

            if (checker.checkNullValue(check, "Please enter something.")) {

            } else if (checker.checkValidEmail(check, "Please enter valid email.")) {

            } else {
                email = check;
                break;
            }
        }

    }

    public boolean checkContainId() {

        if (candidateIdList.isEmpty()) {
            return false;
        }

        for (int i = 0; i < candidatesList.size(); i++) {

            Candidates currentCandidate = candidatesList.get(i);

            if (currentCandidate.getCandidateId().equals(candidateId)) {
                return true;
            }
        }

        return false;
    }
}
