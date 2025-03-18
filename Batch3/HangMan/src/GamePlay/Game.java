/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GamePlay;

import Data.Word;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Vu Minh Khang - CE191371 -
 */
public class Game {

    private Word word;
    private String hiddenWord;
    private String[] wordList;
    private int count;
    private char[] puzzle;
    private String output;
    private boolean correct;
    private boolean win;
    private boolean lose;
    private Character[] guessWord;

    public Game(String file) {
        this.word = new Word("src/hangman/DataFolder/" + file + ".txt");
        this.count = 0;
        this.win = false;
        this.lose = false;
        this.guessWord = new Character[27];
    }

    public void generateWord() {
        wordList = word.getListWords();
        hiddenWord = wordList[(int) (Math.random() * wordList.length)].toUpperCase();
        puzzle = new char[hiddenWord.length()];
        for (int i = 0; i < puzzle.length; i++) {
            puzzle[i] = '-';
        }
    }

    public void checkGuess(Character guess) {
        
        if (checkWordGuess(guess)) {
            System.out.println("Sorry you have guessed that letter already.\nNow it counts as a miss.");
            return;
        }
        
        correct = false;
        for (int i = 0; i < hiddenWord.length(); i++) {
            if (hiddenWord.charAt(i) == guess) {
                puzzle[i] = guess;
                correct = true;
            }
        }
        
        if (checkWin()) {
            System.out.println("Congratulations! You got the correct word, " + hiddenWord.toUpperCase());
            return;
        }
        
        if (checkLose()) {
            System.out.println("Sorry, you have made 5 incorrect guesses, you lose.\nThe correct word was " + hiddenWord.toUpperCase());
            return;
        }
        
        if (correct) {
            System.out.println("\nCongratulations, you guessed a letter in the puzzle!\n");
        } else {
            System.out.println("\nSorry, that letter is NOT in the puzzle.\n");
            count++;
        }
    }
    
    public boolean checkWordGuess(Character c) {
        for (int i = 0; i < guessWord.length; i++) {
            if (Objects.equals(guessWord[i], c)) {
                return true;
            }
        }
        return false;
    }
    
    public void addCharacter() {
        for (int i = 0; i < guessWord.length; i++) {
            guessWord[i] = (char)(65 + i);
        }
    }
    
    public boolean checkContinue() {
        return win && lose;
    }
    
    public boolean checkWin() {
        for (int i = 0; i < puzzle.length; i++) {
            if (puzzle[i] == '-') {
                return false;
            }
        }
        return true;
    }
    
    public boolean checkLose() {
        return count == 5;
    }

    public void printWord() {
        output = "";
        for (int i = 0; i < puzzle.length; i++) {
            output += puzzle[i] + " ";
        }
        System.out.println(output);
    }

    public int getCount() {
        return count;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public boolean isLose() {
        return lose;
    }

    public void setLose(boolean lose) {
        this.lose = lose;
    }

    public String getHiddenWord() {
        return hiddenWord;
    }
}
