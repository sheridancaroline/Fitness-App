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
import java.util.Date;

public class Workouts implements Serializable {

    private LocalDate date;

    private Activity activity;

    private double speed;

    private double distance;

    private double bodyWeight;

    private double caloriesBurned;

    public Workouts(LocalDate date, Activity activity, double speed, double distance, double bodyWeight, double caloriesBurned){

        this.date = date;
        this.activity = activity;
        this.speed = speed;
        this.distance = distance;
        this.bodyWeight = bodyWeight;
        this.caloriesBurned = caloriesBurned;
    }

    public LocalDate getDate() {
        return date;
    }

    public Activity getActivity() {
        return activity;
    }

    public String toString(){

        String information = String.format("Activity: %s \nSpeed: %.2f \nDistance: %.2f \nBodyWeight: %.2f " +
                "\nCalories Burned: %.2f",  activity, speed, distance, bodyWeight, caloriesBurned);
        return information;
    }

    public static void main(String[] args){
        Workouts day1 = new Workouts(LocalDate.now(), Activity.WALKING,5.5,6,70,900);
        System.out.println(day1);
        System.out.println(day1.date);

        Workouts day2 = new Workouts(LocalDate.of(2022,12,1), Activity.WALKING,5.5,6,70,900);
        System.out.println(day1);
        System.out.println(day2.date);

    }








}
