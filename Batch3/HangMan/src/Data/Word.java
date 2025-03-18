/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Vu Minh Khang - CE191371 -
 */
public class Word {

    private String[] listWords;
    private String strWord;
    private String filePath;
    private String fileName;
    private FileInputStream fileInputStream;
    private Scanner scanner;
    private String output;

    public Word(String fileName) {
        this.fileName = fileName;
        this.filePath = "src/hangman/DataFolder/" + fileName + ".txt";
        strWord = "";
        getWordFromFile(); 
    }

    public void getWordFromFile() {
        try {
            fileInputStream = new FileInputStream(getFile());
            scanner = new Scanner(fileInputStream);
            while (scanner.hasNextLine()) {
                this.strWord += scanner.nextLine() + "@";
            }
            
            setWordToList();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    public File getFile() {
        return new File(filePath);
    }
    
    public void setWordToList() {
        this.listWords = strWord.split("@");
    }

    public String[] getListWords() {
        return listWords;
    }
    
    public String getWordToString() {
        return this.strWord;
    }

    @Override
    public String toString() {
        output = "";
        
        for (String word : getListWords()) {
            output += word + "\n";
        }
        
        return output; 
    }
}
