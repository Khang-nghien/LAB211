/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191371_s07;

/**
 * S07 - Employee management program.
 *
 * The class contain employee data.
 *
 * @author Vu Minh Khang - CE191371 - 12/2/25
 */
public class Employee {

    // Create all field and set it to private.
    // The id field is the id of the employee (NV****).
    // The name field is the name of the employee.
    // The salaray field is the salary of the employee.
    // The COE field is the coefficients salary of employee.
    private String id;
    private String name;
    private double salaray;
    private double COE;

    /**
     * Create Constructor with none parameters.
     */
    public Employee() {
    }

    /**
     * Create constructor with parameters.
     *
     * @param id is id of the employee (NV****).
     * @param name is the name of the employee.
     * @param salaray is the salary of the employee.
     * @param COE is the coefficients salary of employee.
     */
    public Employee(String id, String name, double salaray, double COE) {
        this.id = id;
        this.name = name;
        this.salaray = salaray;
        this.COE = COE;
    }

    /**
     * Getter for the employee id.
     *
     * @return the id of the employee.
     */
    public String getId() {
        return id;
    }

    /**
     * Setter for the employee id.
     *
     * @param id is id of the employee (NV****).
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter for the employee name.
     *
     * @return the name of the employee.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the employee name.
     *
     * @param name is the name of the employee.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the salary of the employee.
     *
     * @return the salary of the employee.
     */
    public double getSalaray() {
        return salaray;
    }

    /**
     * Setter for the salary of the employee.
     *
     * @param salaray is the salary of the employee.
     */
    public void setSalaray(double salaray) {
        this.salaray = salaray;
    }

    /**
     * Getter for the COE of the employee.
     *
     * @return the COE of the employee.
     */
    public double getCOE() {
        return COE;
    }

    /**
     * Setter for the COE of the employee.
     *
     * @param COE is the COE of the employee.
     */
    public void setCOE(double COE) {
        this.COE = COE;
    }

}
