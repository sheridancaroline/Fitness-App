/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2023
 * Instructor: Prof. Brian King / Prof. Joshua Stough
 *
 * Name: Caroline Sheridan
 * Section: 9 AM
 * Date: 11/14/23
 * Time: 3:12 PM
 *
 * Project: csci205_final_project
 * Package: org.team1
 * Class: User
 *
 * Description:
 *
 * ****************************************
 */
package org.team1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
    public char sex; // 'M' or 'F'
    public double weight; // in pounds
    private List<Double> weightHistory;

    private List<Date> weightDates;

    public User(char sex, double weight) {
        this.sex = sex;
        this.weight = weight;
        this.weightHistory = new ArrayList<>();
        this.weightDates = new ArrayList<>();
        this.weightHistory.add(weight); // Initial weight
        this.weightDates.add(new Date()); // Initial date
    }

    public char getSex() {
        return sex;
    }

    public double getWeight() {
        return weight;
    }

    public List<Double> getWeightHistory() {
        return new ArrayList<>(weightHistory); // Return a copy to prevent external modification
    }

    public List<Date> getWeightDates() {
        return new ArrayList<>(weightDates); // Return copy
    }

    public void updateWeight(double newWeight) {
        this.weight = newWeight;
        this.weightHistory.add(newWeight);
        this.weightDates.add(new Date());
    }
}

