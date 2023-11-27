/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2023
 * Instructor: Prof. Brian King / Prof. Joshua Stough
 *
 * Name: Dong Hyun Roh
 * Section: 9am
 * Date: 11/10/23
 * Time: 1:11 PM
 *
 * Project: csci205_final_project
 * Package: org.team1.fitnessappmvc
 * Class: FitnessAppModel
 *
 * Description:
 *
 * ****************************************
 */
package org.team1.fitnessappmvc;

import org.team1.Activity;
import org.team1.SerializationUtil;
import org.team1.UserInformation;
import org.team1.UserInformation;
import org.team1.Workouts;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class FitnessAppModel {

    public static final String FILE_NAME = "userInformations.ser";

    private ArrayList<UserInformation> userInformations;


    public FitnessAppModel(){

        this.userInformations = deserializeUserInformation();

        System.out.println(userInformations);

//        this.userInformations = new ArrayList<>();
//
//        Workouts day0 = new Workouts(LocalDate.of(2023,12,1), Activity.WALKING,5.5,6,70,900);
//        Workouts day1 = new Workouts(LocalDate.now(), Activity.WALKING,5.5,6,70,900);
//        Workouts day2 = new Workouts(LocalDate.of(2022,12,1), Activity.WALKING,5.5,6,70,900);
//
//        UserInformation userinformation = new UserInformation("rohbot", "1234");
//
//        userinformation.addWorkout(day0);
//        userinformation.addWorkout(day1);
//        userinformation.addWorkout(day2);
//        userInformations.add(userinformation);
//
//        try{
//            SerializationUtil.serialize(userInformations, FILE_NAME);
//            System.out.println("success");
//        }
//        catch (IOException e){
//            e.printStackTrace();
//            return;
//        }

    }

    public ArrayList<UserInformation> deserializeUserInformation(){

        ArrayList<UserInformation> userInformations = null;

        try{
            userInformations = (ArrayList<UserInformation>) SerializationUtil.deserialize(FILE_NAME);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return userInformations;
    }

    public boolean verifyLogin(String username, String password){
        for (int i = 0; i < userInformations.size(); i++){
            System.out.println(userInformations.get(i).getUsername());
            System.out.println(userInformations.get(i).getPassword());
            if (userInformations.get(i).getUsername().equals(username) && userInformations.get(i).getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }




}
