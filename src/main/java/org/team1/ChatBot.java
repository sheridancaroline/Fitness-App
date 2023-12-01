/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2023
 * Instructor: Prof. Brian King / Prof. Joshua Stough
 *
 * Name: Dong Hyun Roh
 * Section: 9am
 * Date: 11/30/23
 * Time: 6:57 PM
 *
 * Project: csci205_final_project
 * Package: org.team1
 * Class: ChatBot
 *
 * Description:
 *
 * ****************************************
 */
package org.team1;

public class ChatBot {

    private static final double CALORIES_BURNED_PER_MILE = 100;
    private static final int AVG_WALKING_SPEED = 3;

//    private double timeLimit;
//    private double calorieInput;
//    private String workoutChoice;
//    private double timePeriod = 30;

    public static double[] suggestWorkout(double time, double pounds, double days) {

        double calorie = pounds * 3500;
        double suggestedDistance = calorie / CALORIES_BURNED_PER_MILE;
        double suggestedSpeed = suggestedDistance / time;
        double sessionDistance = suggestedDistance / days;

        //String workoutChoice = (suggestedSpeed > AVG_WALKING_SPEED) ? "Running" : "Walking";

        return new double[]{sessionDistance, suggestedSpeed};

    }

    public static String determineWorkoutChoice(double suggestedSpeed){

        String workoutChoice = (suggestedSpeed > AVG_WALKING_SPEED) ? "Running" : "Walking";
        return workoutChoice;

    }

//    public static String printSuggestion(String name, ){
//
//    }







    }
