/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191371_l01;

/**
 *
 * @author Vu Minh Khang - CE191371 <your.name at your.org>
 */
public class Internship extends Candidates{
    
    private Candidates internshipe;
    private String majors;
    private int semester;
    private String unversityName;

    public Internship() {
    }

    public Internship(Candidates internshipe) {
        this.internshipe = internshipe;
    }

    public Internship(Candidates internshipe, String majors, int semester, String unversityName) {
        this.internshipe = internshipe;
        this.majors = majors;
        this.semester = semester;
        this.unversityName = unversityName;
    }

    public Internship(Candidates internshipe, String majors, int semester, String unversityName, String candidateId, String firstName, String lastName, int birthDate, String address, int phone, String email, int type) {
        super(candidateId, firstName, lastName, birthDate, address, phone, email, type);
        this.internshipe = internshipe;
        this.majors = majors;
        this.semester = semester;
        this.unversityName = unversityName;
    }

    public Candidates getInternshipe() {
        return internshipe;
    }

    public void setInternshipe(Candidates internshipe) {
        this.internshipe = internshipe;
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getUnversityName() {
        return unversityName;
    }

    public void setUnversityName(String unversityName) {
        this.unversityName = unversityName;
    }
    
}
