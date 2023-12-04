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
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.team1.CalorieCalculator.CalorieCalculatorModel;
import org.team1.Gender;
import org.team1.WorkoutType;
import org.team1.User;

public class CalorieCalculatorView extends Node {
    /** The model that contains the data and logic behind this view */
    private CalorieCalculatorModel theModel;

    /** Layouts*/
    private VBox root;
    private HBox activitySection;
    private HBox speedSection;
    private HBox weightSection;
    private HBox heightSection;
    private HBox durationSection;
    private HBox buttonSection;

    //TODO this creates a new user for the MVP , we
    // have to figure out how to let it be jyst one user from the log in
    private User user;


    /** TextField */
    public TextField speedTextField;
    public TextField weightTextField;
    public TextField heightTextField;
    public TextField hoursTextField;
    public TextField minutesTextField;

    /** Labels */
    private Label activityLabel;
    private Label speedLabel;
    private Label weightLabel;
    private Label heightLabel;
    private Label durationLabel;
    private Label hoursLabel;
    private Label minutesLabel;

    /** Buttons */
    private Button calculateButton;
    private Button clearButton;
    private Button addButton;

    /** ComboBoxes */
    private ComboBox<WorkoutType> activityComboBox;
    private ComboBox<String> speedComboBox;
    private ComboBox<String> weightComboBox;
    private ComboBox<String> heightComboBox;

    /**
     * Initialize Calculator view
     * @param theModel the logic & data behind the view
     */
    public CalorieCalculatorView(CalorieCalculatorModel theModel) {
        this.theModel = theModel;
        root = new VBox();
        this.user = new User(Gender.MALE, 82, 5);
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

    public String getTextFieldWeight() {
        return weightTextField.getText();
    }
    public String getTextFieldHeight() {
        return heightTextField.getText();
    }

    public String getComboBoxWeight() {
        return weightComboBox.getValue();
    }
    public String getComboBoxHeight() {
        return heightComboBox.getValue();
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
    public Button getAddButton() {
        return addButton;
    }



    /**
     * @author Amanda Agambire
     * Initialize the styling for the content in the scene graph
     * */
    private void initStyling() {
        root.setSpacing(5);
        root.setPrefWidth(250);

        // Set padding on the sides
        root.setPadding(new Insets(10, 5, 10, 5));
        root.setAlignment(Pos.CENTER);
    }


    /** @author Amanda Agambire
     * Initializing Scene Graph contents*/
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
        speedComboBox.getSelectionModel().selectFirst();
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


        // Weight
        weightSection= new HBox();
        weightTextField = new TextField();
        weightComboBox = dropDownOptions( "Select Unit","Kilograms(kg)", "Pound (lb)");
        weightComboBox.getSelectionModel().selectFirst();
        weightLabel = new Label("Current Weight: ");
        weightSection.getChildren().addAll(weightLabel, weightTextField, weightComboBox);
        weightSection.setSpacing(10);

        // Height
        heightSection= new HBox();
        heightTextField = new TextField();
        heightComboBox = dropDownOptions( "Select Unit","inches(in)", "centimeters(cm)");
        heightComboBox.getSelectionModel().selectFirst();
        heightLabel = new Label("Current Height: ");
        heightSection.getChildren().addAll(heightLabel, heightTextField, heightComboBox);
        heightSection.setSpacing(10);

        //Calculate Calories Button
        buttonSection= new HBox();
        calculateButton = new Button("Calculate");
        //Clear Calories Button
        clearButton = new Button("Clear ");
        //Clear Calories Button
        addButton = new Button("Add to Chart");
        buttonSection.getChildren().addAll(clearButton, calculateButton, addButton);
        //distanceSection.setSpacing(20);

        root.getChildren().addAll(activitySection, durationSection, speedSection, weightSection, heightSection, buttonSection);
    }



    //format of all drop down options

    /**
     * @author Amanda Agambire
     * format a combobox for all variables and their unit oo\ptions
     * @param promptText - initial option
     * @param items - other unit options
     * @return
     */
    private ComboBox<String> dropDownOptions(String promptText, String... items) {
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll(items);
        comboBox.setPromptText(promptText);
        return comboBox;
    }

    /**
     * @author Amanda Agambire
     * @param promptText initial option
     * @return
     */
    private ComboBox<WorkoutType> activityDropDownOptions(String promptText) {
        ComboBox<WorkoutType> comboBox = new ComboBox<>();
        comboBox.getItems().addAll(WorkoutType.values());
        comboBox.setPromptText(promptText);
        return comboBox;
    }



}
