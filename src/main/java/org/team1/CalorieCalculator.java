/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2023
 * Instructor: Prof. Brian King / Prof. Joshua Stough
 *
 * Name: Caroline Sheridan
 * Section: 9 AM
 * Date: 11/14/23
 * Time: 2:36 PM
 *
 * Project: csci205_final_project
 * Package: org.team1
 * Class: CalorieCalculator
 *
 * Description:
 *
 * ****************************************
 */
package org.team1;

public class CalorieCalculator {
    private static final double CALORIES_PER_MIN_RUNNING_MALE = 10.0;
    private static final double CALORIES_PER_MIN_RUNNING_FEMALE = 8.5;

    private static final double CALORIES_PER_MIN_WALKING_MALE = 5.0;
    private static final double CALORIES_PER_MIN_WALKING_FEMALE = 4.0;

    private static final double DEFAULT_WEIGHT = 150.0;

    public static int calculateCalories(WorkoutType workoutType, char sex, double weight, int minutes, int seconds) {
        // Use default weight if weight is not provided
        if (weight <= 0) {
            weight = DEFAULT_WEIGHT;
        }

        double caloriesPerMinute;

        // Determine calories per minute based on workout type and sex

        if (workoutType == WorkoutType.RUN) {
            caloriesPerMinute = (sex == 'M') ? CALORIES_PER_MIN_RUNNING_MALE : CALORIES_PER_MIN_RUNNING_FEMALE;
        } else if (workoutType == WorkoutType.WALK) {
            caloriesPerMinute = (sex == 'M') ? CALORIES_PER_MIN_WALKING_MALE : CALORIES_PER_MIN_WALKING_FEMALE;
        } else {
            throw new IllegalArgumentException("Invalid workout type");
        }

        // Calculate total calories burned
        double totalCalories = (minutes + seconds / 60.0) * caloriesPerMinute * (weight/DEFAULT_WEIGHT);

        return (int) totalCalories;
    }
}

