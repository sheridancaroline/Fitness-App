package org.team1.calendar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.team1.fitnessappmvc.FitnessAppModel;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {


        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/calendar/Calendar.fxml"));
        Parent root = loader.load();

        // Set up the stage and show it
        primaryStage.setTitle("Hello FXML");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
