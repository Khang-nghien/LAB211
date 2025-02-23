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
    // The field semster is the current semester.
    // The field id is the id of student.
    // The field name is the name of the student.
    // The field course is the course of the student.
    // The HashMap courseList is the list storage all the course of the student.
    // The HashMap tempList is the list to temporary storage for a list. 
    // The Object student is the student to check.
    // The ArrayList studentList is the list contain all the student in that semester.
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
        System.out.println("2. Find and Sort");
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

    public void printListName(HashMap<String, ArrayList<Semester>> nameList) {

        System.out.println("+-----+--------+----------+-----------------------+--------------+");
        System.out.println("| No. | ID     | Semester | Student name          | Course       |");
        System.out.println("+-----+--------+----------+-----------------------+--------------+");

        int count = 1;

        // Get each student from the list.
        for (Map.Entry<String, ArrayList<Semester>> studentData : nameList.entrySet()) {

            for (int i = 0; i < studentData.getValue().size(); i++) {

                for (String courseName : studentData.getValue().get(i).getStudent().getCourseInSemester()) {

                    // Get each course of that student from the list.
                    id = studentData.getKey();
                    semester = studentData.getValue().get(i).getSemesterName();
                    name = studentData.getValue().get(i).getStudent().getName();
                    if (name.length() >= 23) {
                        name = studentData.getValue().get(i).getStudent().getName().substring(0, 19) + "...";
                    }
                    course = courseName;

                    // Print out all the information.
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

        findById();

        while (true) {

            // Get choice from user.
            System.out.print("(Do you want to update (U) or delete (D) student? ");
            check = input.nextLine().trim().toUpperCase();

            if (check.length() == 0) {
                System.out.println("Please enter something.");

                // If user dont enter U or D then continue.
            } else if (!check.equals("U") && !check.equalsIgnoreCase("D")) {
                System.out.println("Please only enter U or D.");

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

        getId();

        if (studentList.containsKey(id)) {
            System.out.println("Student: " + id + " existed in the database");
            System.out.println("Starting to insert information about the student.");
        } else {
            System.out.println("Student: " + id + " did not exist in the database");
            System.out.println("Starting to insert new data.\n");
        }

        if (!studentList.containsKey(id)) {
            getName();
        }
        System.out.println("");

        getSemester();
        System.out.println("");

        getCourse();
        System.out.println("");

        addStudentInfomation();
    }

    public void addStudentInfomation() {

        if (!studentList.containsKey(id)) {

            courseList = new ArrayList<>();
            courseList.add(course);

            studentTemp = new Student(id, name, courseList);

            semesterTemp = new Semester(semester, studentTemp);

            semesterList = new ArrayList<>();
            semesterList.add(semesterTemp);

            studentList.put(id, semesterList);
            System.out.println("Adding new student successfully.\n");

        } else {

            semesterList = studentList.get(id);

            if (!checkSemesterExist(semesterList, semester)) {

                courseList = new ArrayList<>();
                courseList.add(course);

                studentTemp = new Student(id, name, courseList);

                semesterTemp = new Semester(semester, studentTemp);

                semesterList.add(semesterTemp);

                studentList.replace(id, semesterList);
                System.out.println("Adding new semester successfully for student with id: " + id + ".\n");

            } else {

                pos = 0;

                for (int i = 0; i < semesterList.size(); i++) {

                    semesterTemp = semesterList.get(i);
                    pos++;

                    if (semesterTemp.getSemesterName().equals(semester)) {
                        break;
                    }
                }

                courseList = semesterTemp.getStudent().getCourseInSemester();
                courseList.add(course);

                studentTemp = new Student(id, name, courseList);

                semesterTemp = new Semester(semester, studentTemp);

                semesterList.remove(pos - 1);
                semesterList.add(semesterTemp);

                studentList.replace(id, semesterList);
                System.out.println("Adding new course successfully in the semester: " + semester + " for student with id: " + id + ".\n");

            }

        }

    }

    public boolean checkSemesterExist(ArrayList<Semester> semesterList, String semester) {

        for (int i = 0; i < semesterList.size(); i++) {
            semesterTemp = semesterList.get(i);

            if (semesterTemp.getSemesterName().equals(semester)) {
                return true;
            }
        }

        return false;
    }

    public boolean checkContains(ArrayList<String> list, String check) {

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equalsIgnoreCase(check)) {
                return true;
            }
        }

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

        // Check if the course is already in the list or not.
        if (courses.containsKey(course)) {

            // If yes then add the number of it to 1.
            courses.put(course, (courses.get(course) + 1));

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

            for (int i = 0; i < semesterData.getValue().size(); i++) {

                for (String courseName : semesterData.getValue().get(i).getStudent().getCourseInSemester()) {

                    // Get each course of that student from the list.
                    id = semesterData.getKey();
                    name = semesterData.getValue().get(i).getStudent().getName();
                    if (name.length() >= 23) {
                        name = semesterData.getValue().get(i).getStudent().getName().substring(0, 19) + "...";
                    }
                    course = courseName;

                    temp = countCourse(temp, course);

                }
            }

            for (Map.Entry<String, Integer> courseList : temp.entrySet()) {

                // Print out all the information.
                System.out.printf("| %3d |%-8s| %-22s| %-12s | %-16s|\n", count, id, name, courseList.getKey(), courseList.getValue());
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
                break;

            // If user enter choice N.
            case "N":

                updateNameStudent();
                break;

            // If user enter choice C.
            case "C":

                updateCourse();
                break;
        }
        
        System.out.println("Update new information successfully.");
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

//        // Clear the temp list.
//        tempList.clear();
//
//        // Add the student with the id to the list.
//        tempList.put(id, studentList.get(id));
//
//        // Print out all the information of that student.
//        print(tempList);
//
//        while (true) {
//
//            // Get choice from user.
//            System.out.print("Enter the information you want to delete (ID-student C-course): ");
//            check = input.nextLine().trim().toUpperCase();
//
//            // Check if it null.
//            if (checker.checkNullValue(check, "Please enter something.")) {
//
//                // Check if user dont enter valid choice.
//            } else if (!check.equals("ID") && !check.equals("C")) {
//                System.out.println("Please only enter valid choice (ID-student C-course).");
//
//                // If user enter valid choice then break the loop.
//            } else {
//                break;
//            }
//        }
//
//        // Run the choice from user.
//        switch (check) {
//
//            // If user choose ID option.
//            case "ID":
//
//                // Remove the student by id.
//                studentList.remove(id);
//                System.out.println("Successfully remove student with Id: " + id + ".\n");
//                break;
//
//            // If user choose C option.
//            case "C":
//
//                // Get all the course from user.
//                HashMap<String, Integer> courseList = studentList.get(id).getCourses();
//
//                while (true) {
//
//                    // Get course from user.
//                    System.out.print("Enter the course you want to delete: ");
//                    check = input.nextLine().trim();
//
//                    // Check if it null.
//                    if (checker.checkNullValue(check, "Please enter something")) {
//
//                        // Check if the course is a valid course or not.
//                    } else if (!check.equals("java") && !check.equals(".net") && !check.equals("C/C++")) {
//                        System.out.println("Not a valid course (only java or .net or C/C++");
//
//                        // Check if the course is exist or not.
//                    } else if (!courseList.containsKey(check)) {
//                        System.out.println("The are no course match with your search.");
//
//                        // If the course is not exist then break the loop.
//                    } else {
//                        break;
//                    }
//                }
//
//                // Check if the number of that course is 1 or not.
//                if (courseList.get(check) == 1) {
//
//                    // If the number of that course is 1 then remove it from the list.
//                    courseList.remove(check);
//
//                    // Check if the number of that course is bigger than 1.
//                } else {
//
//                    // Reduce the number or that course by 1.
//                    courseList.replace(check, courseList.get(check) - 1);
//                }
//
//        }
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
            System.out.print("Enter student course: ");
            check = input.nextLine().trim().toLowerCase();

            // Check if it null.
            if (checker.checkNullValue(check, "Please enter something.")) {

                // Check if the course is a valid course or not.
            } else if (!check.equals("java") && !check.equals(".net") && !check.equals("c/c++")) {
                System.out.println("Not a valid course (only Java or .Net or C/C++.");

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

    public void checkExistCourse(String semester) {

        pos = -1;

        if (studentList.isEmpty() || !studentList.containsKey(id)) {
            return;
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
            return;
        }

        courseList = semesterList.get(pos).getStudent().getCourseInSemester();

        if (courseList.isEmpty()) {
            return;
        }

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
