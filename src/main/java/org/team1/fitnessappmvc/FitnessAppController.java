/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2023
 * Instructor: Prof. Brian King / Prof. Joshua Stough
 *
 * Name: Dong Hyun Roh
 * Section: 9am
 * Date: 11/10/23
 * Time: 1:10 PM
 *
 * Project: csci205_final_project
 * Package: org.team1.fitnessappmvc
 * Class: FitnessAppController
 *
 * Description: This is the MVC controller class for
 * our fitness application
 *
 * ****************************************
 */
package org.team1.fitnessappmvc;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.stage.Stage;


/**
 * The MVC controller class for our fitness application. It is responsible for
 * managing user interactions and connecting the model and view for the fitness
 * application.
 */
public class FitnessAppController {

    private Stage stage;

    /** The model component of the application */
    private FitnessAppModel theModel;

    /** The view component of the application */
    private FitnessAppView theView;

    /**
     * Constructs a controller that connects the model and the
     * view for the fitness application.
     *
     * @param theModel The model component of the application.
     * @param theView  The view component of the application.
     */
    public FitnessAppController(FitnessAppModel theModel, FitnessAppView theView){
        this.theModel = theModel;
        this.theView = theView;

        // Initialize event handlers and bindings upon controller creation.
        initEventHandlers();
        initBindings();
    }


    private void initBindings() {
    }


    /**
     * Initializes event handlers for login, signup, and scene change actions.
     */
    private void initEventHandlers() {

        // Sets up handling for scene changes.
        handleSceneChange();

        // Sets up handling for login-related events.
        loginEventHandlers();

        // Sets up handling for signup-related events.
        signupEventHandlers();
    }


    /**
     * Sets up event handlers for components in the login page
     */
    private void loginEventHandlers() {

        // Action on login button click
        this.theView.getBtnLogin().setOnAction(event -> {

            // Check if username is empty
            if (theView.getTextFieldUsername().isEmpty()){
                System.out.println("enter username");
            }
            // Check if password is empty
            if (theView.getTextFieldPassword().isEmpty()){
                System.out.println("enter password");
            }
            else{
                // Verify login credentials
                if (theModel.verifyLogin(theView.getTextFieldUsername(), theView.getTextFieldPassword())){
                    System.out.println("Login success");
                }
                // Display an error alert when login verification fails.
                else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Login Unsuccessful");
                    alert.setHeaderText("Login failed");
                    alert.setContentText("Make sure your username and password are correct");
                    alert.show();
                }
            }
        });
    }


    /**
     * Sets up event handlers for signup-related actions.
     */
    private void signupEventHandlers() {

        // Action on verify username button click
        this.theView.getBtnVerifyUsername().setOnAction(event -> {

            // Check if username is empty
            if (theView.getTextFieldUsername2().isEmpty()){
                System.out.println("Please enter a username");
            }
            // Verify username availability
            else if (theModel.verifyUsername(theView.getTextFieldUsername2())) {
                System.out.println("You can use this name");
                theView.getBtnCreateNewAccount().setDisable(false);
            }
            // Cannot use the username
            else{
                System.out.println("This username is already being used");
            }
        });


        // Action on create new account button click
        this.theView.getBtnCreateNewAccount().setOnAction(event -> {

            // Check if passwords are empty or mismatched
            if (theView.getTextFieldPassword2().isEmpty() || theView.getTextFieldConfirmPassword().isEmpty()){
                System.out.println("Make sure to confirm ur password");
            }
            else if (!theView.getTextFieldPassword2().equals(theView.getTextFieldConfirmPassword())){
                System.out.println("Your password does not match");
            }
            // Create a new account with provided username and password
            else {
                theModel.createNewAccount(theView.getTextFieldUsername2(), theView.getTextFieldPassword2());
                System.out.println("Created a new account");
            }
        });
    }


    /**
     * Handles various scene changes
     */
    private void handleSceneChange() {

        this.theView.getBtnSignup().setOnAction(event -> {

            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(theView.getSignupScene());
            stage.show();

        });
    }
}
