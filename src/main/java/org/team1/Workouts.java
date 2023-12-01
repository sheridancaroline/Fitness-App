package org.team1;

import java.io.Serializable;
import java.time.LocalDate;

public class Workouts implements Serializable {

    private LocalDate date;

    private WorkoutType activity;

    private double speed;

    private double distance;

    private double bodyWeight;

    private double caloriesBurned;

    public Workouts(LocalDate date, WorkoutType activity, double speed, double distance, double bodyWeight, double caloriesBurned){

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

    public WorkoutType getActivity() {
        return activity;
    }

    public String toString(){

        String information = String.format("Activity: %s \nSpeed: %.2f \nDistance: %.2f \nBodyWeight: %.2f " +
                "\nCalories Burned: %.2f",  activity, speed, distance, bodyWeight, caloriesBurned);
        return information;
    }

    public static void main(String[] args){
        Workouts day1 = new Workouts(LocalDate.now(), WorkoutType.WALKING,5.5,6,70,900);
        System.out.println(day1);
        System.out.println(day1.date);

        Workouts day2 = new Workouts(LocalDate.of(2022,12,1), WorkoutType.WALKING,5.5,6,70,900);
        System.out.println(day1);
        System.out.println(day2.date);

    }

}

