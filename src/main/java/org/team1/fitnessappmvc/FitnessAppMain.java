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
 * Description: Class file to present fitness application
 *
 * ****************************************
 */
package org.team1.fitnessappmvc;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


/**
 * The main class of the Fitness Application. Extends the JavaFX Application
 * class and serves as the entry point for the application.
 */
public class FitnessAppMain extends Application {

    /** The model component of the application */
    private FitnessAppModel theModel;

    /** The view component of the application */
    private FitnessAppView theView;

    /** The controller component of the application */
    private FitnessAppController theController;


    /**
     * Initializes the model, view, and controller when the application starts.
     *
     * @throws Exception if an error occurs during initialization.
     */
    @Override
    public void init() throws Exception {
        super.init();
        this.theModel = new FitnessAppModel();
        this.theView = new FitnessAppView(theModel);
        this.theController = new FitnessAppController(theModel, theView);
    }


    /**
     * Our standard main program for a JavaFX application
     *
     * @param args command line args
     */
    public static void main(String[] args) {
        launch(args);
    }


    /**
     * The entry point for the JavaFX application.
     * Starts the application by setting up the primary stage.
     *
     * @param primaryStage The primary stage of the application.
     */
    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Fitness Application");

        // Start the application by displaying login page
        BorderPane root = theView.getLoginRoot();
        root.setTop(theView.getMenuBar());
        primaryStage.setScene(new Scene(root,650, 450));
        primaryStage.sizeToScene();
        primaryStage.show();
    }
}
