/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GamePlay;

import java.util.Scanner;

/**
 *
 * @author Vu Minh Khang - CE191371 -
 */
public class GamePlay {

    private IO checker = new IO();
    private String check;
    private Scanner input = new Scanner(System.in);
    private String fileName;
    private String word;
    private Game game;

    public void run() {

        do {
            menu();
            while (true) {
                System.out.print("Your choice: ");
                check = input.nextLine().trim();

                if (!checkInput()) {
                    break;
                }
            }
            runChoice();    
        } while (checkContinue());
    }
    
    public boolean checkContinue() {
        while (true) {
            System.out.println("Would you like to continue (yes, no)?");
            check = input.nextLine().trim().toLowerCase();
            switch (check) {
                case "yes":
                    return true;
                case "no":
                    return false;
                default:
                    System.out.println("Please only enter yes or no.");
                    break;
            }
        }
    }

    public boolean checkInput() {
        if (checker.checkNullInput(check)) {
            System.out.println("Please enter something.");
        } else if (checker.checkNumberInput(check)) {
            System.out.println("Please only enter positive number");
        } else {
            return false;
        }

        return true;
    }

    public boolean checkValidFile() {
        if (checker.checkNullInput(check)) {
            System.out.println("Please enter something.");
        } else if (checker.checkNumberInput(check)) {
            System.out.println("Please only enter positive number");
        } else if (checker.checkFileExist(check)) {
            System.out.println("Not a valid file.");
        } else {
            return false;
        }

        return true;
    }

    public boolean checkValidGuess() {
        if (checker.checkLengthInput(check)) {
            System.out.println("Please only enter 1 character");
        } else if (checker.checkCharacterInput(check)) {
            System.out.println("Please only enter character from A to Z.");
        } else {
            return false;
        }

        return true;
    }

    public void runChoice() {
        switch (Integer.parseInt(check)) {
            case 1:
                createFile();
                break;

            case 2:
                addWord();
                break;

            case 3:
                go();
                break;
        }
    }

    public void generateGame() {
        System.out.println("You currently have " + game.getCount() + " incorrect guesses.");
        System.out.println("Here is your puzzle:");

        game.generateWord();
        game.printWord();
    }

    public void guess() {
        while (true) {
            System.out.println("Please enter your guess.");
            check = input.nextLine();

            if (!checkValidGuess()) {
                break;
            }
        }
    }

    public void play() {
        while (game.isWin() && game.isLose()) {
            if (game.isWin() && game.isLose()) {
                guess();
                game.checkGuess(check.toUpperCase().charAt(0));
                game.printWord();
            }
        }
    }

    public void go() {

        System.out.println("Choose file you want to find the puzzle word in it");
        printFileName();

        while (true) {
            System.out.print("Your choice: ");
            check = input.nextLine().trim().toLowerCase();

            if (!checkValidFile()) {
                break;
            }
        }

        game = new Game(check);

        OUTER:
        while (true) {
            System.out.println("Would you like to play hangman (yes, no)?");
            check = input.nextLine().trim().toLowerCase();
            switch (check) {
                case "yes":
                    break;
                case "no":
                    break OUTER;
                default:
                    System.out.println("Please only enter yes or no.");
                    break;
            }
        }

        System.out.println("Thanks for playing!");
    }

    public void addWord() {
        while (true) {
            System.out.print("Enter the file you want to add new word: ");
            fileName = input.nextLine().trim();

            if (!checker.checkFileExist(fileName)) {
                break;
            }
        }

        while (true) {
            System.out.print("Enter the new word: ");
            word = input.nextLine();

            if (!checker.addDataToFile(fileName, word)) {
                break;
            }
        }
    }

    public void createFile() {
        while (true) {
            System.out.print("Enter the new file: ");
            fileName = input.nextLine().trim();

            if (!checker.addFile(fileName)) {
                break;
            }
        }
    }

    public void printFileName() {
        String[] list = checker.getFileList();
        for (int i = 0; i < list.length; i++) {
            System.out.println((i + 1) + ". " + list[i]);
        }
    }

    public void menu() {
        System.out.println("===== MENU =====");
        System.out.println("1. Create new file.");
        System.out.println("2. Add new word to file.");
        System.out.println("3. Play");
    }
}
