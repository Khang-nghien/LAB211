/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191371_v01;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * V01 - Lucky Number
 * 
 * This class to play game, check win and print result.
 *
 * @author Vu Minh Khang - CE191371 - 7/1/2025
 */
public class Program {

    // Create all field and set it to private.
    // The Scanner is using for gettting input from the user.
    // The win field is using for checking the user is win or not (if win then stop guessing, if not continue the guessing).
    // The ArrayList is using for storage all the game the user had played.
    // The choice field is using for checking if the user want to continue playing or not.
    // The check field is the valid number after checking.
    private Scanner input = new Scanner(System.in);
    private boolean win;
    private ArrayList<Game> gameList = new ArrayList<>();
    private int check;

    /**
     * Display the game and handle user guess.
     */
    public void program() {
        

    }

    /**
     * Create new game and checking win for the user.
     */
    public void play() {

        // Create a new lucky number.
        Game game = createNumber();

        // Create a count variable for counting the guess from the user.
        int count = 0;
        System.out.println("Create new game successfully!");

        // Set the infinity loop until the user find lucky number.
        win = true;
        while (win) {

            // Get the guess from user.
            System.out.print("Please enter a number: ");
            String guess = input.nextLine().trim();

            // Checking if the user enter valid number or not.
            // If the user enter a valid number guess then check user win or not.
            // If the user enter an invalid number guess then request the user re-enter the number.
            if (checkValid(guess)) {

                // Increasing the guess user.
                count++;

                // Checking if the user win the game or not (if win then stop the loop, if not then continue).
                win = checkWin(check, game, count);
            }
        }

    }

    /**
     * Checking the input string number from user is a valid number or not. If
     * it is a valid number then convert it to integer. If it is not a valid
     * number then notify to the user.
     *
     * @param number is the input from user to check.
     * 
     * @return true if the input is a valid number, false if the input is an
     * invalid number.
     */
    public boolean checkValid(String number) {
        
        // Try convert the input from user to integer.
        try {
            
            // Covert the the input into integer.
            // If no error occur then set the value of number to check and return true.
            check = Integer.parseInt(number);
            return true;
            
            // If a error occur then notify to the user and return false.
        } catch (NumberFormatException e) {
            System.out.println("Please only enter valid number");
            return false;
        }
    }

    /**
     * Create a new and a lucky number for the game.
     *
     * @return a game object have a lucky number in it.
     */
    public Game createNumber() {

        // Create a new game.
        Game game = new Game();

        // Using the random function from class Math for generating a random number from 0.0 to 1.0.
        // Then mutiply it with 100 to create a random number from 0.0 to 100.0 then typecast to integer and set it to the lucky number.
        game.setLuckyNumber((int) (Math.random() * 10) + 1);

        // Return the new game that have a lucky number.
        return game;
    }

    /**
     * Checking the best game from the all the game user had played (the least
     * guess).
     *
     * @return least number guess that from all game.
     */
    public int checkBestGame() {

        // Set the guess from first game to the best game.
        int bestGame = gameList.get(0).getNumberGuess();

        // Get each guess game from the list game.
        for (int i = 0; i < gameList.size(); i++) {
            int currentGame = gameList.get(i).getNumberGuess();

            // If the best game have more guess than current game then set the current game to best game. 
            if (bestGame > currentGame) {
                bestGame = currentGame;
            }
        }

        // Return the least number guess from all game.
        return bestGame;
    }

    /**
     * Calculating the average guess.
     *
     * @return the average guess.
     */
    public double caculateGuessAvg() {

        // Divide the total guess from all game to the total game played.
        return totalGuess() * 1.0 / (gameList.size());
    }

    /**
     * Checking if the user guess the lucky number correct or not.
     *
     * @param guess is the number that user think that is the lucky number.
     * @param currentGame is the game that the player is playing.
     * @param count is the number of guess that user had guessed.
     *
     * @return true if the user guess the correct lucky number, false if the
     * user guess the wrong number.
     */
    public boolean checkWin(int guess, Game currentGame, int count) {

        // Get the lucky number from current game for checking.
        int luckyNumber = currentGame.getLuckyNumber();

        // If the guess bigger than lucky number then notify it to user.
        if (guess > luckyNumber) {
            System.out.println("The lucky number is smaller than your guess.");

            // If the guess smaller than lucky number then notify it to user.   
        } else if (guess < luckyNumber) {
            System.out.println("The lucky number is bigger than your guess.");

            // If the user guess the correct lucky number the notify it to user and set the total guess in this game to this game.
        } else {
            System.out.println("You win the game.");
            
            // Set the total guess of this game to this game.
            currentGame.setNumberGuess(count);
            
            // Adding this game to the game list.
            gameList.add(currentGame);
            
            // Ending the game.
            return false;
        }
        
        // If the user did not guess the lucky number then continue the game.
        return true;
    }

    /**
     * Calculate the total guess from all game.
     *
     * @return the number of total guess.
     */
    public int totalGuess() {
        int totalGuess = 0;
        
        // Get the guess from each game had played from the game list and adding it to the total guess number.
        for (int i = 0; i < gameList.size(); i++) {
            totalGuess += gameList.get(i).getNumberGuess();
        }
        
        // Return the total guess number.
        return totalGuess;
    }

    /**
     * This method will return the summary of all game.
     *
     * @return string that contains the summary of all game.
     */
    public String getResult() {
        
        // Return the string that contains the number game player, the total number guess of all game, the number guess average of all game and the number guess of best game.
        return String.format("Total games: %d\nTotal guess: %d\nGuess average: %.2f\nBest game: %d guess\n", gameList.size(), totalGuess(), caculateGuessAvg(), checkBestGame());
    }
}
