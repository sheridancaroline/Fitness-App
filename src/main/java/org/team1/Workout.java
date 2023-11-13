/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2023
 * Instructor: Prof. Brian King / Prof. Joshua Stough
 *
 * Name: Donovan Coleman
 * Section: 10:00 am
 * Date: 11/10/23
 * Time: 10:15 AM
 *
 * Project: csci205_final_project
 * Package: org.team1
 * Class: Workout
 *
 * Description:
 *
 * ****************************************
 */
package org.team1;

import java.util.ArrayList;
import java.util.List;

public class Workout {

    Workout(String type, int calories, String date, String time ){

    }
    public static List <Workout> workouts = new ArrayList<>();

    public void addWorkout(Workout activity){
        workouts.add(activity);
    }

}