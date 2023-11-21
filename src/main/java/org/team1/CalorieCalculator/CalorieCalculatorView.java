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
package org.team1.CalorieCalculator;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.team1.CalorieCalculator.CalorieCalculatorModel;
import org.team1.Sex;
import org.team1.WorkoutType;
import org.team1.User;

public class CalorieCalculatorView {
    /** The model that contains the data and logic behind this view */
    private CalorieCalculatorModel theModel;

    /** Layouts*/
    private VBox root;
    private HBox activitySection;
    private HBox speedSection;
    private HBox distanceSection;
    private HBox durationSection;
    private HBox buttonSection;

    //TODO this creates a new user for the MVP , we
    // have to figure out how to let it be jyst one user from the log in
    private User user;


    /** TextField */
    public TextField speedTextField;
    public TextField distanceTextField;
    public TextField hoursTextField;
    public TextField minutesTextField;

    /** Labels */
    private Label activityLabel;
    private Label speedLabel;
    private Label distanceLabel;
    private Label durationLabel;
    private Label hoursLabel;
    private Label minutesLabel;

    /** Buttons */
    private Button calculateButton;
    private Button clearButton;

    /** ComboBoxes */
    private ComboBox<WorkoutType> activityComboBox;
    private ComboBox<String> speedComboBox;
    private ComboBox<String> distanceComboBox;

    /**
     * Initialize Calculator view
     * @param theModel the logic & data behind the view
     */
    public CalorieCalculatorView(CalorieCalculatorModel theModel) {
        this.theModel = theModel;
        root = new VBox();
        this.user = new User(Sex.MALE, 82);
        initSceneGraph();
        initStyling();
    }

    /**Getters */
    public VBox getRoot() {
        return root;
    }

    public WorkoutType getComboBoxActivity() {
        return activityComboBox.getValue();
    }

    public String getTextFieldSpeed() {
        return speedTextField.getText();
    }

    public String getComboBoxSpeed() {
        return speedComboBox.getValue();
    }

    public String getTextFieldDistance() {
        return distanceTextField.getText();
    }

    public String getComboBoxDistance() {
        return distanceComboBox.getValue();
    }

    public String getTextFieldHours() {
        return hoursTextField.getText();
    }
    public String getTextFieldMinutes() {
        return minutesTextField.getText();
    }

    public Button getCalculateButton() {
        return calculateButton;
    }
    public Button getClearButton() {
        return clearButton;
    }



    /** Initialize the styling for the content in the scene graph*/
    private void initStyling() {
        root.setSpacing(5);
        root.setPrefWidth(250);

        // Set padding on the sides
        root.setPadding(new Insets(10, 5, 10, 5));
        root.setAlignment(Pos.CENTER);
    }


    /** Initializing Scene Graph contents*/
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

        // Duration
        durationSection= new HBox();
        durationLabel = new Label("Duration: ");
        hoursTextField = new TextField();
        hoursTextField.setPromptText("hours");

        minutesTextField = new TextField();
        minutesTextField.setPromptText("minutes");
        durationSection.getChildren().addAll(durationLabel, hoursTextField, minutesTextField);


        // Distance
        distanceSection= new HBox();
        distanceTextField = new TextField();
        distanceComboBox = dropDownOptions("Select Unit", "Miles", "Meters", "Kilometers");
        distanceLabel = new Label("Distance: ");
        distanceSection.getChildren().addAll(distanceLabel, distanceTextField, distanceComboBox);
        distanceSection.setSpacing(10);


        //Calculate Calories Button
        buttonSection= new HBox();
        calculateButton = new Button("Calculate");
        //Clear Calories Button
        clearButton = new Button("Clear ");
        buttonSection.getChildren().addAll(clearButton, calculateButton);
        //distanceSection.setSpacing(20);

        root.getChildren().addAll(activitySection, durationSection, speedSection, distanceSection,buttonSection);
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



}
