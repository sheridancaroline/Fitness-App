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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Workout {
    public WorkoutType workoutType;

    public LocalDate date;

    public int caloriesBurned;

    public int minutesDuration;

    public int secondsDuration;

    /**
     * Create an instance of a workout
     * @param workoutType walk or run
     * @param date the date of the workout
     * @param caloriesBurned the calories burned during the workout
     * @param minutesDuration the minutes spent doing the workout
     * @param secondsDuration the seconds spent doing the workout
     */

    public Workout(WorkoutType workoutType, LocalDate date, int caloriesBurned, int minutesDuration, int secondsDuration) {
        this.workoutType = workoutType;
        this.date = date;
        this.caloriesBurned = caloriesBurned;
        this.minutesDuration = minutesDuration;
        this.secondsDuration = secondsDuration;
    }

    public WorkoutType getWorkoutType() {
        return workoutType;
    }

    public LocalDate getDate() {
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

    /**
     * The string representation of the workout object
     * @return String workout
     */
    public String toString() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        // Format the workout information
        String formattedDate = dateFormat.format(date);
        String formattedType = workoutType.toString();
        String formattedDuration = String.format("%d:%02d", minutesDuration, secondsDuration);
        String formattedCalories = Integer.toString(caloriesBurned);

        return "[" + formattedDate + ", " + formattedType + ", " + formattedDuration + ", " + formattedCalories + "]";
    }
}



