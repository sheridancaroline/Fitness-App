package org.team1.CalorieCalculator;

import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.stage.Stage;
import org.team1.User;
import org.team1.WorkoutType;

public class CalorieCalculatorModel {
    private static final double CALORIES_PER_MIN_RUNNING_MALE = 10.0;
    private static final double CALORIES_PER_MIN_RUNNING_FEMALE = 8.5;

    private static final double CALORIES_PER_MIN_WALKING_MALE = 5.0;
    private static final double CALORIES_PER_MIN_WALKING_FEMALE = 4.0;

    private static final double DEFAULT_WEIGHT = 150.0;

    public static double calculateCalories(WorkoutType workoutType, double speedPace, String speedPaceUnit, double distance, String distanceUnit, double bodyWeight){
        // sex, double weight, int minutes, int seconds)

        // Use default weight if weight is not provided
//        if (weight <= 0) {
//            weight = DEFAULT_WEIGHT;
//        }
//
//        double caloriesPerMinute;

        // Determine calories per minute based on workout type and sex
//        if (workoutType == WorkoutType.RUN) {
//            caloriesPerMinute = (sex == 'M') ? CALORIES_PER_MIN_RUNNING_MALE : CALORIES_PER_MIN_RUNNING_FEMALE;
//        } else if (workoutType == WorkoutType.WALK) {
//            caloriesPerMinute = (sex == 'M') ? CALORIES_PER_MIN_WALKING_MALE : CALORIES_PER_MIN_WALKING_FEMALE;
//        } else {
//            throw new IllegalArgumentException("Invalid workout type");
//        }

        // Calculate total calories burned[for now we assume sex = male]
        // TODO determine calories per minute based on sex
        //double totalCalories = (minutes + seconds / 60.0) * CALORIES_PER_MIN_RUNNING_MALE * (weight/DEFAULT_WEIGHT);

        //return (int) totalCalories;
        return 0.0;
    }

    }

