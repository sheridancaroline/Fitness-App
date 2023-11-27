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

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FitnessAppMain extends Application {

    private FitnessAppModel theModel;

    private FitnessAppView theView;

    private FitnessAppController theController;

    @Override
    public void init() throws Exception {
        super.init();
        this.theModel = new FitnessAppModel();
        this.theView = new FitnessAppView(theModel);
        this.theController = new FitnessAppController(theModel, theView);

    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Fitness Application");
        primaryStage.setScene(theView.getLoginScene());
        primaryStage.sizeToScene();
        primaryStage.show();
    }

//    private Scene createLoginScene(){
//        return new Scene(this.theView.getLoginRoot());
//    }
//
//    private Scene createSignupScene(){
//        return new Scene(this.theView.getSignupRoot());
//    }
}
