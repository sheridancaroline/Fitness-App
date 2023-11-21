package org.team1.CalorieCalculator;

import org.team1.Sex;
import org.team1.User;
import org.team1.WorkoutType;

public class CalorieCalculatorModel {
    private static final double CALORIES_PER_MIN_RUNNING_MALE = 10.0;
    private static final double CALORIES_PER_MIN_RUNNING_FEMALE = 8.5;
    private static final double CALORIES_PER_MIN_WALKING_MALE = 5.0;
    private static final double CALORIES_PER_MIN_WALKING_FEMALE = 4.0;
    private static final double CALORIES_PER_MIN_SPRINTING = 12.0;

    private static final double DEFAULT_WEIGHT = 150.0;

    public static double calculateCalories(User user, WorkoutType workoutType, double hours,double minutes, double speedPace, String speedPaceUnit, double distance, String distanceUnit) {
        // Validate inputs
        //validateInputs(user, workoutType, hours, minutes, speedPace, speedPaceUnit, distance, distanceUnit);

        // Use default weight if weight is not provided
        double weight = (user.getWeight() <= 0) ? DEFAULT_WEIGHT : user.getWeight();

        // Determine calories per minute based on workout type and sex
        double caloriesPerMinute = getCaloriesPerMinute(user, workoutType);

        // Calculate total calories burned
        double totalCalories = calculateTotalCalories(hours, minutes, caloriesPerMinute, weight);

        return totalCalories;

        }

    private static double getCaloriesPerMinute(User user, WorkoutType workoutType) {
        switch (workoutType) {
            case RUNNING:
                return (user.getSex() == Sex.MALE) ? CALORIES_PER_MIN_RUNNING_MALE : CALORIES_PER_MIN_RUNNING_FEMALE;
            case WALKING:
                return (user.getSex() == Sex.MALE) ? CALORIES_PER_MIN_WALKING_MALE : CALORIES_PER_MIN_WALKING_FEMALE;
            case SPRINTING:
                return CALORIES_PER_MIN_SPRINTING;
            default:
                throw new IllegalArgumentException("Invalid workout type");
        }
    }
    private static double calculateTotalCalories(double hours, double minutes, double caloriesPerMinute, double weight) {
        return (hours * 60.0 + minutes) * caloriesPerMinute * (weight / DEFAULT_WEIGHT);
    }

    }


