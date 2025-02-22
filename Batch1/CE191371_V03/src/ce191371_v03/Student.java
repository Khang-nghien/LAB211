/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191371_v03;

/**
 * V03 - Grade Student
 *
 * This class to store data of student.
 *
 * @author Vu Minh Khang - CE191371 - 12/1/2025
 */
public class Student {

    // Create all field and set it to private.
    // The wieght field is using for showing the percentage of the score.
    // The score field is using for showing the score that student get.
    // The totalWeight field is using for checking if the total weight of each part of the score is 100 and calculating the percent of that student compared to the score.
    // The totalAssignmentScore field is using for calculating the total of all assignment of that student.
    // The maxAssignmentScore field is using for calculating the percent of that student have of all the assignment.
    // The sectionsScore field is using for calculating the sections score.
    private int weight;
    private int score;
    private int totalWeight;
    private int totalAssignmentScore;
    private int maxAssignmentScore;
    private int sectionsScore;

    /**
     * Create Constructor with none parameters.
     */
    public Student() {
    }

    /**
     * Getter for the weight.
     *
     * @return the weight.
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Setter for the weight.
     *
     * @param weight.
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Getter for the score.
     *
     * @return the score.
     */
    public int getScore() {
        return score;
    }

    /**
     * Setter for the score.
     *
     * @param score.
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Getter for the total weight.
     *
     * @return the total weight.
     */
    public int getTotalWeight() {
        return totalWeight;
    }

    /**
     * Setter for the total weight.
     *
     * @param totalWeight.
     */
    public void setTotalWeight(int totalWeight) {
        this.totalWeight = totalWeight;
    }

    /**
     * Getter for the total assignment score.
     *
     * @return the total assignment score.
     */
    public int getTotalAssignmentScore() {
        return totalAssignmentScore;
    }

    /**
     * Setter for the total assignment score.
     *
     * @param totalAssignmentScore.
     */
    public void setTotalAssignmentScore(int totalAssignmentScore) {
        this.totalAssignmentScore = totalAssignmentScore;
    }

    /**
     * Getter for the max assignment score.
     *
     * @return the max assignment score.
     */
    public int getMaxAssignmentScore() {
        return maxAssignmentScore;
    }

    /**
     * Setter for the max assignment score
     *
     * @param maxAssignmentScore.
     */
    public void setMaxAssignmentScore(int maxAssignmentScore) {
        this.maxAssignmentScore = maxAssignmentScore;
    }

    /**
     * Getter for the sections score.
     *
     * @return the sections score.
     */
    public int getSectionsScore() {
        return sectionsScore;
    }

    /**
     * Setter for the sections score.
     *
     * @param sectionsScore.
     */
    public void setSectionsScore(int sectionsScore) {
        this.sectionsScore = sectionsScore;
    }

    /**
     * Calculating the weight score.
     *
     * @return the weight score.
     */
    public double calculateWeightScore() {

        // Return the value of weight score with a fomula.
        // Weight score = student score divide to 100 then multiply it with weight.
        return (score / 100.0) * weight;
    }

    /**
     * Calculating the homework weight score.
     *
     * @return the weight score.
     */
    public double calculateHomeworkWeightScore() {

        // Return the value of homework weight score with a formula 
        // Homework score = total homework student score divide to max total homework score then multiply it with weight.
        return ((double) (totalAssignmentScore + sectionsScore) / (maxAssignmentScore  + 30.0)) * weight;
    }
}
