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
        //System.out.println("model set");
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

    private Scene createLoginScene(){
        return new Scene(this.theView.getLoginRoot());
    }

    private Scene createSignupScene(){
        return new Scene(this.theView.getSignupRoot());
    }
}
