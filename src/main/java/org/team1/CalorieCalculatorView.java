/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2023
 * Instructor: Prof. Brian King
 *
 * Name: Amanda Agambire
 * Section: 01
 * Date: 11/10/23
 * Time: 9:09 AM
 *
 * Project: csci205_final_project
 * Package: org.team1
 * Class: CalorieCalculator
 *
 * Description:
 *
 * ****************************************
 */
package org.team1;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Arrays;

public class CalorieCalculatorView extends Application {
    private CalorieCalculatorModel theModel;
    private VBox root;
    private HBox activitySection;
    private HBox speedSection;
    private HBox distanceSection;
    private HBox bodyWeightSection;

    /**
     * FlowPane
     */
    private FlowPane topPane;

    /**
     * TextField
     */
    private TextField speedTextField;
    private TextField distanceTextField;
    private TextField bodyWeightTextField;

    /**
     * Label
     */
    private Label activityLabel;
    private Label speedLabel;
    private Label distanceLabel;
    private Label bodyWeightLabel;

    /**
     * Button
     */
    private ComboBox<WorkoutType> activityComboBox;
    private ComboBox<String> speedComboBox;
    private ComboBox<String> distanceComboBox;


    public CalorieCalculatorView(CalorieCalculatorModel theModel) {
        this.theModel = theModel;
        root = new VBox();
        initSceneGraph();
        initStyling();
    }

    public VBox getRoot() {
        return root;
    }

    private WorkoutType getComboBoxActivity() {
        return activityComboBox.getValue();
    }

    private String getTextFieldSpeed() {
        return speedTextField.getText();
    }

    private String getComboBoxSpeed() {
        return speedComboBox.getValue();
    }

    private String getTextFieldDistance() {
        return distanceTextField.getText();
    }

    private String getComboBoxDistance() {
        return distanceComboBox.getValue();
    }

    private String getTextFieldBodyWeight() {
        return bodyWeightTextField.getText();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        initSceneGraph();

        initStyling();
        initEventHandlers();

        primaryStage.setTitle("Calories burned calculator");
        primaryStage.setScene(new Scene(this.root));
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    /**
     * Initialize the entire scene graph
     */


    /**
     * Initialize the styling for the content in the scene graph
     */
    private void initStyling() {
        root.setSpacing(5);
        root.setPrefWidth(250);

        // Set padding on the sides
        root.setPadding(new Insets(10, 5, 10, 5));
        root.setAlignment(Pos.CENTER);
        }



    /**
     * Initializing event handlers
     */
    private void initSceneGraph() {
        root = new VBox();

        // Activity
        activitySection= new HBox();
        activityComboBox = activityDropDownOptions("Select Activity");
        activityLabel = new Label("Activity: ");
        activitySection.getChildren().addAll(activityLabel, activityComboBox);


        // Speed/Pace
        speedSection= new HBox();
        speedTextField = new TextField();
        speedComboBox = dropDownOptions("Select Unit", "Miles per Hour", "Meters per Second", "Kilometers per Hour");
        speedLabel = new Label("Speed/Pace: ");
        speedSection.getChildren().addAll(speedLabel, speedTextField, speedComboBox);
        speedSection.setSpacing(10);

        // Distance
        distanceSection= new HBox();
        distanceTextField = new TextField();
        distanceComboBox = dropDownOptions("Select Unit", "Miles", "Meters", "Kilometers");
        distanceLabel = new Label("Distance: ");
        distanceSection.getChildren().addAll(distanceLabel, distanceTextField, distanceComboBox);
        distanceSection.setSpacing(10);

        //Body Weight
        bodyWeightSection = new HBox();
        bodyWeightTextField = new TextField();
        bodyWeightLabel = new Label("Body Weight: ");
        bodyWeightSection.getChildren().addAll(bodyWeightLabel, bodyWeightTextField);


        //Calculate Calories
        Button calculateButton = new Button("Calculate");
        calculateButton.setOnAction(e -> handleCalculateButton());

        root.getChildren().addAll(activitySection, speedSection, distanceSection,bodyWeightSection, calculateButton);
    }



    //format of all drop down options
    private ComboBox<String> dropDownOptions(String promptText, String... items) {
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll(items);
        comboBox.setPromptText(promptText);
        return comboBox;
    }
    private ComboBox<WorkoutType> activityDropDownOptions(String promptText) {
        ComboBox<WorkoutType> comboBox = new ComboBox<>();
        comboBox.getItems().addAll(WorkoutType.values());
        comboBox.setPromptText(promptText);
        return comboBox;
    }

    private void initEventHandlers() {
        //activityComboBox.setOnAction(e -> handleOptionSelected(activityComboBox, "Selected Activity"));
        speedComboBox.setOnAction(e -> handleOptionSelected(speedComboBox, "Selected Speed/Pace "));
        distanceComboBox.setOnAction(e -> handleOptionSelected(distanceComboBox, "Selected Distance"));
    }

    private void handleOptionSelected(ComboBox<String> comboBox, String message) {
        String selectedValue = comboBox.getValue();
        System.out.println(message + ": " + selectedValue);
        // You can perform additional actions based on the selected value if needed
    }

    private void handleCalculateButton() {
        WorkoutType selectedActivity = getComboBoxActivity();
        double speed = parseDouble(getTextFieldSpeed());
        String speedUnit = getComboBoxSpeed();
        double distance = parseDouble(getTextFieldDistance());
        String distanceUnit = getComboBoxDistance();
        double bodyWeight = parseDouble(getTextFieldBodyWeight());

        // Calculate calories based on the model (you'll need to implement this method in your model class)
        double calculatedCalories = theModel.calculateCalories(selectedActivity, speed, speedUnit, distance, distanceUnit, bodyWeight);

        // Display/print to console for nowww
        System.out.println("Calculated Calories: " + calculatedCalories);
    }

    private double parseDouble(String text) {
        try {
            return Double.parseDouble(text);
        } catch (NumberFormatException e) {
            // Handle invalid input (e.g., non-numeric input)
            return 0.0; // Default value for invalid input
        }
    }
}
