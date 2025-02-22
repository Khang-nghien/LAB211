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
public class Experience extends Candidates{

    private Candidates experience;
    private int expInYear;
    private String proSkill;

    public Experience() {
    }

    public Experience(Candidates experience, int expInYear, String proSkill) {
        this.experience = experience;
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public Experience(Candidates experience, int expInYear, String proSkill, String candidateId, String firstName, String lastName, int birthDate, String address, int phone, String email, int type) {
        super(candidateId, firstName, lastName, birthDate, address, phone, email, type);
        this.experience = experience;
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public Candidates getExperience() {
        return experience;
    }

    public void setExperience(Candidates experience) {
        this.experience = experience;
    }  

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }
    
}
