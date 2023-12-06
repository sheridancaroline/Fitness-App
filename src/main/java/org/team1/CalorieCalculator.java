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
 * Description: Calorie Calculator class that computes calories burnt
 * based on the parameters provided
 *
 * ****************************************
 */
package org.team1;


public class CalorieCalculator {

    /**
     * Calulate the user's calories burnt based on their input
     *
     * @author Amanda and Grace
     * @see <a href = "https://www.womanandhome.com/health-wellbeing/fitness/calories-burned-walking/">
     *     https://www.womanandhome.com/health-wellbeing/fitness/calories-burned-walking/ </a>
     */
    public static double calculateCalories(double durationInMins, double speedMeterPerSecond,
                                           double weightInKg, double heightInMeter) {

        // Calculate calories burned per minute
        double caloriesPerMin = ((0.035 * weightInKg) + (Math.pow(speedMeterPerSecond, 2))
                / heightInMeter) * (0.029) * (weightInKg);

        // Calculate and return the total calories burned
        return Math.round(caloriesPerMin * durationInMins);

    }
}

