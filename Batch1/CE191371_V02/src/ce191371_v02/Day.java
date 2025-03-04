/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191371_v02;

/**
 * V02 - Showroom car.
 *
 * The class contain day sell of each type car.
 *
 * @author Vu Minh Khang - CE191371 - 4/3/25
 */
public enum Day {
    
    // All day sell for each type of car.
    AUDI(new String[]{"FRIDAY", "SUNDAY", "MONDAY"}),
    MERCEDES(new String[]{"TUESDAY", "SATURDAY", "PURPLE"}),
    BWM(new String[]{"MONEY", "SUNDAY", "THURSDAY"});
    
    private String[] day;
    
    /**
     * Constructor of the day sell car.
     * 
     * @param day is the day sell of the car.
     */
    Day(String[] day) {
        this.day = day;
    }

    /**
     * Method to get day sell from each type of car.
     * 
     * @return the array contain all the day sell of the car.
     */
    public String[] getDay() {
        return day;
    }

    /**
     * Method to set day sell of each type of car.
     * 
     * @param day is the new day sell of the car.
     */
    public void setDay(String[] day) {
        this.day = day;
    }

    
}
