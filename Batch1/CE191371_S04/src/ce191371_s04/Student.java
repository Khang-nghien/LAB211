/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191371_s04;

/**
 * S04 - Check student’s data format.
 * 
 * Class that contain student data.
 *
 * @author Vu Minh Khang - CE191371 - 22/1/25
 */
public class Student {
    
    private String name;
    private String classes;
    private double mathsScore;
    private double chemistryScore;
    private double physicsScore;
    
    /**
     * Create Constructor with none parameters.
     */
    public Student() {
    }

    /**
     * Create constructor with parameters.
     * 
     * @param name is the name of the student.
     * @param classes is the class that student in.
     * @param mathsScore is the math score of student.
     * @param chemistryScore is the chemistry score of student.
     * @param physicsScore is the physics score of student.
     */
    public Student(String name, String classes, double mathsScore, double chemistryScore, double physicsScore) {
        this.name = name;
        this.classes = classes;
        this.mathsScore = mathsScore;
        this.chemistryScore = chemistryScore;
        this.physicsScore = physicsScore;
    }
    
    /**
     * Getter for the name.
     * 
     * @return name of the student.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the name.
     * 
     * @param name is the name of the student.
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Getter for the class.
     * 
     * @return class of the student.
     */
    public String getClasses() {
        return classes;
    }

    /**
     * Setter for the class.
     * 
     * @param classes is the class of the student.
     */
    public void setClasses(String classes) {
        this.classes = classes;
    }
    
    /**
     * Getter for the math score.
     * 
     * @return the math score of the student.
     */
    public double getMathsScore() {
        return mathsScore;
    }
    
    /**
     * Setter for the math score.
     * 
     * @param mathsScore is the math score of the student.
     */
    public void setMathsScore(double mathsScore) {
        this.mathsScore = mathsScore;
    }
    
    /**
     * Getter for the chemistry score.
     * 
     * @return the chemistry score of the student.
     */
    public double getChemistryScore() {
        return chemistryScore;
    }

    /**
     * Setter for the chemistry score.
     * 
     * @param chemistryScore is the chemistry score of the student.
     */
    public void setChemistryScore(double chemistryScore) {
        this.chemistryScore = chemistryScore;
    }
    
    /**
     * Getter for the physics score.
     * 
     * @return the physics score of the student.
     */
    public double getPhysicsScore() {
        return physicsScore;
    }

    /**
     * Setter for the physics score.
     * 
     * @param physicsScore is the physics score of the student.
     */
    public void setPhysicsScore(double physicsScore) {
        this.physicsScore = physicsScore;
    }
    
    /**
     * Calculate the average score of 3 subjects of the student.
     * 
     * @return the average score = (math score + chemistry score + physics score) divide by 3.
     */
    public double averageCalculate() {
        
        // Return the average score by the sum of math score, chemistry score, physics score and divide them by 3.
        return (mathsScore + chemistryScore + physicsScore) / 3;
    }
    
    /**
     * Calculate the type of the student.
     * 
     * @return the type of the student. 
     * (average score >= 7.5 is type A)
     * (average score >= 6.0 and <= 7.5 is type B)
     * (average score >= 4.0 and < 6.0 is type C)
     * (average score < 4.0 is type D)
     */
    public String typeCalculate() {
        
        // If the average of the student bigger than 7.5 then return type of that student is A.
        if (averageCalculate() > 7.5) {
            return "A";
            
        // If the average of the student bigger or equal than 6.0 and smaller or equal than 7.5 then return type of that student is B.
        } else if (averageCalculate() >= 6.0 && averageCalculate() <= 7.5) {
            return "B";
            
         // If the average of the student bigger or equal than 4.0 and smaller or equal than 6.0 then return type of that student is C.
        } else if (averageCalculate() >= 4.0 && averageCalculate() < 6.0) {
            return "C";
            
        // If the average of the student smaller than 4.0 then return type of that student is D.
        } else {
            return "D";
        }
    }
    
    /**
     * Get all the info of student include name, class, average, type.
     * 
     * @return the string that contain all info of student (name, class, average, type).
     */
    public String studentData() {
        
        // Return the string that contain all info of student (name, class, average, type).
        return String.format("Name:%s\nClasses:%s\nAVG:%.1f\nType:%s", name, classes, averageCalculate(), typeCalculate());
    }
}
