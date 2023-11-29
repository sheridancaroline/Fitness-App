package org.team1.CalorieCalculator;

import org.team1.Sex;
import org.team1.User;
import org.team1.WorkoutType;

public class CalorieCalculatorModel {


    public static double calculateCalories(User user, WorkoutType workoutType, double hours,double minutes, double speedPace, String speedPaceUnit, double distance, String distanceUnit) {
        // Validate inputs
        //validateInputs(user, workoutType, hours, minutes, speedPace, speedPaceUnit, distance, distanceUnit);

        //in case distance is needed
        double distanceInMiles = convertDistanceToMiles(distance, distanceUnit);

        double speedMeters = convertSpeedToMeters(speedPace, speedPaceUnit);
        double workoutDuration = minutes + (hours * 60);
        double caloriesPerMin = ((0.035 * user.getWeight()) + (Math.pow(speedMeters, 2)) / user.getHeight()) * (0.029) * (user.getWeight());
        return caloriesPerMin * workoutDuration;

    }

    private static double convertSpeedToMeters(double speed, String unit) {
        switch (unit) {
            case "Miles per Hour":
                return speed * 0.44704;
            case "Meters per Second":
                return speed ;
            case "Kilometers per Hour":
                return speed * 0.277778;
            default:
                throw new IllegalArgumentException("Invalid speed unit");
        }
    }

    private static double convertDistanceToMiles(double distance, String unit) {
        switch (unit) {
            case "Miles":
                return distance;
            case "Meters":
                return distance / 1609.34;
            case "Kilometers":
                return distance / 1.60934;
            default:
                throw new IllegalArgumentException("Invalid distance unit");
        }
    }




}


