/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2023
 * Instructor: Prof. Brian King / Prof. Joshua Stough
 *
 * Name: Dong Hyun Roh
 * Section: 9am
 * Date: 11/12/23
 * Time: 1:21 PM
 *
 * Project: csci205_final_project
 * Package: org.team1
 * Class: User
 *
 * Description: UserInformation class that captures various information of the user, including
 * username, password, gender, weight ...
 *
 * ****************************************
 */
package org.team1;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Represents user information including username, password, gender, and past
 * workouts. Implements Serializable to enable object serialization.
 */
public class UserInformation implements Serializable {

    /** SerialVersionUID used as an identifier of the userInformation class */
    private static final long serialVersionUID = 101;

    /** Username */
    private String username;

    /** Password */
    private String password;

    /** Gender */
    private Gender gender;

    /** Weight */
    private double weight;

    /** Height */
    private double height;

    /** Past workouts sorted by the date */
    private TreeMap<LocalDate, ArrayList<Workout>> pastWorkouts;


    /**
     * Constructor for UserInformation class.
     *
     * @param username user's username
     * @param password user's password
     * @param gender user's gender
     * @param weightInKg user's weight
     * @param heightInCm user's height
     */
    public UserInformation(String username, String password, Gender gender, double weightInKg, double heightInCm){
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.weight = weightInKg;
        this.height = heightInCm;
        this.pastWorkouts = new TreeMap<>();
    }

    /**
     * @return {@code username} of the user
     */
    public String getUsername() { return username; }

    /**
     * @return {@code password} of the user
     */
    public String getPassword() { return password; }

    /**
     * @return {@code weight} of the user
     */
    public double getWeight() { return weight; }

    /**
     * @return {@code height} of the user
     */
    public double getHeight() { return height; }

    public TreeMap<LocalDate, ArrayList<Workout>> getPastWorkouts() { return pastWorkouts; }


    /**
     * Given a workout object, add it to {@code pastWorkouts}
     *
     * @param workout to be added
     */
    public void addWorkout(Workout workout){

        LocalDate workoutDate = workout.getDate();

        // Check if pastWorkouts already contains the workout date
        if (pastWorkouts.containsKey(workoutDate)){

            // If the date exists, retrieve the list of workouts for that date and add the new workout to it
            pastWorkouts.get(workoutDate).add(workout);
        }
        else {
            // If the date doesn't exist in pastWorkouts, create a new ArrayList for workouts,
            // add the current workout to it, and put this new list into the pastWorkouts map
            ArrayList<Workout> newWorkoutList = new ArrayList<>();
            newWorkoutList.add(workout);
            pastWorkouts.put(workoutDate, newWorkoutList);
        }
    }


    public String toString(){
        String information = String.format("Username: %s \nPassword: %s \nSex: %s \n Height: %s \nPast Workouts: %s "
                ,  username, password, gender, height, pastWorkouts);
        return information;
    }

}
