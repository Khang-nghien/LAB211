/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191371_v02;

/**
 * V02 - Showroom car.
 *
 * The class contain price of each type car.
 *
 * @author Vu Minh Khang - CE191371 - 4/3/25
 */
public enum Price {

    // All price for each type of car.
    AUDI(new int[]{5500, 3000, 4500}),
    MERCEDES(new int[]{5000, 6000, 8500}),
    BMW(new int[]{2500, 3000, 3500});

    private int[] price;

    /**
     * Constructor of the price car.
     *
     * @param price is the price of the car.
     */
    Price(int[] price) {
        this.price = price;
    }

    /**
     * Method to get price from each type of car.
     *
     * @return the array contain all the price of the car.
     */
    public int[] getPrice() {
        return price;
    }

    /**
     * Method to set price of each type of car.
     *
     * @param price is the new price of the car.
     */
    public void setPrice(int[] price) {
        this.price = price;
    }
}
