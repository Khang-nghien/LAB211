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
public class Fresher extends Candidates{
    
    private Candidates fresher;
    private int graduationDate;
    private String graduationRank;
    private String education;

    public Fresher() {
    }

    public Fresher(Candidates fresher) {
        this.fresher = fresher;
    }

    public Fresher(Candidates fresher, int graduationDate, String graduationRank, String education) {
        this.fresher = fresher;
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    public Fresher(Candidates fresher, int graduationDate, String graduationRank, String education, String candidateId, String firstName, String lastName, int birthDate, String address, int phone, String email, int type) {
        super(candidateId, firstName, lastName, birthDate, address, phone, email, type);
        this.fresher = fresher;
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    public Candidates getFresher() {
        return fresher;
    }

    public void setFresher(Candidates fresher) {
        this.fresher = fresher;
    }

    public int getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(int graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }
    
    
}
