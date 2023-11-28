package org.team1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class WorkoutCalendarApp extends Application {
    private static final WorkoutManager workoutManager = new WorkoutManager();
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    private static User user;
    private TextArea textArea;

    public static void main(String[] args) {
        user = createUser(); // Create the user object
        launch(args);
    }

    private static User createUser() {
        return new User(Sex.FEMALE, 130);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Workout Calendar");

        DatePicker datePicker = new DatePicker();
        TextArea textArea = new TextArea();

        // Listener for date selection
        datePicker.setOnAction(event -> displayWorkoutsForSelectedDate(datePicker.getValue(), textArea));

        Button addButton = new Button("+");
        addButton.setOnAction(event -> showAddWorkoutDialog(datePicker.getValue()));

        VBox vbox = new VBox(datePicker, textArea);
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(vbox);
        borderPane.setBottom(addButton);
        BorderPane.setMargin(addButton, new Insets(10));

        Scene scene = new Scene(borderPane, 300, 200);


        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showAddWorkoutDialog(LocalDate selectedDate) {
        Dialog<Void> dialog = new Dialog<>();
        dialog.setTitle("Add Workout");

        // Create components for the dialog
        ComboBox<WorkoutType> typeComboBox = new ComboBox<>();
        typeComboBox.getItems().addAll(WorkoutType.values());
        typeComboBox.setPromptText("Select Workout Type");

        Spinner<Integer> minutesSpinner = new Spinner<>(0, 59, 0);
        Spinner<Integer> secondsSpinner = new Spinner<>(0, 59, 0);

        // Layout components in the dialog
        VBox content = new VBox(new Label("Workout Date: " + selectedDate.format(dateFormatter)),
                typeComboBox,
                new Label("Duration:"),
                new HBox(new Label("Minutes:"), minutesSpinner, new Label("Seconds:"), secondsSpinner));

        dialog.getDialogPane().setContent(content);

        // Add buttons to the dialog
        ButtonType addButton = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(addButton, ButtonType.CANCEL);

        // Handle button actions
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == addButton) {
                // Add the workout to the manager
                WorkoutType selectedType = typeComboBox.getValue();
                int minutes = minutesSpinner.getValue();
                int seconds = secondsSpinner.getValue();
                int calculatedCalories = CalorieCalculator.calculateCalories(selectedType, user.getSex(), user.getWeight(), minutes, seconds);
                Workout newWorkout = new Workout(selectedType, selectedDate, calculatedCalories, minutes, seconds);
                workoutManager.addWorkout(newWorkout);

                // Update the display
                displayWorkoutsForSelectedDate(selectedDate, textArea);
            }
            return null;
        });

        dialog.showAndWait();
    }

    private void displayWorkoutsForSelectedDate(LocalDate selectedDate, TextArea textArea) {
        String formattedDate = selectedDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        textArea.clear();

        // Fetch and display daily workouts
        textArea.appendText("Workouts:\n");

        // Get the workouts for the selected date
        List<Workout> workouts = workoutManager.getWorkoutsForDay(formattedDate);

        // Display each workout in a formatted block
        for (Workout workout : workouts) {
            String workoutBlock = String.format("%-12s %-15s %-10s %-16s %n",
                    workout.getDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")),
                    workout.getWorkoutType(),
                    workout.getMinutesDuration() + "m " + workout.getSecondsDuration() + "s",
                    workout.getCaloriesBurned());
            textArea.appendText(workoutBlock);
        }
    }
}

