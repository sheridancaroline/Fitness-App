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

public class Workouts implements Serializable {

    private LocalDate date;

    private Activity activity;

    private double speed;

    private double duration;

    private double bodyWeight;

    private double caloriesBurned;

    public Workouts(LocalDate date, Activity activity, double speed, double duration, double bodyWeight, double caloriesBurned){

        this.date = date;
        this.activity = activity;
        this.speed = speed;
        this.duration = duration;
        this.bodyWeight = bodyWeight;
        this.caloriesBurned = caloriesBurned;
    }

    public LocalDate getDate() {
        return date;
    }

    public Activity getWorkoutType() {
        return activity;
    }

    public double getCaloriesBurned() {return caloriesBurned;}

    public double getDuration() {return duration; }

    public String toString(){

        int[] durationConverted = ConversionUtil.convertToHousrAndMinutes(duration);

        String information = String.format("Activity: %s \nSpeed: %.2f \nDuration: %d Hours  %d Minutes \nBodyWeight: %.2f " +
                "\nCalories Burned: %.2f",  activity, speed, durationConverted[0], durationConverted[1], bodyWeight, caloriesBurned);
        return information;
    }

    public static void main(String[] args){
        Workouts day1 = new Workouts(LocalDate.now(), Activity.WALKING,5.5,60,70,900);
        System.out.println(day1);
        System.out.println(day1.date);

        Workouts day2 = new Workouts(LocalDate.of(2022,12,1), Activity.WALKING,5.5,6,70,900);
        System.out.println(day2);
        System.out.println(day2.date);

    }

}
