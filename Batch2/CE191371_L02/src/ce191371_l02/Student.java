/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191371_l02;

import java.util.ArrayList;

/**
 * L02 - Create a Java console program to manage students.
 * 
 * Class that contain all student data.
 *
 * @author Vu Minh Khang - CE191371 - 16/2/25
 */
public class Student {
    
    // Create all field and set it to private.
    // The id field is the id of the student.
    // The name field is the name of the student.
    // The HashMap courseInSemester is the list contains all the course of that semester the student have.
    private String id;
    private String name;
    private ArrayList<String> courseInSemester = new ArrayList<>();
    
    /**
     * Create Constructor with none parameters.
     */
    public Student() {
    }
    
    /**
     * Create Constructor with parameters.
     * 
     * @param id is the id of the student.
     * @param name is the name of the student.
     * @param courseInSemester is the semester contain all courses of the student.
     */
    public Student(String id, String name, ArrayList<String> courseInSemester) {
        this.id = id;
        this.name = name;
        this.courseInSemester = courseInSemester;
    }

    /**
     * Getter for the student name.
     * 
     * @return the name of the student.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the student name.
     * 
     * @param name is the name of the student.
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Getter for the id of the student.
     * 
     * @return is the id of the student.
     */
    public String getId() {
        return id;
    }
    
    /**
     * Setter for the id of the student.
     * 
     * @param id is the id of the student.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter for the courses of the student.
     * 
     * @return the list contains all the courses of the student in the semester.
     */
    public ArrayList<String> getCourseInSemester() {
        return courseInSemester;
    }

    /**
     * Setter for the course of the student.
     * 
     * @param courseInSemester is the list contains all the courses of the student in the semester.
     */
    public void setCourseInSemester(ArrayList<String> courseInSemester) {
        this.courseInSemester = courseInSemester;
    }

}
