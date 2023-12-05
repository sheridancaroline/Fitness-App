/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2023
 * Instructor: Prof. Brian King / Prof. Joshua Stough
 *
 * Name: Dong Hyun Roh
 * Section: 9am
 * Date: 11/12/23
 * Time: 1:37 PM
 *
 * Project: csci205_final_project
 * Package: org.team1
 * Class: Workouts
 *
 * Description: Workout class that captures various information such as
 * date, workout type, duration...
 *
 * ****************************************
 */
package org.team1;

import java.io.Serializable;
import java.time.LocalDate;

public class Workout implements Serializable {

    /** SerialVersionUID used as an identifier of the workout class */
    private static final long serialVersionUID = 205;

    /** Date on which the workout is done */
    private LocalDate date;

    /** Workout type */
    private WorkoutType workoutType;

    /** Speed */
    private double speed;

    /** Duration */
    private double duration;

    /** Weight of the person doing workout */
    private double bodyWeight;

    /** Calorie burned */
    private double caloriesBurned;

    /**
     * Create a workout object
     *
     * @param date on which the workout is done
     * @param workoutType of the workout
     * @param speed in meter per second
     * @param duration of the workout in minutes
     * @param bodyWeight of the person in kg
     * @param caloriesBurned from the workout
     */
    public Workout(LocalDate date, WorkoutType workoutType, double speed, double duration, double bodyWeight, double caloriesBurned){

        this.date = date;
        this.workoutType = workoutType;
        this.speed = speed;
        this.duration = duration;
        this.bodyWeight = bodyWeight;
        this.caloriesBurned = caloriesBurned;
    }

    public LocalDate getDate() { return date; }

    public WorkoutType getWorkoutType() { return workoutType;}

    public double getCaloriesBurned() {return caloriesBurned;}

    public double getDuration() {return duration; }

    public String toString(){

        int[] durationConverted = ConversionUtil.convertToHoursAndMinutes(duration);

        String information = String.format("Activity: %s \nSpeed: %.2f \nDuration: %d Hours  %d Minutes \nBodyWeight: %.2f " +
                "\nCalories Burned: %.2f", workoutType, speed, durationConverted[0], durationConverted[1], bodyWeight, caloriesBurned);
        return information;
    }

}
