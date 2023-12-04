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
import java.time.LocalDate;
import java.util.ArrayList;


/**
 * The model class handling user information and login-related
 * functionalities for the fitness application.
 */
public class FitnessAppModel {

    /** The file name used for serialization */
    public static final String FILE_NAME = "userInformations.ser";

    /** A collection of userInformation */
    private ArrayList<UserInformation> userInformations;

    /** UserInformation of the current user using the application */
    private UserInformation userInformation;


    /**
     * This is the model for our fitness application.
     *
     * @author Dong Hyun Roh
     */
    public FitnessAppModel(){

        // deserialize to fetch arraylist of userInformation
        this.userInformations = deserializeUserInformation();

        // Initialize the userInformation of the current user
        this.userInformation = null;
    }

    public UserInformation getUserInformation() {
        return userInformation;
    }




    /**
     * update the current userInformations by serializing it
     */
    public void updateUserInformation(){
        serializeUserInformation(null);
    }


    /**
     * Serializes the provided UserInformation object and appends it to the existing
     * userInformations collection, then saves the updated collection to a file.
     *
     * @author Dong Hyun Roh
     * @param userInformation The UserInformation object to be serialized and added to the collection.
     */
    public void serializeUserInformation(UserInformation userInformation){

        // Add the provided UserInformation object to the userInformations collection
        if (userInformation != null){
            userInformations.add(userInformation);
        }

        try{
            // Serialize the updated userInformations collection to a file using SerializationUtil.serialize
            SerializationUtil.serialize(userInformations, FILE_NAME);
        }
        catch (IOException e){
            // Print the stack trace if an IOException occurs during serialization
            e.printStackTrace();
            return;
        }
    }


    /**
     * Deserialize user information from a file and return the deserialized ArrayList of UserInformation objects.
     *
     * @author Dong Hyun Roh
     * @return An ArrayList containing deserialized UserInformation objects, or null if deserialization fails.
     */
    public ArrayList<UserInformation> deserializeUserInformation(){

        ArrayList<UserInformation> userInformations = null;

        try{
            // Deserialize user information from a file using SerializationUtil.deserialize
            userInformations = (ArrayList<UserInformation>) SerializationUtil.deserialize(FILE_NAME);
        } catch (IOException | ClassNotFoundException e) {

            // Print the stack trace if IOException or ClassNotFoundException occurs during deserialization
            e.printStackTrace();
        }

        return userInformations;
    }


    /**
     * Verifies the login credentials by checking if the provided username and password
     * match any user in the user information records.
     * If the credentials match, sets {@code userInformation} for the current session
     *
     * @author Dong Hyun Roh
     * @param username The username to be verified.
     * @param password The password associated with the username.
     * @return true if the username and password match an existing user, false otherwise.
     */
    public boolean verifyLogin(String username, String password){

        // Iterate through the userInformations collection
        for (int i = 0; i < userInformations.size(); i++){

            // Check if the provided username and password match any existing user's credentials
            if (userInformations.get(i).getUsername().equals(username) &&
                    userInformations.get(i).getPassword().equals(password)){

                // Set the user information for the current session
                this.userInformation = userInformations.get(i);

                // Return true if credentials match
                return true;
            }
        }
        // Return false if credentials don't match any user
        return false;
    }


    /**
     * Verifies if the username already exists during account creation.
     *
     * @author Dong Hyun Roh
     * @param username The username entered by the user.
     * @return true if the username is available, false if it's already taken.
     */
    public boolean verifyUsername(String username){

        // Iterate through the userInformations collection
        for (int i = 0; i < userInformations.size(); i++){

            // Check if the username matches any existing usernames in user information records
            if (userInformations.get(i).getUsername().equals(username)){
                return false;
            }
        }
        return true;
    }


    /**
     * Creates a new user account with the provided details and serializes the
     * updated user information to a file.
     *
     * @author Dong Hyun Roh
     * @param username The username for the new account
     * @param password The password for the new account
     * @param gender The gender of the user
     * @param weight The weight of the user
     * @param height The height of the user
     */
    public void createNewAccount(String username, String password, Gender gender, double weight, double height){

        // Create a new UserInformation object
        UserInformation userinformation = new UserInformation(username, password, gender, weight, height);

        // Add the new user information to the collection of userInformation
        userInformations.add(userinformation);

        // Set the current user information to the newly created one
        userInformation = userinformation;

        // Serialize the userInformations collection
        updateUserInformation();
    }
}
