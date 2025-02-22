/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191371_v04;

/**
 * V04 - Doctor manage program.
 *
 * This class is using for getting and setting of the information of the doctor.
 *
 * @author Vu Minh Khang - CE191371 - 18/1/25
 */
public class Doctor {
    
    // Create all field and set it to private.
    // The id field is the id of the doctor.
    // The name field is the name of the doctor.
    // The specialization field is the specialization of the doctor.
    // The availability field is the availability of the doctor.
    private String id;
    private String name;
    private String specialization;
    private String availability;

    /**
     * Create the Constructor with none parameter.
     */
    public Doctor() {
    }

    /**
     * Create the Constructor with 4 parameter is id, name specialization,
     * availability.
     *
     * @param id is the id of the doctor.
     * @param name is the name of the doctor.
     * @param specialization is the specialization of the doctor.
     * @param availability is the availability of the doctor.
     */
    public Doctor(String id, String name, String specialization, String availability) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.availability = availability;
    }

    /**
     * Getter for the id of the doctor.
     *
     * @return the id of the doctor.
     */
    public String getId() {
        return id;
    }

    /**
     * Setter for the id of the doctor.
     *
     * @param id is the id that user enter in.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter for the name of the doctor.
     *
     * @return name of the doctor.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the name of the doctor.
     *
     * @param name is the name that user enter in.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the specialization of the doctor.
     *
     * @return the specialization of the doctor.
     */
    public String getSpecialization() {
        return specialization;
    }

    /**
     * Setter for the specialization of the doctor.
     *
     * @param specialization is the specialization that user enter in.
     */
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    /**
     * Getter for the availability of the doctor.
     *
     * @return the availability of the doctor.
     */
    public String getAvailability() {
        return availability;
    }

    /**
     * Setter for the availability of the doctor.
     *
     * @param availability is the availability that user enter in.
     */
    public void setAvailability(String availability) {
        this.availability = availability;
    }

}
