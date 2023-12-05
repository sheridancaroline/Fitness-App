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
 * Description:
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

    /** */
    private static final long serialVersionUID = 101;

    /** Instantiate username for login*/
    private String username;

    /** Instantiate password for login*/
    private String password;

    /** Instantiate user gender */
    private Gender gender;

    /** Instantiate user weight */
    private double weight;

    /** Instantiate user height */
    private double height;

    /** Instantiate past workouts to be stored */
    private TreeMap<LocalDate, ArrayList<Workout>> pastWorkouts;


    /**
     * Constructor for UserInformation class.
     *
     * @param username user's username
     * @param password user's password
     * @param gender user's gender
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
    public String getUsername() {
        return username;
    }

    /**
     * @return {@code password} of the user
     */
    public String getPassword() {
        return password;
    }

    public double getWeight() { return weight; }

    public double getHeight() { return height; }

    public TreeMap<LocalDate, ArrayList<Workout>> getPastWorkouts() {
        return pastWorkouts;
    }


    /**
     * Add workout to the list of past workouts to be stored
     * @param workout the workout to be added
     */
    public void addWorkout(Workout workout){

        LocalDate workoutDate = workout.getDate();

        if (pastWorkouts.containsKey(workoutDate)){
            pastWorkouts.get(workoutDate).add(workout);
        }
        else {
            ArrayList<Workout> newWorkoutList = new ArrayList<>();
            newWorkoutList.add(workout);
            pastWorkouts.put(workoutDate, newWorkoutList);
        }
    }


    /**
     * Creates String representation of the user information
     * @return the String representation
     */
    public String toString(){
        String information = String.format("Username: %s \nPassword: %s \nSex: %s \n Height: %s \nPast Workouts: %s "
                ,  username, password, gender, height, pastWorkouts);
        return information;
    }

}
