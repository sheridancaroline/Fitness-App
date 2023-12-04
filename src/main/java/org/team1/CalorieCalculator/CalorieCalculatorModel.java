package org.team1.CalorieCalculator;

import org.team1.Gender;
import org.team1.User;
import org.team1.WorkoutType;

//import org.team1.CalorieCalculator.ConversionUtil;

/**
 * @author Amanda Agambire
 * helper class to calculate calories
 */
public class CalorieCalculatorModel {
    //private ConversionUtil conversionUtil = new ConversionUtil() ;
    public static double calculateCalories(double hours, double minutes, double speedPace, String speedPaceUnit, double weight, String weightUnit, double height, String heightUnit) {
        return CalorieCalculator.calculateCalories( hours, minutes, speedPace, speedPaceUnit, weight, weightUnit, height, heightUnit);

    }







}


