package org.team1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WeightLossChatbotFX extends Application {
    private static final double CALORIES_BURNED_PER_MILE = 100;
    private static final int AVG_WALKING_SPEED = 3;
    private double timeLimit;
    private double calorieInput;
    private String workoutChoice;
    private double timePeriod = 30;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Weight Loss Chatbot");

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));

        TextField nameInput = new TextField();
        nameInput.setPromptText("Enter your name");

        TextField timeLimitInput = new TextField();
        timeLimitInput.setPromptText("Enter workout time limit (Minutes)");

        TextField poundsInput = new TextField();
        poundsInput.setPromptText("Enter the number of pounds to lose");

        TextField timePeriodInput = new TextField();
        timePeriodInput.setPromptText("Enter the time span to lose weight (Days)");

        Button submitButton = new Button("Submit");

        layout.getChildren().addAll(nameInput, timeLimitInput, poundsInput, timePeriodInput, submitButton);

        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();

        submitButton.setOnAction(e -> {
            String name = nameInput.getText();
            timeLimit = parseDoubleInput(timeLimitInput.getText());
            double pounds = parseDoubleInput(poundsInput.getText());
            timePeriod = parseDoubleInput(timePeriodInput.getText());

            if (timeLimit <= 0 || pounds <= 0 || timePeriod <= 0) {
                showAlert("Invalid input", "Please enter valid positive numeric values.");
                return;
            }

            calorieInput = pounds * 3500;

            double[] suggestedWorkout = suggestWorkout(timeLimit, calorieInput, timePeriod);

            showAlert("Suggested Workout",
                    "Hi " + name + "! Based on your inputs, here's a suggested workout over the course of the next " + timePeriod + " days:\n"
                            + "Workout: " + workoutChoice + "\n"
                            + "Distance: " + String.format("%.2f", suggestedWorkout[0]) + " miles\n"
                            + "Speed: " + String.format("%.2f", suggestedWorkout[1]) + " miles per hour");

            // Prompt for another entry
            clearInputs(nameInput, timeLimitInput, poundsInput, timePeriodInput);
        });
    }

    private double parseDoubleInput(String input) {
        double result = 0.0;
        try {
            result = Double.parseDouble(input);
        } catch (NumberFormatException | NullPointerException e) {
            showAlert("Invalid input", "Please enter a valid numeric value.");
        }
        return result;
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private double[] suggestWorkout(double time, double calorie, double days) {
        double suggestedDistance = calorie / CALORIES_BURNED_PER_MILE;
        double suggestedSpeed = suggestedDistance / time;
        double sessionDistance = suggestedDistance / days;

        workoutChoice = (suggestedSpeed > AVG_WALKING_SPEED) ? "Running" : "Walking";

        return new double[]{sessionDistance, suggestedSpeed};
    }

    private void clearInputs(TextField... textFields) {
        for (TextField textField : textFields) {
            textField.clear();
        }
    }
}
