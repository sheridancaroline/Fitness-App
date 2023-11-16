package Project;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Arrays;

public class RecordedStepsPage extends Application {

    private RecordedSteps recordedSteps = new RecordedSteps();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Recorded Steps Tracker");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        // Create controls
        Label stepsLabel = new Label("Enter Steps (comma-separated):");
        TextField stepsInput = new TextField();
        Button recordStepsButton = new Button("Record Steps");
        Button displayStepsButton = new Button("Display Recorded Steps");

        // Set button actions
        recordStepsButton.setOnAction(e -> recordSteps(stepsInput.getText()));
        displayStepsButton.setOnAction(e -> displayRecordedSteps());

        // Add controls to grid
        grid.add(stepsLabel, 0, 0);
        grid.add(stepsInput, 1, 0);
        grid.add(recordStepsButton, 2, 0);
        grid.add(displayStepsButton, 1, 2);

        // Create scene and set it on the stage
        Scene scene = new Scene(grid, 400, 150);
        primaryStage.setScene(scene);

        // Show the stage
        primaryStage.show();
    }

    private void recordSteps(String stepsInput) {
        try {
            int[] stepsArray = Arrays.stream(stepsInput.split(","))
                    .map(String::trim)
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int steps : stepsArray) {
                recordedSteps.recordSteps(steps);
            }

            showAlert("Record Steps", "Steps recorded successfully!");
        } catch (NumberFormatException e) {
            showAlert("Error", "Invalid input. Please enter a valid comma-separated list of integers.");
        }
    }

    private void displayRecordedSteps() {
        recordedSteps.displayStepRecords();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
