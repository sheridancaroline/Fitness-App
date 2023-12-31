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
 * Class: ConversionUtil
 *
 * Description: ConversionUtil that provides methods for converting units
 *
 * ****************************************
 */
package org.team1;

/** Conversions used throughout app */
public class ConversionUtil {

    /**
     * Converts speed from miles per hour or kilometers per hour to meters per second
     *
     * @author Amanda
     * @param speed user is going
     * @param unit mph, kph, or m/s
     * @return speed in meters per second
     */
    public static double convertSpeedToMeters(double speed, String unit) {
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

    /**
     * Converts pounds to kilograms
     *
     * @author Amanda
     * @param weight of user
     * @param unit lbs or kg
     * @return weight in kilograms
     */
    public static double convertWeightToKg(double weight, String unit) {
        switch (unit) {
            case "Kilograms(kg)":
                return weight;
            case "Pound (lb)":
                return weight * 0.453592;
            default:
                throw new IllegalArgumentException("Invalid distance unit");
        }
    }

    /**
     * Convert height to meters
     *
     * @author Amanda
     * @param height of user
     * @param unit inches or centimeters
     * @return height in meters
     */
    public static double convertHeightToMeters(double height, String unit) {
        switch (unit) {
            case "inches(in)":
                return height * 0.0254;
            case "centimeters(cm)":
                return height * 0.01;
            default:
                throw new IllegalArgumentException("Invalid distance unit");
        }
    }

    /**
     * Convert from minutes to hours and minutes
     *
     * @author Dong Hyun Roh
     * @param durationInMins the minutes to convert to hours and minutes
     * @return the duration in hours and minutes
     */
    public static int[] convertToHoursAndMinutes(double durationInMins){

        if (durationInMins < 0) {
            throw new IllegalArgumentException("Duration cannot be negative");
        }

        double hours = durationInMins / 60; // Calculate total hours
        int wholeHours = (int) hours; // Extract the whole number of hours
        int remainingMinutes = (int) Math.round((hours - wholeHours) * 60); // Calculate remaining minutes

        return new int[]{wholeHours, remainingMinutes};
    }
}

