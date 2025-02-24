/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191371_l02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * L02 - Create a Java console program to manage students.
 *
 * The class that run the program.
 *
 * @author Vu Minh Khang - CE191371 - 16/2/25
 */
public class Program {

    // Create all field and set it to private.
    // The Scanner is using for getting input from the user.
    // The field check is the input from user.
    // The HashMap studentList is using for storage all the student.
    // The Object checker is using for checking error from input. 
    // The field semster is the name semester.
    // The field id is the id of student.
    // The field name is the name of the student.
    // The field course is the course of the student.
    // The Object semesterTemp is using for storage semester data.
    // The Object studentTemp is using for storage student data.
    // The ArrayList courseList is the list storage all the course of the student.
    // The ArrayList semesterList is the list storage all the semester of the student.
    // The field pos is using for get the posistion of a object.
    private Scanner input = new Scanner(System.in);
    private String check;
    private HashMap<String, ArrayList<Semester>> studentList = new HashMap<>();
    private IOChecking checker = new IOChecking();
    private String semester;
    private String id;
    private String name;
    private String course;
    private Semester semesterTemp;
    private Student studentTemp;
    private ArrayList<String> courseList;
    private ArrayList<Semester> semesterList;
    private int pos;

    /**
     * Method to run the program.
     */
    public void run() {

        // Run the loop to run the program until user exit (option 5).
        while (true) {

            // Print out the menu.
            menu();

            // Run the loop to get valid choice from user.
            while (true) {

                // Get input from user.
                System.out.print("\tPlease choose: ");
                check = input.nextLine().trim();

                // Check if the user enter null.
                if (checker.checkNullValue(check, "Please enter something.")) {

                    // Check if user enter special character.
                } else if (checker.checkContainCharacterAndSymbol(check, "Please dont enter special character.")) {

                    // Check if the user enter not a valid choice (1-5).
                } else if (checker.checkOutOfRange(check, 1, 5, "Not a valid option.")) {

                    // If user enter valid choice then break the loop.
                } else {
                    break;
                }
            }

            // Run the choice user want.
            switch (check) {

                // If user choose option 1.
                case "1":

                    // Create new student.
                    create();
                    break;

                // If user choose option 2.
                case "2":

                    // Find the student by name and sort the list by name length.
                    find();
                    break;

                // If user choose option 3.
                case "3":

                    // Update new student data and delete student.
                    updateAndDelete();
                    break;

                // If user choose option 4.
                case "4":

                    // Print out all the student information.
                    report();
                    break;

                // If user choose option 5.
                case "5":
                    System.out.println("Thanks for using our application.");
                    return;

                // If user choose not a valid option.
                default:

            }

        }
    }

    /**
     * Method to print out the menu.
     */
    public void menu() {
        System.out.println("\tWELCOME TO STUDENT MANAGEMENT");
        System.out.println("1. Create");
        System.out.println("2. Find");
        System.out.println("3. Update/Delete");
        System.out.println("4. Report");
        System.out.println("5. Exit");
    }

    /**
     * Method to add new student to the list.
     */
    public void create() {

        do {

            // Add new student.
            add();

            while (true) {

                // Get choice from user.
                System.out.print("Do you want to order now (Y/N)? ");
                check = input.nextLine().trim().toUpperCase();

                if (checker.checkNullValue(check, "Please enter your choice (Y/N).")) {

                    // Check if user input not Y or N.
                } else if (!check.equals("Y") && !check.equals("N")) {
                    System.out.println("Please only enter Y or N.");

                    // If user enter Y or N.
                } else {
                    break;
                }
            }

            // If user enter Y then continue.
        } while (check.equals("Y"));

    }

    /**
     * Method to find student by name.
     */
    public void find() {

        // Check if there are any student in the list.
        if (studentList.isEmpty()) {

            // If not then return to the menu.
            System.out.println("There are no student in the list currently.");
            return;
        }

        getName();

        // Get the list that contain all the student match with the name input.
        HashMap<String, ArrayList<Semester>> nameList = findByName(name);

        // Check if the list is empty.
        if (nameList.isEmpty()) {
            System.out.println("There are no student match with your search.");

            // If the list is not empty then printout it.
        } else {
            printListName(nameList);
        }
    }

    /**
     * Method to print the list by the name of the student.
     *
     * @param nameList is the list contain all student match with the input name
     * from user.
     */
    public void printListName(HashMap<String, ArrayList<Semester>> nameList) {

        System.out.println("+-----+--------+----------+-----------------------+--------------+");
        System.out.println("| No. | ID     | Semester | Student name          | Course       |");
        System.out.println("+-----+--------+----------+-----------------------+--------------+");

        // Start from position 1.
        int count = 1;

        // Get each student from the list.
        for (Map.Entry<String, ArrayList<Semester>> studentData : nameList.entrySet()) {

            // Get each semester from each student.
            for (int i = 0; i < studentData.getValue().size(); i++) {

                // Get each course from each semester.
                for (String courseName : studentData.getValue().get(i).getStudent().getCourseInSemester()) {

                    // Get each course of that student from the list.
                    id = studentData.getKey();
                    semester = studentData.getValue().get(i).getSemesterName();
                    name = studentData.getValue().get(i).getStudent().getName();

                    // If the length of the name of the student is bigger than 23 then set the name of the student to 20 to fit the table.
                    if (name.length() >= 23) {
                        name = studentData.getValue().get(i).getStudent().getName().substring(0, 19) + "...";
                    }
                    course = courseName;

                    // Print out all the information in format.
                    System.out.printf("| %3d |%-8s| %-9s| %-22s| %-12s |\n", count, id, semester, name, course);
                    count++;
                }

            }

        }

        System.out.println("+-----+--------+----------+-----------------------+--------------+");
    }

    /**
     * Method to update and delete.
     */
    public void updateAndDelete() {

        // Check if there are any student in the list.
        if (studentList.isEmpty()) {

            // If not then return to the menu.
            System.out.println("There are no student in the list currently.");
            return;
        }

        // Get the student with the id match with the input from user.
        findById();

        while (true) {

            // Get choice from user.
            System.out.print("(Do you want to update (U) or delete (D) student? ");
            check = input.nextLine().trim().toUpperCase();

            // Check if it null.
            if (check.length() == 0) {
                System.out.println("Please enter something.");

                // If user dont enter U or D then ask user to re-enter.
            } else if (!check.equals("U") && !check.equalsIgnoreCase("D")) {
                System.out.println("Please only enter U or D.");

                // If user enter U or D then break the loop.
            } else {
                break;
            }
        }

        // Run the choice from user.
        switch (check) {

            // If user enter U.
            case "U":

                // Update new information to student.
                update();
                break;

            // If user enter D.
            case "D":

                // Delete student.
                delete();
                break;
        }

    }

    /**
     * Method to print out all the student.
     */
    public void report() {

        // Check if there are any student in the list.
        if (studentList.isEmpty()) {

            // If not then return to the menu.
            System.out.println("There are no student in the list currently.");
            return;
        }

        // Print the student data.
        print();
    }

    /**
     * Method to add new student to the list.
     */
    public void add() {

        // Get id from user.
        getId();

        // Check if the id is existing in the list or not.
        if (studentList.containsKey(id)) {
            System.out.println("Student: " + id + " existed in the database.");
            System.out.println("Starting to insert more information about the student.");
        } else {
            System.out.println("Student: " + id + " did not exist in the database.");
            System.out.println("Starting to insert new data.\n");
        }

        // Check if the id is existing or not.
        // If yes then do not need to re-enter the name.
        // If no then ask user to enter the name student.
        if (!studentList.containsKey(id)) {

            // Get student name from user.
            getName();
        }
        System.out.println("");

        // Get semester from user.
        getSemester();
        System.out.println("");

        // Get course from user.
        getCourse();
        System.out.println("");

        // Adding all information to the student list.
        addStudentInfomation();
    }

    /**
     * Method to add all information to the student list.
     */
    public void addStudentInfomation() {

        // If the id is not exist then add new student with a new id to the list.
        if (!studentList.containsKey(id)) {

            // Add the course to a new courseList.
            courseList = new ArrayList<>();
            courseList.add(course);

            // Add the courseList to new student.
            studentTemp = new Student(id, name, courseList);

            // Add the student to new semester.
            semesterTemp = new Semester(semester, studentTemp);

            // Add the new semester to a new semesterList.
            semesterList = new ArrayList<>();
            semesterList.add(semesterTemp);

            // Add the semesterList to the studentList with a id is the key.
            studentList.put(id, semesterList);
            System.out.println("Adding new student successfully.\n");

            // If the id is exist then add more informtaion about that student with id to the list.
        } else {

            // Get the semesterList from the studentList with id.
            semesterList = studentList.get(id);

            // If the semester is not exist in the student data.
            if (!checkSemesterExist(semesterList, semester)) {

                // Add the course to a new courseList.
                courseList = new ArrayList<>();
                courseList.add(course);
                
                // Get the student name.
                name = semesterList.get(0).getStudent().getName();

                // Add the courseList to new student.
                studentTemp = new Student(id, name, courseList);

                // Add the student to new semester.
                semesterTemp = new Semester(semester, studentTemp);

                // Add the new semester to the semesterList.
                semesterList.add(semesterTemp);

                // Update the semesterList with the new semesterList that have add the new semester.
                studentList.replace(id, semesterList);
                System.out.println("Adding new semester successfully for student with id: " + id + ".\n");

                // If the semester is exist in the student data.
            } else {

                // Intilize the position to 0.
                pos = 0;

                // Run from the first semester to the last semester in the semesterList.
                for (int i = 0; i < semesterList.size(); i++) {

                    // Get each semester from the list.
                    semesterTemp = semesterList.get(i);

                    // Update the position.
                    pos++;

                    // If the semester name in the list match with the semester name from user then break the loop.
                    if (semesterTemp.getSemesterName().equals(semester)) {
                        break;
                    }
                }

                // Get the courseList from semester match with the input from user.
                courseList = semesterTemp.getStudent().getCourseInSemester();

                // If the courseList contain empty then remove it.
                if (courseList.get(0).equals("empty")) {
                    courseList.remove(0);
                }

                // Adding new course to the courseList.
                courseList.add(course);
                
                // Get the student name.
                name = semesterList.get(0).getStudent().getName();

                // Update the student information.
                studentTemp = new Student(id, name, courseList);

                // Update the semester informtaion.
                semesterTemp = new Semester(semester, studentTemp);

                // Remove the semester with the position.
                semesterList.remove(pos - 1);

                // Adding the semester with new information.
                semesterList.add(semesterTemp);

                // Update the semesterList with the semesterList that have update new informtaion.
                studentList.replace(id, semesterList);
                System.out.println("Adding new course successfully in the semester: " + semester + " for student with id: " + id + ".\n");

            }

        }

    }

    /**
     * Method to check the semester that exists in the list or not.
     *
     * @param semesterList is the list that contains all the semester.
     * @param semester is the semester need to check.
     *
     * @return true if the semester is exist in the list. False if not.
     */
    public boolean checkSemesterExist(ArrayList<Semester> semesterList, String semester) {

        // Run from the first semester to the last semester in the list.
        for (int i = 0; i < semesterList.size(); i++) {

            // Get each semester from the list.
            semesterTemp = semesterList.get(i);

            // Check if the name of the semester is match or not.
            if (semesterTemp.getSemesterName().equals(semester)) {

                // If yes then return true.
                return true;
            }
        }

        // If in the list there are no semester match then return false.
        return false;
    }

    /**
     * Method to add new course to the list course.
     *
     * @param courses is the list course.
     * @param course is the course need to check.
     *
     * @return the list contain all the course.
     */
    public HashMap<String, Integer> countCourse(HashMap<String, Integer> courses, String course) {

        // If the name of the course is empty then add it to the courseList and set value it to 0.
        if (courses.containsKey("empty")) {
            courses.clear();
            courses.put(course, 0);
            return courses;
        }
        
        // Check if the course is already in the list or not.
        if (courses.containsKey(course)) {

            // If yes then add the number of it to 1.
            courses.replace(course, (courses.get(course) + 1));

            // If not then set the number of it to 1.
        } else {
            courses.put(course, 1);
        }

        // Return thr list with all course.
        return courses;
    }

    /**
     * Method to find the student with the name in the list.
     *
     * @param name is the name of student need to find.
     *
     * @return the list contain all the student match with the game need to
     * find.
     */
    public HashMap<String, ArrayList<Semester>> findByName(String name) {

        HashMap<String, ArrayList<Semester>> nameList = new HashMap<>();

        // Get each student from the list.
        for (Map.Entry<String, ArrayList<Semester>> list : studentList.entrySet()) {

            semesterList = list.getValue();

            for (Semester semester1 : semesterList) {

                // Check if the student is match with the name need to find or not.
                if (semester1.getStudent().getName().toLowerCase().contains(name.toLowerCase())) {

                    // If yes then add it to the temp list.
                    nameList.put(list.getKey(), list.getValue());
                }
            }

        }

        // Return the name list.
        return nameList;

    }

    /**
     * Method to search student by id.
     */
    public void findById() {

        while (true) {
            getId();

            if (studentList.containsKey(id)) {
                break;
            }

            System.out.println("The id is not exist in the database.");
        }

        ArrayList<Semester> semesterList = studentList.get(id);

        System.out.println("+-----+--------+----------+-----------------------+--------------+");
        System.out.println("| No. | ID     | Semester | Student name          | Course       |");
        System.out.println("+-----+--------+----------+-----------------------+--------------+");

        int count = 1;

        // Get each student from the list.
        for (int i = 0; i < semesterList.size(); i++) {

            for (String courseName : semesterList.get(i).getStudent().getCourseInSemester()) {

                // Get each course of that student from the list.
                semester = semesterList.get(i).getSemesterName();
                name = semesterList.get(i).getStudent().getName();
                if (name.length() >= 23) {
                    name = semesterList.get(i).getStudent().getName().substring(0, 19) + "...";
                }
                course = courseName;

                // Print out all the information.
                System.out.printf("| %3d |%-8s| %-9s| %-22s| %-12s |\n", count, id, semester, name, course);
                count++;
            }

        }

        System.out.println("+-----+--------+----------+-----------------------+--------------+");

    }

    /**
     * Method to print out the student with a input list.
     */
    public void print() {

        System.out.println("+-----+--------+-----------------------+--------------+-----------------+");
        System.out.println("| No. | ID     | Student name          | Course       | Total of course |");
        System.out.println("+-----+--------+-----------------------+--------------+-----------------+");

        int count = 1;
        HashMap<String, Integer> temp = new HashMap<>();

        // Get each student from the list.d
        for (Map.Entry<String, ArrayList<Semester>> semesterData : studentList.entrySet()) {
            temp.clear();

            for (int i = 0; i < semesterData.getValue().size(); i++) {

                for (String courseName : semesterData.getValue().get(i).getStudent().getCourseInSemester()) {

                    // Get each course of that student from the list.
                    id = semesterData.getKey();
                    name = semesterData.getValue().get(i).getStudent().getName();
                    if (name.length() >= 23) {
                        name = semesterData.getValue().get(i).getStudent().getName().substring(0, 20) + "...";
                    }

                    course = courseName;

                    temp = countCourse(temp, course);
                }
            }

            for (Map.Entry<String, Integer> list : temp.entrySet()) {

                // Print out all the information.
                System.out.printf("| %3d |%-8s| %-22s| %-12s | %-16s|\n", count, id, name, list.getKey(), list.getValue());
                count++;

            }
        }

        System.out.println("+-----+--------+-----------------------+--------------+-----------------+");

    }

    /**
     * Method to update student information.
     */
    public void update() {

        while (true) {

            // Get choice from user.
            System.out.print("Enter the information you want to update (S-semester N-name C-course): ");
            check = input.nextLine().trim().toUpperCase();

            // Check if it null.
            if (checker.checkNullValue(check, "Please enter something.")) {

                // Check if user dont enter valid choice.
            } else if (!check.equals("S") && !check.equals("N") && !check.equals("C")) {
                System.out.println("Please only enter valid choice (S-semester N-name C-course).");

                // If user enter valid choice then break the loop.
            } else {
                break;
            }
        }

        // Run the choice user want.
        switch (check) {

            // If user enter choice S.
            case "S":

                updateSemester();
                System.out.println("Update new semester information successfully.");
                break;

            // If user enter choice N.
            case "N":

                updateNameStudent();
                System.out.println("Update new student name successfully.");
                break;

            // If user enter choice C.
            case "C":

                updateCourse();
                System.out.println("Update new course information successfully.");
                break;
        }
    }

    public String getValidNewCourse(Semester semester) {

        while (true) {

            pos = -1;

            // Get the course from user.
            System.out.print("Enter the new course you want to change to: ");
            check = input.nextLine().trim().toLowerCase();

            // Check if it null.
            if (checker.checkNullValue(check, "Please enter something.")) {

                // Check if the course is a valid course or not.
            } else if (!check.equals("java") && !check.equals(".net") && !check.equals("c/c++")) {
                System.out.println("Not a valid course (only Java or .Net or C/C++.");

                // If the course is valid then break the loop.
            } else {

                for (String c : semester.getStudent().getCourseInSemester()) {

                    if (c.equals(check)) {
                        pos = 1;
                        break;
                    }
                }

                if (pos != -1) {
                    System.out.println("This course is alreay exist can not change into the exist one. Please enter again.");
                    continue;
                }

                return check;
            }

        }
    }

    public String getValidCourse(Semester semester) {

        while (true) {

            pos = -1;

            // Get the course from user.
            System.out.print("Enter student course you want to change: ");
            check = input.nextLine().trim().toLowerCase();

            // Check if it null.
            if (checker.checkNullValue(check, "Please enter something.")) {

                // Check if the course is a valid course or not.
            } else if (!check.equals("java") && !check.equals(".net") && !check.equals("c/c++")) {
                System.out.println("Not a valid course (only Java or .Net or C/C++");

                // If the course is valid then break the loop.
            } else {

                for (String c : semester.getStudent().getCourseInSemester()) {

                    if (c.equals(check)) {
                        pos = 1;
                        break;
                    }
                }

                if (pos == -1) {
                    System.out.println("This course is not exist in this semester. Please enter again.");
                    continue;
                }

                return check;
            }

        }
    }

    public void updateCourse(Semester course, String oldCourse, String newCourse) {

        semesterList = studentList.get(id);

        for (int i = 0; i < semesterList.size(); i++) {

            if (semesterList.get(i).equals(course)) {
                pos = i;
                studentTemp = semesterList.get(i).getStudent();
                break;
            }
        }

        for (String c : studentTemp.getCourseInSemester()) {

            if (c.equals(oldCourse)) {

                courseList = studentTemp.getCourseInSemester();
                courseList.remove(oldCourse);
                courseList.add(newCourse);
                studentTemp.setCourseInSemester(courseList);
                break;
            }
        }

        semesterList.get(pos).setStudent(studentTemp);
        studentList.replace(id, semesterList);
    }

    public void updateCourse() {

        while (true) {

            pos = -1;

            // Get semester from user.
            System.out.print("Enter student semester you want to change course: ");
            check = input.nextLine().trim().toUpperCase();

            // Check if it null.
            if (checker.checkNullValue(check, "Please enter something.")) {

                // Check if the semester is not valid.
            } else if (checker.checkSemester(check, "Please enter a valid semester (SP##/SU##/FA##).")) {

            } else {

                if (checkFullCourse(check)) {

                    System.out.println("This semester is already full with 3 course so it can not change. Please enter new semester.");

                    // If the user enter valid semester then break the loop.
                } else {
                    semester = check;

                    for (int i = 0; i < studentList.get(id).size(); i++) {

                        semesterTemp = studentList.get(id).get(i);

                        if (semesterTemp.getSemesterName().equals(semester)) {
                            pos = 1;
                            break;
                        }
                    }

                    if (pos == -1) {
                        System.out.println("There are no semester math with your input in the database. Please enter again.");
                        continue;
                    }

                    break;
                }
            }
        }

        updateCourse(semesterTemp, getValidCourse(semesterTemp), getValidNewCourse(semesterTemp));
    }

    public void updateSemester() {

        updateSemester(getValidSemester(), getNewValidSemester());
    }

    public String getValidSemester() {

        while (true) {

            pos = -1;

            // Get semester from user.
            System.out.print("Enter semester that you want to change: ");
            check = input.nextLine().trim().toUpperCase();

            // Check if it null.
            if (checker.checkNullValue(check, "Please enter something.")) {

                // Check if the semester is not valid.
            } else if (checker.checkSemester(check, "Please enter a valid semester (SP##/SU##/FA##).")) {

                // If the user enter valid semester then break the loop.
            } else {

                for (int i = 0; i < studentList.get(id).size(); i++) {

                    Semester semeserTemp = studentList.get(id).get(i);

                    if (semeserTemp.getSemesterName().equals(check)) {
                        pos = i;
                        break;
                    }

                }

                if (pos == -1) {
                    System.out.println("This semester is not exist. Please enter again.");
                    continue;
                }

                return check;
            }

        }
    }

    public String getNewValidSemester() {

        while (true) {

            pos = -1;

            // Get semester from user.
            System.out.print("Enter new semester that you want to change to: ");
            check = input.nextLine().trim().toUpperCase();

            // Check if it null.
            if (checker.checkNullValue(check, "Please enter something.")) {

                // Check if the semester is not valid.
            } else if (checker.checkSemester(check, "Please enter a valid semester (SP##/SU##/FA##).")) {

                // If the user enter valid semester then break the loop.
            } else {

                for (int i = 0; i < studentList.get(id).size(); i++) {

                    Semester semeserTemp = studentList.get(id).get(i);

                    if (semeserTemp.getSemesterName().equals(check)) {
                        pos = i;
                        break;
                    }

                }

                if (pos != -1) {
                    System.out.println("This semester is already exist. Please enter again.");
                    continue;
                }

                return check;
            }

        }
    }

    public void updateSemester(String oldSemester, String newSemester) {

        semesterList = studentList.get(id);

        ArrayList<Semester> newSemesterList = new ArrayList<>();

        for (int i = 0; i < semesterList.size(); i++) {

            if (semesterList.get(i).getSemesterName().equals(oldSemester)) {

                Semester tempSemester = semesterList.get(i);
                tempSemester.setSemesterName(newSemester);
                newSemesterList.add(tempSemester);

            } else {
                Semester tempSemester = semesterList.get(i);
                newSemesterList.add(tempSemester);
            }

        }

        studentList.replace(id, newSemesterList);

    }

    public void updateNameStudent() {
        updateNameStudent(getValidName(), getNewValidName());
    }

    public String getValidName() {

        Semester semeserTemp = studentList.get(id).get(0);

        return semeserTemp.getStudent().getName();

    }

    public String getNewValidName() {

        while (true) {

            pos = -1;

            // Get name from user.
            System.out.print("Enter new student name: ");
            check = input.nextLine().trim();

            // Check if it null.
            if (checker.checkNullValue(check, "Please enter something.")) {

                // Check if the name is not valid.
            } else if (checker.checkName(check, "Please only enter character.")) {

                // If the name is valid then break the loop.
            } else {

                for (int i = 0; i < studentList.get(id).size(); i++) {

                    Semester semeserTemp = studentList.get(id).get(i);

                    if (semeserTemp.getStudent().getName().toLowerCase().equals(check.toLowerCase())) {
                        pos = i;
                        break;
                    }
                }

                if (pos != -1) {
                    System.out.println("This name is the same as the old name. Please enter again.");
                    continue;
                }

                return check;
            }

        }
    }

    public void updateNameStudent(String oldName, String newName) {

        semesterList = studentList.get(id);

        ArrayList<Semester> newSemesterList = new ArrayList<>();

        for (int i = 0; i < semesterList.size(); i++) {

            if (semesterList.get(i).getStudent().getName().equals(oldName)) {

                Student tempStudent = semesterList.get(i).getStudent();
                tempStudent.setName(newName);
                semesterList.get(i).setStudent(tempStudent);
                newSemesterList.add(semesterList.get(i));

            } else {

                Semester tempSemester = semesterList.get(i);
                newSemesterList.add(tempSemester);
            }

        }

        studentList.replace(id, newSemesterList);
    }

    /**
     * Method to delete a student from the list by id.
     */
    public void delete() {

        while (true) {

            // Get choice from user.
            System.out.print("Enter the information you want to delete (ID-student S-Semster C-course): ");
            check = input.nextLine().trim().toUpperCase();

            // Check if it null.
            if (checker.checkNullValue(check, "Please enter something.")) {

                // Check if user dont enter valid choice.
            } else if (!check.equals("ID") && !check.equals("S") && !check.equals("C")) {
                System.out.println("Please only enter valid choice (ID-student S-Semster C-course).");

                // If user enter valid choice then break the loop.
            } else {
                break;
            }
        }

        // Run the choice from user.
        switch (check) {

            // If user choose ID option.
            case "ID":

                // Remove the student by id.
                studentList.remove(id);
                System.out.println("Successfully remove student with Id: " + id + ".\n");
                break;

            // If user choose S option.
            case "S":

                removeSemester();
                break;

            //If user choose C option.
            case "C":

                removeCourse();
                break;
        }
    }

    public void removeCourse() {

        semesterList = studentList.get(id);

        while (true) {

            pos = -1;

            // Get semester from user.
            System.out.print("Enter student semester: ");
            check = input.nextLine().trim().toUpperCase();

            // Check if it null.
            if (checker.checkNullValue(check, "Please enter something.")) {

                // Check if the semester is not valid.
            } else if (checker.checkSemester(check, "Please enter a valid semester (SP##/SU##/FA##).")) {

                // If the user enter valid semester then break the loop.
            } else {

                for (int i = 0; i < semesterList.size(); i++) {

                    if (semesterList.get(i).getSemesterName().equals(check)) {
                        pos = i;
                    }
                }

                if (pos != -1) {
                    semester = check;
                    break;
                }

                System.out.println("This student do not have that semester. Try again.");
            }
        }

        if (semesterList.get(pos).getStudent().getCourseInSemester().size() == 1) {
            System.out.println("This semester only have 1 course. Do you want to delete it or not.");

            while (true) {

                // Get choice from user.
                System.out.print("Enter your choice (Y-yes N-no): ");
                check = input.nextLine().trim().toUpperCase();

                // Check if it null.
                if (checker.checkNullValue(check, "Please enter something.")) {

                    // Check if user dont enter valid choice.
                } else if (!check.equals("Y") && !check.equals("N")) {
                    System.out.println("Please only enter valid choice (Y-yes N-no).");

                    // If user enter valid choice then break the loop.
                } else {

                    semester = semesterList.get(pos).getSemesterName();
                    course = semesterList.get(pos).getStudent().getCourseInSemester().get(0);

                    if (check.equals("Y")) {

                        semesterList.get(pos).getStudent().getCourseInSemester().remove(course);
                        semesterList.get(pos).getStudent().getCourseInSemester().add("empty");
                        studentList.replace(id, semesterList);
                        System.out.println("Successfully remove course: " + course + " from the " + semester + " semester.\n");
                    } else {

                        System.out.println("Failed to remove course: " + course + " from the " + semester + " semester.\n");
                    }
                    break;
                }
            }

        } else {

            while (true) {

                // Get the course from user.
                System.out.print("Enter student course (Java or .Net or C/C++): ");
                check = input.nextLine().trim().toLowerCase();

                // Check if it null.
                if (checker.checkNullValue(check, "Please enter something.")) {

                    // Check if the course is a valid course or not.
                } else if (!check.equals("java") && !check.equals(".net") && !check.equals("c/c++")) {
                    System.out.println("Not a valid course (only Java or .Net or C/C++).");

                    // If the course is valid then break the loop.
                } else {

                    course = check;

                    courseList = studentList.get(id).get(pos).getStudent().getCourseInSemester();

                    if (courseList.contains(check)) {
                        break;
                    }

                    System.out.println("Please enter valid course.");
                }
            }

            while (true) {

                // Get choice from user.
                System.out.print("Enter your choice (Y-yes N-no): ");
                check = input.nextLine().trim().toUpperCase();

                // Check if it null.
                if (checker.checkNullValue(check, "Please enter something.")) {

                    // Check if user dont enter valid choice.
                } else if (!check.equals("Y") && !check.equals("N")) {
                    System.out.println("Please only enter valid choice (Y-yes N-no).");

                    // If user enter valid choice then break the loop.
                } else {

                    semester = semesterList.get(pos).getSemesterName();
                    course = semesterList.get(pos).getStudent().getCourseInSemester().get(0);

                    if (check.equals("Y")) {

                        semesterList.get(pos).getStudent().getCourseInSemester().remove(course);
                        studentList.replace(id, semesterList);
                        System.out.println("Successfully remove course: " + course + " from the " + semester + " semester.\n");
                    } else {

                        System.out.println("Failed to remove course: " + course + " from the " + semester + " semester.\n");
                    }
                    break;
                }
            }
        }

    }

    public void removeSemester() {

        semesterList = studentList.get(id);

        if (semesterList.size() == 1) {
            System.out.println("This student only have 1 semester. Do you want to delete it or not (it will delete the student aswell).");

            while (true) {

                // Get choice from user.
                System.out.print("Enter your choice (Y-yes N-no): ");
                check = input.nextLine().trim().toUpperCase();

                // Check if it null.
                if (checker.checkNullValue(check, "Please enter something.")) {

                    // Check if user dont enter valid choice.
                } else if (!check.equals("Y") && !check.equals("N")) {
                    System.out.println("Please only enter valid choice (Y-yes N-no).");

                    // If user enter valid choice then break the loop.
                } else {

                    semester = semesterList.get(0).getSemesterName();

                    if (check.equals("Y")) {

//                        name = semesterList.get(0).getStudent().getName();
//                        semesterList.remove(0);
//                        courseList = new ArrayList<>();
//                        courseList.add("Empty");
//                        semesterTemp = new Semester("Empty", new Student(id, name, courseList));
//                        semesterList.add(semesterTemp);
//                        semesterList.remove(0);
//                        studentList.replace(id, semesterList);
//                        System.out.println(studentList.size());
                        studentList.remove(id);
                        System.out.println("Successfully remove " + semester + " from student with Id: " + id + ".\n");
                    } else {

                        System.out.println("Failed to remove " + semester + " from student with Id: " + id + ".\n");
                    }
                    break;
                }
            }

            return;
        }

        while (true) {

            pos = -1;

            // Get semester from user.
            System.out.print("Enter student semester: ");
            check = input.nextLine().trim().toUpperCase();

            // Check if it null.
            if (checker.checkNullValue(check, "Please enter something.")) {

                // Check if the semester is not valid.
            } else if (checker.checkSemester(check, "Please enter a valid semester (SP##/SU##/FA##).")) {

                // If the user enter valid semester then break the loop.
            } else {

                for (Semester s : semesterList) {

                    if (s.getSemesterName().equals(check)) {
                        pos = 1;
                    }
                }

                if (pos != -1) {
                    semester = check;
                    break;
                }

                System.out.println("This student do not have that semester. Try again.");
            }
        }

        for (int i = 0; i < semesterList.size(); i++) {

            semesterTemp = semesterList.get(i);

            if (semesterTemp.getSemesterName().equals(semester)) {

                semesterList.remove(semesterTemp);
                break;
            }
        }

        System.out.println("Successfully remove " + semester + " from student with Id: " + id + ".\n");
    }

    public void getId() {

        while (true) {

            // Get id from user.
            System.out.print("Enter student id: ");
            check = input.nextLine().trim().toUpperCase();

            // Check if it null.
            if (checker.checkNullValue(check, "Please enter something.")) {

                // Check if the id is not valid.
            } else if (checker.checkId(check, "Please enter a valid id (SV****).")) {

                // If the user is not in the list then break the loop.
            } else {
                id = check;
                break;
            }
        }
    }

    public void getName() {

        while (true) {

            // Get name from user.
            System.out.print("Enter student name: ");
            check = input.nextLine().trim();

            // Check if it null.
            if (checker.checkNullValue(check, "Please enter something.")) {

                // Check if the name is not valid.
            } else if (checker.checkName(check, "Please only enter character.")) {

                // If the name is valid then break the loop.
            } else {
                name = check;
                break;
            }
        }

    }

    public void getSemester() {

        while (true) {

            // Get semester from user.
            System.out.print("Enter student semester: ");
            check = input.nextLine().trim().toUpperCase();

            // Check if it null.
            if (checker.checkNullValue(check, "Please enter something.")) {

                // Check if the semester is not valid.
            } else if (checker.checkSemester(check, "Please enter a valid semester (SP##/SU##/FA##).")) {

            } else {

                if (checkFullCourse(check)) {

                    System.out.println("This semester already full with 3 course. Please enter new semester.");

                    // If the user enter valid semester then break the loop.
                } else {
                    semester = check;
                    break;
                }
            }
        }
    }

    public boolean checkFullCourse(String semester) {

        pos = -1;

        if (studentList.isEmpty() || !studentList.containsKey(id)) {
            return false;
        }

        semesterList = studentList.get(id);

        for (int i = 0; i < semesterList.size(); i++) {

            semesterTemp = semesterList.get(i);

            if (semesterTemp.getSemesterName().equals(semester)) {
                pos = i;
                break;
            }
        }

        if (pos == -1) {
            return false;
        }

        return semesterTemp.getStudent().getCourseInSemester().size() == 3;
    }

    public void getCourse() {

        checkExistCourse(semester);

        while (true) {

            // Get the course from user.
            System.out.print("Enter student course (Java or .Net or C/C++): ");
            check = input.nextLine().trim().toLowerCase();

            // Check if it null.
            if (checker.checkNullValue(check, "Please enter something.")) {

                // Check if the course is a valid course or not.
            } else if (!check.equals("java") && !check.equals(".net") && !check.equals("c/c++")) {
                System.out.println("Not a valid course (only Java or .Net or C/C++).");

                // If the course is valid then break the loop.
            } else {

                course = check;

                if (studentList.isEmpty() || !studentList.containsKey(id)) {
                    break;
                }

                if (pos == -1) {
                    return;
                }

                courseList = studentList.get(id).get(pos).getStudent().getCourseInSemester();

                if (!courseList.contains(check)) {
                    break;
                }

                System.out.println("Please enter valid course.");
            }
        }
    }

    /**
     * Method to check the exist of the course in a semester.
     *
     * @param semester is the semester that contain the course.
     */
    public void checkExistCourse(String semester) {

        pos = -1;

        // Check if the studentList is empty or studentList is not contains any 
        if (studentList.isEmpty() || !studentList.containsKey(id)) {
            return;
        }

        // Get the semesterList of the student with id input.
        semesterList = studentList.get(id);

        // Run from the first semester to the last semester.
        for (int i = 0; i < semesterList.size(); i++) {

            // Get each semester from the list.
            semesterTemp = semesterList.get(i);

            // Check if the semester is match with the semester or not.
            // If yes then break.
            if (semesterTemp.getSemesterName().equals(semester)) {
                pos = i;
                break;
            }

        }

        // If the semester is not in the semesterList then return.
        if (pos == -1) {
            return;
        }

        // Get courseList from that semester.
        courseList = semesterList.get(pos).getStudent().getCourseInSemester();

        // If the courseList is empty then return.
        if (courseList.isEmpty()) {
            return;
        }

        // If the courseList exist 2 course.
        if (courseList.size() == 2) {

            if (!courseList.contains("java")) {

                System.out.println("This semester only have Java left. Enter Java to continue.");

            } else if (!courseList.contains(".net")) {

                System.out.println("This semester only have .Net left. Enter .Net to continue.");

            } else if (!courseList.contains("c/c++")) {

                System.out.println("This semester only have C/C++ left. Enter C/C++ to continue.");
            }
        } else {

            if (courseList.contains("java")) {

                System.out.println("This semester only have Java. Enter (.Net or C/C++) to continue.");

            } else if (courseList.contains("c/c++")) {

                System.out.println("This semester only have C/C++. Enter (Java or .Net) to continue.");

            } else if (courseList.contains(".net")) {

                System.out.println("This semester only have .Net. Enter (Java or C/C++) to continue.");
            }
        }
    }

}
