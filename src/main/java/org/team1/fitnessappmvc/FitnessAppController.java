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
 * Description:
 *
 * ****************************************
 */
package org.team1.fitnessappmvc;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 * This is the MVC controller class for our fitness application
 */
public class FitnessAppController {

    private Stage stage;

    private FitnessAppModel theModel;

    private FitnessAppView theView;

    /**
     * Construct a controller that connects the model and the view for our
     * fitness application
     *
     * @param theModel
     * @param theView
     */
    public FitnessAppController(FitnessAppModel theModel, FitnessAppView theView){
        this.theModel = theModel;
        this.theView = theView;

        initEventHandlers();
        initBindings();
    }



    private void initBindings() {
    }

    private void initEventHandlers() {
        handleSceneChange();

        this.theView.getBtnLogin().setOnAction(event -> {

            if (theView.getTextFieldUsername().isEmpty()){

                System.out.println("enter username");
            }
            if (theView.getTextFieldPassword().isEmpty()){
                System.out.println("enter password");
            }
            else{
                if (theModel.verifyLogin(theView.getTextFieldUsername(), theView.getTextFieldPassword())){
                    System.out.println("Login success");
                }
                else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Login Unsuccessful");
                    alert.setHeaderText("Login failed");
                    alert.setContentText("Make sure your username and password are correct");
                    alert.show();
                }
            }
        });

        this.theView.getBtnVerifyUsername().setOnAction(event -> {
            if (theView.getTextFieldUsername2().isEmpty()){
                System.out.println("Please enter a username");
            }
            else if (theModel.verifyUsername(theView.getTextFieldUsername2())) {
                System.out.println("You can use this name");
                theView.getBtnCreateNewAccount().setDisable(false);
            }
            else{
                System.out.println("This username is already being used");
            }
        });

        this.theView.getBtnCreateNewAccount().setOnAction(event -> {

            if (theView.getTextFieldPassword2().isEmpty() || theView.getTextFieldConfirmPassword().isEmpty()){
                System.out.println("Make sure to confirm ur password");
            }
            else if (theView.getTextFieldPassword2().equals(theView.getTextFieldConfirmPassword())){
                theModel.createNewAccount(theView.getTextFieldUsername2(), theView.getTextFieldPassword2());
                System.out.println("Created a new account");
            }
            else {
                System.out.println("Your password does not match");
            }
        });

    }


    private void handleSceneChange() {

        this.theView.getBtnSignup().setOnAction(event -> {

            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(theView.getSignupScene());
            stage.show();


        });
    }
}

