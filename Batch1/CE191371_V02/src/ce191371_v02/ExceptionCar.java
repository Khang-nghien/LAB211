/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191371_v02;

/**
 * V02 - Showroom car.
 *
 * The class to check the input from user.
 *
 * @author Vu Minh Khang - CE191371 - 4/3/25
 */
public class ExceptionCar extends Exception {

    /**
     * Method to check the input price from user.
     *
     * @param type is the type of the car.
     * @param price is the price of the car.
     * @param color is the color of the car.
     *
     * @return true if the price is valid. False if not.
     */
    public boolean checkPrice(String type, String price, String color) {

        try {

            // Get all the price from that type of car.
            int[] allPrice = Price.valueOf(type).getPrice();

            // If the color is none then reduce the price of the car by 100.
            if (color.equals("NO COLOR")) {

                // Check if the price of car is valid or not.
                if (Integer.parseInt(price) != (allPrice[0] - 100) && Integer.parseInt(price) != (allPrice[1] - 100) && Integer.parseInt(price) != (allPrice[2] - 100)) {

                    // If not then throw an exception.
                    throw new Exception();
                }

                // If the car have color then check the price of the car.
            } else {

                // Check if the price of car is valid or not.
                if (Integer.parseInt(price) != allPrice[0] && Integer.parseInt(price) != allPrice[1] && Integer.parseInt(price) != allPrice[2]) {

                    // If not then throw an exception.
                    throw new Exception();
                }
            }

            // Return true if the price car is valid.
            return true;

        } catch (Exception e) {

            // Return false if the price car is invalid.
            return false;
        }

    }

    /**
     * Method to check the color of the car is valid or not.
     *
     * @param type is the type of the car.
     * @param color is the color of the car.
     *
     * @return true if the color is valid. False if not.
     */
    public boolean checkColor(String type, String color) {

        try {

            // Get all the color from that type of car.
            String[] allColor = Color.valueOf(type).getColor();

            // Check if the color of car is valid or not.
            if (!color.equals(allColor[0]) && !color.equals(allColor[1]) && !color.equals(allColor[2]) && !color.equals(allColor[3])) {

                // If not then throw an exception.
                throw new Exception();
            }

            // Return true if the color car is valid.
            return true;

        } catch (Exception e) {

            // Return false if the color car is invalid.
            return false;
        }
    }

    /**
     * Method to check the day sell of the car is valid or not.
     *
     * @param type is the type of the car.
     * @param day is the day sell of the car.
     *
     * @return true if the color is valid. False if not.
     */
    public boolean checkDaySell(String type, String day) {

        try {

            // Get all the day sell from that type of car.
            String[] allDay = Day.valueOf(type).getDay();

            // Check if the day sell of car is valid or not.
            if (!day.equals(allDay[0]) && !day.equals(allDay[1]) && !day.equals(allDay[2])) {

                // If not then throw an exception.
                throw new Exception();
            }

            // Return true if the day sell car is valid.
            return true;

        } catch (Exception e) {

            // Return false if the day sell car is invalid.
            return false;
        }
    }

    /**
     * Method to check the type of the car is valid or not.
     * 
     * @param type is the type of the car.
     * 
     * @return true if the color is valid. False if not.
     */
    public boolean checkCar(String type) {

        try {

             // Check if the type of car is valid or not.
            if (!type.equals("AUDI") && !type.equals("BMW") && !type.equals("MERCEDES")) {
                
                // If not then throw an exception.
                throw new Exception();
            }

            // Return true if the type car is valid.
            return true;

        } catch (Exception e) {
            
            // Return false if the type car is invalid.
            return false;
        }
    }

    /**
     * Method to check the car is valid or not.
     * 
     * @param type is the type of the car.
     * @param color is the color of the car.
     * @param day is the day sell of the car.
     * @param price is the price of the car.
     * 
     * @return true if the car is valid. False if not.
     */
    public boolean checkValidCar(String type, String color, String day, String price) {

        try {

            // If the type of car is null.
            if (type.length() == 0) {
                throw new Exception("Name can't null");
            }

            // If the color of car is null.
            if (color.length() == 0) {
                throw new Exception("Name can't null");
            }

             // If the day sell of car is null.
            if (day.length() == 0) {
                throw new Exception("Name can't null");
            }

             // If the price of car is null.
            if (price.length() == 0) {
                throw new Exception("Name can't null");
            }

            // If the price contain special character.
            if (!price.matches("[0-9]+")) {
                throw new Exception("Price is digit");
            }

            // If the price is not a positive integer.
            if (Integer.parseInt(price) <= 0) {
                throw new Exception("Price greater than zero");
            }

            // If the car is not valid.
            if (!checkCar(type)) {
                throw new Exception("Car break");
            }

            // If the color is not valid.
            if (!checkColor(type, color)) {
                throw new Exception("Color Car does not exist");
            }

            // If the price is not valid.
            if (!checkPrice(type, price, color)) {
                throw new Exception("Price Car does not exist");
            }

            // If the day sell is not valid.
            if (!checkDaySell(type, day)) {
                throw new Exception("Car can't sell today");
            }

            // Return true if the car is valid.
            return true;
            
        } catch (Exception e) {

            // Print out the error.
            System.out.println("Can't sell Car\n" + e.getMessage());
            
            // Return false if the car is invalid.
            return false;
        }
    }
}
