package org.team1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class WorkoutCalendarApp extends Application {
    private static final WorkoutManager workoutManager = new WorkoutManager();
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Workout Calendar");

        DatePicker datePicker = new DatePicker();
        TextArea textArea = new TextArea();

        // Listener for date selection
        datePicker.setOnAction(event -> displayWorkoutsForSelectedDate(datePicker.getValue(), textArea));

        VBox vbox = new VBox(datePicker, textArea);
        Scene scene = new Scene(vbox, 300, 200);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void displayWorkoutsForSelectedDate(LocalDate selectedDate, TextArea textArea) {
        String formattedDate = selectedDate.format(dateFormatter);
        textArea.clear();

        // Fetch and display daily workouts
        textArea.appendText("Daily workouts for " + formattedDate + ":\n");
        workoutManager.getWorkoutsForDay(formattedDate).forEach(workout -> {
            textArea.appendText(workout.toString() + "\n");
        });
    }
}

