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
            System.out.println(this.theView.getTextFieldUsername().getText());
            if (theView.getTextFieldUsername().getText().isEmpty()){
                System.out.println("enter username");
            }
            if (theView.getTextFieldPassword().getText().isEmpty()){
                System.out.println("enter password");
            }
            else{
                if (theModel.verifyLogin(theView.getTextFieldUsername().getText(), theView.getTextFieldPassword().getText())){
                    System.out.println("Login success");
                }
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

