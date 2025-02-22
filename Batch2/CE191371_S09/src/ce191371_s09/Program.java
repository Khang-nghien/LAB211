/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191371_s09;

import java.util.Scanner;

/**
 *
 * @author Vu Minh Khang - CE191371 -
 */
public class Program {

    private Scanner input = new Scanner(System.in);
    private String check;
    private final String unallowCharacter = "@#![]{}()";
    private String go;
    private String output;
    private boolean isSpace;

    public void run() {

        do {
            while (true) {
                System.out.print("Please enter a string:");
                check = input.nextLine().trim();

                if (check.length() != 0) {
                    break;
                }
                System.out.println("Please enter somthing.");
            }

            if (checkString()) {
                System.out.println("Error: do not allow enter special characters such as @,#,!,[,],{,},(,)");
            } else {
                output = "";
                removeSpace();
                System.out.println(output);
                System.out.println("The string after removing:" + output.trim());
            }

            go();
        } while (go.equals("y"));
    }

    public boolean checkString() {

        for (int i = 0; i < check.length(); i++) {

            if (unallowCharacter.indexOf(check.charAt(i)) != -1) {

                return true;
            }
        }

        return false;
    }

    public void go() {

        do {

            while (true) {
                System.out.print("Do you want to continue?(Y/N)");
                go = input.nextLine().trim().toLowerCase();

                if (go.length() != 0) {
                    break;
                }

                System.out.println("Please enter something");
            }
        } while (!go.equals("y") && !go.equals("n"));
    }

    public void removeSpace() {
        isSpace = false; 
        for (int i = 0; i <= check.length() - 1; i++) {
            if (check.charAt(i) != ' ') {   
                output += check.charAt(i);
                isSpace = false;            
            } else if (isSpace != true) {
                output += ' ';
                isSpace = true;
                
            }
        }
    }

}
