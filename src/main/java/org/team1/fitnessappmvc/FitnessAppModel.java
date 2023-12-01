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
 * Description: This is the "model" for our fitness application
 *
 * ****************************************
 */
package org.team1.fitnessappmvc;


import org.team1.*;
import org.team1.UserInformation;
import java.io.IOException;
import java.util.ArrayList;


/**
 * The model class handling user information and login-related
 * functionalities for the fitness application.
 */
public class FitnessAppModel {

    public static final String FILE_NAME = "userInformations.ser";

    private ArrayList<UserInformation> userInformations;

    private UserInformation userInformation;


    /**
     * @author Dong Hyun Roh
     */
    public FitnessAppModel(){

        this.userInformations = deserializeUserInformation();

        this.userInformation = null;

        System.out.println(userInformations);

//        this.userInformations = new ArrayList<>();
//
//        Workouts day0 = new Workouts(LocalDate.of(2023,12,1), Activity.WALKING,5.5,6,70,900);
//        Workouts day1 = new Workouts(LocalDate.now(), Activity.WALKING,5.5,6,70,900);
//        Workouts day2 = new Workouts(LocalDate.of(2022,12,1), Activity.WALKING,5.5,6,70,900);
//
//        UserInformation userinformation = new UserInformation("rohbot", "1234", Gender.MALE);
//
//        userinformation.addWorkout(day0);
//        userinformation.addWorkout(day1);
//        userinformation.addWorkout(day2);
//        userInformations.add(userinformation);

//        serializeUserInformation(userInformations);


    }

    public UserInformation getUserInformation() {
        return userInformation;
    }

    public void serializeUserInformation(UserInformation userInformation){

        userInformations.add(userInformation);

        try{
            SerializationUtil.serialize(userInformations, FILE_NAME);
            System.out.println("success");
        }
        catch (IOException e){
            e.printStackTrace();
            return;
        }
    }


    /**
     * @author Dong Hyun Roh
     *
     * @return
     */
    public ArrayList<UserInformation> deserializeUserInformation(){

        ArrayList<UserInformation> userInformations = null;

        try{
            userInformations = (ArrayList<UserInformation>) SerializationUtil.deserialize(FILE_NAME);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return userInformations;
    }


    /**
     * @author Dong Hyun Roh
     *
     * @param username
     * @param password
     * @return
     */
    public boolean verifyLogin(String username, String password){
        for (int i = 0; i < userInformations.size(); i++){
            if (userInformations.get(i).getUsername().equals(username) && userInformations.get(i).getPassword().equals(password)){
                this.userInformation = userInformations.get(i);
                return true;
            }
        }
        return false;
    }


    /**
     * Verifies if the username already exists during account creation.
     *
     * @author Dong Hyun Roh
     *
     * @param username The username entered by the user.
     * @return true if the username is available, false if it's already taken.
     */
    public boolean verifyUsername(String username){
        for (int i = 0; i < userInformations.size(); i++){
            if (userInformations.get(i).getUsername().equals(username)){
                return false;
            }
        }
        return true;
    }


    /**
     * Creates a new user account with the provided username and password.
     *
     * @author Dong Hyun Roh
     *
     * @param username The username for the new account.
     * @param password The password for the new account.
     * @param gender The gender of the user
     */
    public void createNewAccount(String username, String password, Gender gender){
        UserInformation userinformation = new UserInformation(username, password, gender);
        userInformations.add(userinformation);
        this.userInformation = userinformation;

        try{
            SerializationUtil.serialize(userInformations, FILE_NAME);
            System.out.println("success");
        }
        catch (IOException e){
            e.printStackTrace();
            return;
        }
    }


    /**
     * @author Amanda
     *
     * @param hours
     * @param minutes
     * @param speedPace
     * @param weight
     * @param height
     * @return
     */
    public double calculateCalories(double hours, double minutes, double speedPace, double weight, double height){
        return CalorieCalculator.calculateCalories( hours, minutes, speedPace, weight, height);
    }


}
