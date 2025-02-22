/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191371_v06;

/**
 * V06 - Array and string manipulations.
 *
 * The student data class.
 *
 * @author Vu Minh Khang - CE191371 - 13/2/25
 */
public class Student {

    // Create all field and set it to private.
    // The name field is the name of the student.
    // The nameLength is the length of the name of the student.
    private String name;
    private int nameLength;

    /**
     * Create Constructor with none parameters.
     */
    public Student() {
    }

    /**
     * Create constructor with parameters.
     *
     * @param name is the name of the student.
     * @param nameLength is the length of the name of the student.
     */
    public Student(String name, int nameLength) {
        this.name = name;
        this.nameLength = nameLength;
    }

    /**
     * Getter for student name.
     * 
     * @return the student name.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Setter for student name.
     * 
     * @param name is the name of the student.
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Getter for the length of the name student.
     * 
     * @return the length of the student name.
     */
    public int getNameLength() {
        return nameLength;
    }
    
    /**
     * Setter for the length of the name student.
     * 
     * @param nameLength is the length of the student name.
     */
    public void setNameLength(int nameLength) {
        this.nameLength = nameLength;
    }

}
