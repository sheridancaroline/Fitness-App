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

/**
 * Create a chatbot that takes user input and returns workout suggestions
 */
public class ChatBot {

    /** Average calories burned per mile */
    private static final double CALORIES_BURNED_PER_MILE = 100;

    /** Average walking speed */
    private static final int AVG_WALKING_SPEED = 3;

    /**
     * Method for chatbot to suggest workout based on input
     * @param time the amount of time to exercise daily to achieve goal
     * @param pounds the goal of pounds to be lost
     * @param days the number of days to achieve goal
     * @return the suggested workout
     */
    public static double[] suggestWorkout(double time, double pounds, double days) {

        double calorie = pounds * 3500;
        double suggestedDistance = calorie / CALORIES_BURNED_PER_MILE;
        double suggestedSpeed = suggestedDistance / time;
        double sessionDistance = suggestedDistance / days;

        return new double[]{sessionDistance, suggestedSpeed};
    }

    /**
     * Method to determine whether workout should be a walk or a run
     * @param suggestedSpeed the speed the user is suggested to go
     * @return the chosen workout
     */
    public static String determineWorkoutChoice(double suggestedSpeed){

        String workoutChoice = (suggestedSpeed > AVG_WALKING_SPEED) ? "Running" : "Walking";
        return workoutChoice;

    }

}
