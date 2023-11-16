package Project;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ActivityPage extends Application {

    private ActivityStats activityStats = new ActivityStats();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Fitness Tracker");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        // Create controls
        Label stepsLabel = new Label("Number of Steps:");
        TextField stepsInput = new TextField();
        Label caloriesLabel = new Label("Number of Calories:");
        TextField caloriesInput = new TextField();
        Button recordStepsButton = new Button("Record Steps");
        Button recordCaloriesButton = new Button("Record Calories");
        Button displayStatsButton = new Button("Display Stats");

        // Set button actions
        recordStepsButton.setOnAction(e -> recordSteps(Integer.parseInt(stepsInput.getText())));
        recordCaloriesButton.setOnAction(e -> recordCalories(Integer.parseInt(caloriesInput.getText())));
        displayStatsButton.setOnAction(e -> displayStats());

        // Add controls to grid
        grid.add(stepsLabel, 0, 0);
        grid.add(stepsInput, 1, 0);
        grid.add(recordStepsButton, 2, 0);
        grid.add(caloriesLabel, 0, 1);
        grid.add(caloriesInput, 1, 1);
        grid.add(recordCaloriesButton, 2, 1);
        grid.add(displayStatsButton, 1, 2);

        // Create scene and set it on the stage
        Scene scene = new Scene(grid, 300, 150);
        primaryStage.setScene(scene);

        // Show the stage
        primaryStage.show();
    }

    private void recordSteps(int steps) {
        activityStats.recordSteps(steps);
        showAlert("Record Steps", "Steps recorded successfully!");
    }

    private void recordCalories(int calories) {
        activityStats.recordCalories(calories);
        showAlert("Record Calories", "Calories recorded successfully!");
    }

    private void displayStats() {
        activityStats.displayStats();
        showAlert("Fitness Tracker Stats", "Stats displayed successfully!");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
