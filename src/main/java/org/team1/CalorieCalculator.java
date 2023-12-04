/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2023
 * Instructor: Prof. Brian King / Prof. Joshua Stough
 *
 * Name: Amanda
 * Section: 9am
 * Date: 11/30/23
 * Time: 3:59 PM
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

/**
 * Calulate the user's calories burnt based on their input
 * @see <a href = "https://www.womanandhome.com/health-wellbeing/fitness/calories-burned-walking/">
 *     https://www.womanandhome.com/health-wellbeing/fitness/calories-burned-walking/ </a>
 */
public class CalorieCalculator {
    public static double calculateCalories(double hours, double minutes, double speedPace, String speedPaceUnit, double weight, String weightUnit, double height, String heightUnit) {

        double weightInKg =  ConversionUtil.convertWeightToKg(weight, weightUnit);
        double speedMeters = ConversionUtil.convertSpeedToMeters(speedPace, speedPaceUnit);
        double heightMeters = ConversionUtil.convertHeightToMeters(height, heightUnit);
        double workoutDuration = minutes + (hours * 60);

        double caloriesPerMin = ((0.035 * weightInKg) + (Math.pow(speedMeters, 2)) / heightMeters) * (0.029) * (weightInKg);
        return caloriesPerMin * workoutDuration;

    }

    public static double calculateCalories(double durationInMins, double speedMeterPerSecond, double weightInKg, double heightInMeter) {

        double caloriesPerMin = ((0.035 * weightInKg) + (Math.pow(speedMeterPerSecond, 2)) / heightInMeter) * (0.029) * (weightInKg);
        return Math.round(caloriesPerMin * durationInMins);

    }
}

