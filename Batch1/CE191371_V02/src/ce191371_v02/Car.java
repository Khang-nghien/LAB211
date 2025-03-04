/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191371_v02;

/**
 * V02 - Showroom car.
 * 
 * The class of type of car.
 *
 * @author Vu Minh Khang - CE191371 - 4/3/25
 */
public enum Car {
    
    // All type of car.
    AUDI,
    MERCEDES,
    BMW;
    
    private String type;
    
    /**
     * Constructor of type car.
     */
    Car() {
    }
    
    /**
     * Getter for the type of car.
     * 
     * @return the type of car.
     */
    public String getType() {
        return type;
    }

}
