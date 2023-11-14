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


public class UserInformation implements Serializable {

    private String username;

    private String password;

    private TreeMap<LocalDate, ArrayList<Workouts>> pastWorkouts;

    public UserInformation(String username, String password){
        this.username = username;
        this.password = password;
        this.pastWorkouts = new TreeMap<>();

    }

    public void addWorkout(Workouts workout){

        LocalDate workoutDate = workout.getDate();

        if (pastWorkouts.containsKey(workoutDate)){
            pastWorkouts.get(workoutDate).add(workout);
        }
        else {
            ArrayList<Workouts> newWorkoutList = new ArrayList<>();
            newWorkoutList.add(workout);
            pastWorkouts.put(workoutDate, newWorkoutList);
        }
    }

    public String toString(){
        String information = String.format("Username: %s \nPassword: %s \nPast Workouts: %s :"
                ,  username, password, pastWorkouts);
        return information;
    }

    public static void main(String[] args){

        Workouts day0 = new Workouts(LocalDate.of(2023,12,1), Activity.WALKING,5.5,6,70,900);
        System.out.println(day0);

        Workouts day1 = new Workouts(LocalDate.now(), Activity.WALKING,5.5,6,70,900);
        System.out.println(day1);

        Workouts day2 = new Workouts(LocalDate.of(2022,12,1), Activity.WALKING,5.5,6,70,900);
        System.out.println(day2);


        UserInformation userinformation = new UserInformation("rohbot", "1234");

        userinformation.addWorkout(day0);
        userinformation.addWorkout(day1);
        userinformation.addWorkout(day2);


        System.out.println(userinformation);


    }



}
