/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2023
 * Instructor: Prof. Brian King / Prof. Joshua Stough
 *
 * Name: Donovan Coleman
 * Section: 10:00 am
 * Date: 11/10/23
 * Time: 10:37 AM
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

import java.util.ArrayList;
import java.util.List;

public class User {
    User(String name, int age, double weight, double height, String sex, Workout workouts){

    }
    public List<User> usersList = new ArrayList<>();
    public void addUser(User newUser){
        usersList.add(newUser);

    }
    public void removeUser(User oldUser){
        usersList.remove(oldUser);
    }

    public List<User> showUsers(){
        return usersList;
    }
}
