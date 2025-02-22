/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191371_l02;

/**
 *
 * @author Vu Minh Khang - CE191371 -
 */
public class Semester {
    
    private String semesterName;
    private Student student;

    public Semester() {
    }

    public Semester(String semesterName, Student student) {
        this.semesterName = semesterName;
        this.student = student;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
    
}
