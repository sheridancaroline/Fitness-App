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
 * Description:
 *
 * ****************************************
 */
package org.team1;

import java.io.Serializable;
import java.time.LocalDate;
import org.team1.CalorieCalculator.ConversionUtil;

public class Workouts implements Serializable {

    private LocalDate date;

    private WorkoutType workoutType;

    private double speed;

    private double duration;

    private double bodyWeight;

    private double caloriesBurned;

    public Workouts(LocalDate date, WorkoutType workoutType, double speed, double duration, double bodyWeight, double caloriesBurned){

        this.date = date;
        this.workoutType = workoutType;
        this.speed = speed; // in m/s
        this.duration = duration; // in mins
        this.bodyWeight = bodyWeight; // in kg
        this.caloriesBurned = caloriesBurned;
    }

    public LocalDate getDate() {
        return date;
    }

    public WorkoutType getWorkoutType() {
        return workoutType;
    }

    public double getCaloriesBurned() {return caloriesBurned;}

    public double getDuration() {return duration; }

    public String toString(){


        int[] durationConverted = ConversionUtil.convertToHousrAndMinutes(duration);

        String information = String.format("Activity: %s \nSpeed: %.2f \nDuration: %d Hours  %d Minutes \nBodyWeight: %.2f " +
                "\nCalories Burned: %.2f", workoutType, speed, durationConverted[0], durationConverted[1], bodyWeight, caloriesBurned);
        return information;
    }

    public static void main(String[] args){
        Workouts day1 = new Workouts(LocalDate.now(), WorkoutType.WALKING,5.5,60,70,900);
        System.out.println(day1);
        System.out.println(day1.date);

        Workouts day2 = new Workouts(LocalDate.of(2022,12,1), WorkoutType.WALKING,5.5,6,70,900);
        System.out.println(day2);
        System.out.println(day2.date);



    }

}
