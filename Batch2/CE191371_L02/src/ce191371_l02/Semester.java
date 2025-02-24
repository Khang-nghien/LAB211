/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191371_l02;

/**
 * L02 - Create a Java console program to manage students.
 * 
 * Class that contain all semester data.
 *
 * @author Vu Minh Khang - CE191371 - 16/2/25
 */
public class Semester {
    
    // Create all field and set it to private.
    // The semesterName field is the name of the semester.
    // The Object student is the student in this semester.
    private String semesterName;
    private Student student;

    /**
     * Create Constructor with none parameters.
     */
    public Semester() {
    }

    /**
     * Create Constructor with parameters.
     * 
     * @param semesterName is the name of this semester.
     * @param student is the student in this semester.
     */
    public Semester(String semesterName, Student student) {
        this.semesterName = semesterName;
        this.student = student;
    }

    /**
     * Getter for the semester name.
     * 
     * @return the name of the semester.
     */
    public String getSemesterName() {
        return semesterName;
    }

    /**
     * Getter for the semester name.
     * 
     * @param semesterName is the name of the semester.
     */
    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    /**
     * Getter for the student.
     * 
     * @return the student in this semester.
     */
    public Student getStudent() {
        return student;
    }

    /**
     * Setter for the student.
     * 
     * @param student is the student in this semester.
     */
    public void setStudent(Student student) {
        this.student = student;
    }
    
    
}
