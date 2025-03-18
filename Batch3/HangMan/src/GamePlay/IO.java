/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GamePlay;

import Data.Word;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Vu Minh Khang - CE191371 -
 */
public class IO {

    private final File folderSrc;
    private String[] fileList;
    private FileWriter writer;
    private Word data;

    public IO() {
        this.folderSrc = new File("src/hangman/DataFolder");
        this.fileList = folderSrc.list();
    }

    public String[] getFileList() {
        return fileList;
    }
    
    /**
     * Kiểm tra coi trong folder chung có tồn tại file nào ko.
     * 
     * @return true nếu có file.
     * false nếu ko có.
     */
    public boolean checkExistData() {
        try {
            String[] fileNames = folderSrc.list();

            if (folderSrc.exists() && folderSrc.isDirectory() && fileNames.length != 0) {
                return true;
            } else {
                throw new Exception("There are no data currently.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Lấy số lượng file trong folder.
     * 
     * @return 
     */
    public int getNumberFile() {
        return fileList.length;
    }

    /**
     * Thêm file mới vào folder.
     * 
     * @param inputName là tên file.
     * 
     * @return true nếu file đã tồn tại rồi và file add thất bại.
     * false nếu file add thành công
     */
    public boolean addFile(String inputName) {
        try {
            if (checkFileExist(inputName)) {
                System.out.println("File already exists.");
                return true;
            }

            // Tạo file.
            createFile(inputName);
            System.out.println("Create new file successfully.");
            return false;
        } catch (IOException e) {
            System.out.println("Failed to create new file.");
            return true;
        }
    }

    /**
     * Tạo file mới trong folder.
     * 
     * @param inputName là tên file.
     * 
     * @throws IOException nếu xảy ra lỗi khi add file.
     */
    public void createFile(String inputName) throws IOException {
        // Tạo 1 file với input từ người dùng với đuôi là txt.
        File newFile = new File(folderSrc, inputName.toLowerCase() + ".txt");
        // Tạo file.
        newFile.createNewFile();
        // Update lại list file.
        fileList = folderSrc.list();
    }

    /**
     * Add thêm data vào file.
     * 
     * @param inputName là tên file muốn add data.
     * @param input là data muốn add vào file.
     * 
     * @return true nếu file add thất bại.
     * false nếu file add thành công.
     */
    public boolean addDataToFile(String inputName, String input) {
        data = new Word(inputName);

        if (checkFileExist(inputName)) {
            System.out.println("The file isn't exist in the data.");
            return true;
        }
        
        if (checkWordExist(inputName, input)) {
            System.out.println("The word already exist in the file.");
            return true;
        }

        addWordToFile(inputName, input);
        return false;
    }

    /**
     * Kiểm tra coi file add vào có data đó có sẵn trong đó chưa
     * 
     * @param inputName là tên file.
     * @param inputWord là data cần kiểm tra.
     * 
     * @return true nếu data đã tồn tại trong file.
     * false nếu ko.
     */
    public boolean checkWordExist(String inputName, String inputWord) {
        for (String fileName : fileList) {
            
            // Lấy file cần kiểm tra.
            if ((inputName + ".txt").equalsIgnoreCase(fileName)) {
                // Lấy data ra từ file bằng cách đọc file.
                data.getWordFromFile();
                // Lấy data mà dưới dạng chuổi.
                data.setWordToList();
                
                // Kiểm tra. (Cái này cần chỉnh lại là lấy data dưới dạng array để kiểm tra cho chuẩn).
                if (data.getWordToString().toLowerCase().contains(inputWord)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Thêm data vào file.
     * 
     * @param inputName là tên file cần add.
     * @param inputWord là data cần add vào.
     */
    public void addWordToFile(String inputName, String inputWord) {
        try {
            // Đọc file.
            writer = new FileWriter(new File(folderSrc, inputName + ".txt"), true);
            // Thêm data vào buffer.
            writer.write("\n" + inputWord);
            // Đẩy buffer vào file.
            writer.flush();
            // Đóng đọc file.
            writer.close();

            System.out.println("Added new word to file successfully.");
        } catch (Exception e) {
            System.out.println("Failed to add new word to file.");
        }
    }

    /**
     * Kiểm tra file tồn tại.
     * 
     * @param inputName là tên file.
     * 
     * @return true nếu file tồn tại.
     * false nếu file ko tồn tại.
     */
    public boolean checkFileExist(String inputName) {
        try {
            for (String fileName : fileList) {
                if ((inputName + ".txt").equalsIgnoreCase(fileName)) {
                    return true;
                }
            }

            throw new Exception();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Kiểm tra input.
     * 
     * @param input
     * @return
     * @throws Exception 
     */
    public boolean checkValidInput(String input) throws Exception {
        try {
            checkNull(input);
            checkSpecialCharacter(input);

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void checkNull(String input) throws Exception {
        if (input.length() == 0) {
            throw new Exception("Please enter something.");
        }
    }

    public void checkSpecialCharacter(String input) throws Exception {
        if (!input.matches("[a-zA-Z ]+")) {
            throw new Exception("Please only enter character.");
        }
    }
    
    public boolean checkNullInput(String input) {
        return input.length() == 0;
    }
    
    public boolean checkSpecialCharacterInput(String input) {
        return !input.matches("[a-zA-Z ]+");
    }
    
    public boolean checkNumberInput(String input) {
        return !input.matches("^[1-9]\\d*$");
    }
    
    public boolean checkLengthInput(String input) {
        return input.length() == 1;
    }
    
    public boolean checkCharacterInput(String input) {
        return !input.matches("[a-zA-Z]");
    }
}
