/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191371_v01;

/**
 * V01 - Lucky Number
 * 
 * This class to storage the score of the game.
 *
 * @author Vu Minh Khang - CE191371 - 7/1/2025
 */
public class Game {
    
    // Create all field and set it to private.
    // The luckyNumber field is using for creating lucky number for that game.
    // The numberGuess field is using for counting total guess for that game.
    private int luckyNumber;
    private int numberGuess;
    
    /**
     * Create constructor with none parameters.
     */
    public Game(){
    }
    
    /**
     * Create constructor with parameters.
     * 
     * @param luckyNumber is the number that user need to guess.
     * @param numberGuess is the total of guess that user guess.
     */
    public Game(int luckyNumber, int numberGuess) {
        this.luckyNumber = luckyNumber;
        this.numberGuess = numberGuess;
    }
    
    /**
     * Getter for lucky number.
     * 
     * @return luckyNumber is the lucky number of this game.
     */
    public int getLuckyNumber() {
        return luckyNumber;
    }
    /**
     * Setter for lucky number.
     * 
     * @param luckyNumber is the lucky number of this game.
     */
    public void setLuckyNumber(int luckyNumber) {
        this.luckyNumber = luckyNumber;
    }
    
    /**
     * Getter for number guess.
     * 
     * @return numberGuess is the number of guess in this game.
     */
    public int getNumberGuess() {
        return numberGuess;
    }
    
    /**
     * Setter for number guess.
     * 
     * @param numberGuess is the number of guess in this game.
     */
    public void setNumberGuess(int numberGuess) {
        this.numberGuess = numberGuess;
    } 

}
