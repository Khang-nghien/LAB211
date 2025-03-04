/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191371_v02;

/**
 * V02 - Showroom car.
 * 
 * The class contain color of each type car.
 *
 * @author Vu Minh Khang - CE191371 - 4/3/25
 */
public enum Color {
    
    // All color of each type car.
    AUDI(new String[]{"WHITE", "ORANGE", "YELLOW", "NO COLOR"}),
    MERCEDES(new String[]{"GREEN", "BLUE", "PURPLE", "NO COLOR"}),
    BWM(new String[]{"PINK", "RED", "BROWN", "NO COLOR"});
    
    private String[] color;
    
    /**
     * Constructor of the color car.
     * 
     * @param color is the color of the car.
     */
    Color(String[] color) {
        this.color = color;
    }

    /**
     * Method to get color from each type of car.
     * 
     * @return the array contain all the color of the car.
     */
    public String[] getColor() {
        return color;
    }

    /**
     * Method to set color of each type of car.
     * 
     * @param color is the new color of the car.
     */
    public void setColor(String[] color) {
        this.color = color;
    }

}
