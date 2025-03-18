/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import GamePlay.IO;
import GamePlay.GamePlay;

/**
 *
 * @author Vu Minh Khang - CE191371 -
 */
public class HangMan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        IO checker = new IO();
        if (!checker.checkExistData()) {
            return;
        }
        GamePlay player = new GamePlay();
        player.run();
    }

}
