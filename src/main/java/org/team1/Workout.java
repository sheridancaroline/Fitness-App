/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2023
 * Instructor: Prof. Brian King / Prof. Joshua Stough
 *
 * Name: Caroline Sheridan
 * Section: 9 AM
 * Date: 11/14/23
 * Time: 1:13 PM
 *
 * Project: csci205_final_project
 * Package: org.team1
 * Class: Workout
 *
 * Description:
 *
 * ****************************************
 */
package org.team1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Workout {
    public WorkoutType workoutType;

    public Date date;

    public int caloriesBurned;

    public int minutesDuration;

    public int secondsDuration;

    public Workout(WorkoutType workoutType, Date date, int caloriesBurned, int minutesDuration, int secondsDuration) {
        this.workoutType = workoutType;
        this.date = date;
        this.caloriesBurned = caloriesBurned;
        this.minutesDuration = minutesDuration;
        this.secondsDuration = secondsDuration;
    }

    public WorkoutType getWorkoutType() {
        return workoutType;
    }

    public Date getDate() {
        return date;
    }

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    public int getMinutesDuration() {
        return minutesDuration;
    }

    public int getSecondsDuration() {
        return secondsDuration;
    }

    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // Format the workout information
        String formattedDate = dateFormat.format(date);
        String formattedType = workoutType.toString();
        String formattedDuration = String.format("%d:%02d", minutesDuration, secondsDuration);
        String formattedCalories = Integer.toString(caloriesBurned);

        return formattedDate + ", " + formattedType + ", " + formattedDuration + ", " + formattedCalories;
    }
}



