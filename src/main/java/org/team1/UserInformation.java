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

    private String username;

    private String password;

    private Gender gender;

    private double weight;

    private double height;

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


    public String toString(){
        String information = String.format("Username: %s \nPassword: %s \nSex: %s \n Height: %s \nPast Workouts: %s "
                ,  username, password, gender, height, pastWorkouts);
        return information;
    }

}
