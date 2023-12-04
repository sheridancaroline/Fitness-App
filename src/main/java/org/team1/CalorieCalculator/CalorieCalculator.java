package org.team1.CalorieCalculator;

import org.team1.User;
import org.team1.WorkoutType;

/**
 * @author amandaagambire
 * Calulate the user's calories burnt based on their input
 * @see <a href = "https://www.womanandhome.com/health-wellbeing/fitness/calories-burned-walking/">
 *     https://www.womanandhome.com/health-wellbeing/fitness/calories-burned-walking/ </a>
 */
public class CalorieCalculator {
    public static double calculateCalories(double hours, double minutes, double speedPace, String speedPaceUnit, double weight, String weightUnit , double height, String heightUnit) {
        // Validate inputs
        //validateInputs(user, workoutType, hours, minutes, speedPace, speedPaceUnit, distance, distanceUnit);

        //this.conversionUtil = con

        double weightInKg =  ConversionUtil.convertWeightToKg(weight, weightUnit);

        double speedMeters = ConversionUtil.convertSpeedToMeters(speedPace, speedPaceUnit);
        double heightMeters = ConversionUtil.convertHeightToMeters(height, heightUnit);
        double workoutDuration = minutes + (hours * 60);
        double caloriesPerMin = ((0.035 * weightInKg) + (Math.pow(speedMeters, 2)) / heightMeters) * (0.029) * (weightInKg);

        //round to 2 dp
        return Math.round((caloriesPerMin * workoutDuration) * 100.0) / 100.0;

    }
}
