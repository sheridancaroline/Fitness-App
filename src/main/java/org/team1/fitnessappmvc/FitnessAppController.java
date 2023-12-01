/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2023
 * Instructor: Prof. Brian King / Prof. Joshua Stough
 *
 * Name: Dong Hyun Roh
 * Section: 9am
 * Date: 11/10/23
 * Time: 1:10 PM
 *
 * Project: csci205_final_project
 * Package: org.team1.fitnessappmvc
 * Class: FitnessAppController
 *
 * Description: This is the MVC controller class for
 * our fitness application
 *
 * ****************************************
 */
package org.team1.fitnessappmvc;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.team1.*;
import javafx.scene.control.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


/**
 * The MVC controller class for our fitness application. It is responsible for
 * managing user interactions and connecting the model and view for the fitness
 * application.
 */
public class FitnessAppController {

    private Stage stage;

    /** The model component of the application */
    private FitnessAppModel theModel;

    /** The view component of the application */
    private FitnessAppView theView;

    /**
     * Constructs a controller that connects the model and the
     * view for the fitness application.
     *
     * @param theModel The model component of the application.
     * @param theView  The view component of the application.
     */
    public FitnessAppController(FitnessAppModel theModel, FitnessAppView theView){
        this.theModel = theModel;
        this.theView = theView;

        // Initialize event handlers upon controller creation.
        initEventHandlers();
    }


    /**
     * Initializes event handlers for login, signup, and scene change actions.
     *
     * @author Dong Hyun Roh
     */
    private void initEventHandlers() {

        // Sets up handling for login-related events.
        loginEventHandlers();

        // Sets up handling for signup-related events.
        signupEventHandlers();

        calorieCalculatorEventHandlers();

        chatBotEventHandlers();

        calendarEventHandlers();
    }

    private void calendarEventHandlers() {
        theView.getDatePicker().setOnAction(event -> {
            if (theModel.getUserInformation() != null){
                displayWorkoutsForSelectedDate(theView.getDatePicker().getValue(), theView.getTextArea());
            }
            else{
                showAlert("Cannot use this feature", "Please create your account to " +
                        "use this feature", Alert.AlertType.WARNING);
            }
        });

        theView.getBtnAdd().setOnAction(event -> {
            showAddWorkoutDialog(theView.getDatePicker().getValue());
        });
    }

    private void showAddWorkoutDialog(LocalDate selectedDate) {

        Dialog<Void> dialog = new Dialog<>();
        dialog.setTitle("Add Workout");

        // Create components for the dialog
        ComboBox<WorkoutType> typeComboBox = new ComboBox<>();
        typeComboBox.getItems().addAll(WorkoutType.values());
        typeComboBox.setPromptText("Select Workout Type");

        Spinner<Integer> hoursSpinner = new Spinner<>(0, 10, 0);
        Spinner<Integer> minutesSpinner = new Spinner<>(0, 59, 0);

        // Layout components in the dialog
        VBox content = new VBox(new Label("Workout Date: " + selectedDate),
                typeComboBox,
                new Label("Duration:"),
                new HBox(new Label("Hours:"), hoursSpinner, new Label("Minutes:"), minutesSpinner));

        dialog.getDialogPane().setContent(content);

        // Add buttons to the dialog
        ButtonType addButton = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(addButton, ButtonType.CANCEL);

        // Handle button actions
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == addButton) {
                // Add the workout to the manager
                WorkoutType selectedType = typeComboBox.getValue();
                int hours = hoursSpinner.getValue();
                int minutes = minutesSpinner.getValue();
                int duration = minutes + hours * 60;
                double speed = 6;
                double weight = 50;
                double height = 172;
                double calculatedCalories = CalorieCalculator.calculateCalories(duration, speed, weight, height);
                //double durationInMins, double speedMeterPerSecond, double weightInKg, double heightInMeter
                Workout newWorkout = new Workout(selectedDate, selectedType, speed, duration, weight, calculatedCalories);
                theModel.getUserInformation().addWorkout(newWorkout);


                // Immediately update the display in the textArea
                displayWorkoutsForSelectedDate(selectedDate, theView.getTextArea());
            }
            return null;
        });

        dialog.showAndWait();
    }



    /**
     * Display the workouts for the selected date, updates after a workout is added
     * @param selectedDate the date of the workouts to be displayed
     * @param textArea the location where workouts are displayed
     */
    private void displayWorkoutsForSelectedDate(LocalDate selectedDate, TextArea textArea) {
        String formattedDate = selectedDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        textArea.clear();

        // Fetch and display daily workouts
        textArea.appendText("Workouts:\n");

        // Get the workouts for the selected date
        List<Workout> workouts = theModel.getUserInformation().getPastWorkouts().get(selectedDate);
                //workoutManager.getWorkoutsForDay(formattedDate);


        // Display each workout in a formatted block
        for (Workout workout : workouts) {

            int[] hoursAndMinutes = ConversionUtil.convertToHousrAndMinutes(workout.getDuration());

            String workoutBlock = String.format("%-12s %-15s %-10s %-16s %n",
                    workout.getDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")),
                    workout.getWorkoutType(),
                    hoursAndMinutes[0] + "h " + hoursAndMinutes[1] + "m ",
                    workout.getCaloriesBurned());
            textArea.appendText(workoutBlock);
        }
    }



    /**
     * Sets up event handlers for components in the login page
     *
     * @author Dong Hyun Roh
     */
    private void loginEventHandlers() {

        // Action on login button click
        this.theView.getBtnLogin().setOnAction(event -> {
            if (handleLogin()){
                changeScene(event, new Scene(theView.getCalorieCalculatorRoot()));
            }
        });

        this.theView.getBtnSignup().setOnAction(event -> {
            changeScene(event, new Scene (theView.getSignupRoot()));
        });

        this.theView.getBtnGuest().setOnAction(event -> {
            changeScene(event, new Scene(theView.getCalorieCalculatorRoot()));
        });
    }


    private boolean handleLogin() {

        boolean result = false;

        // Check if username is empty
        if (theView.getTextFieldUsername().isEmpty()){
            showAlert("Missing Information", "Enter your username", Alert.AlertType.WARNING);
        }
        // Check if password is empty
        if (theView.getTextFieldPassword().isEmpty()){
            showAlert("Missing Information", "Enter password", Alert.AlertType.WARNING);
        }
        else{
            // Verify login credentials
            if (theModel.verifyLogin(theView.getTextFieldUsername(), theView.getTextFieldPassword())){
                showAlert("Success", "Login successful", Alert.AlertType.INFORMATION);

                result = true;
            }
            // Display an error alert when login verification fails.
            else{
                showAlert("Login Unsuccessful", "Make sure your username and password are correct"
                        , Alert.AlertType.WARNING);
            }
        }
        return result;
    }


    /**
     * Sets up event handlers for signup-related actions.
     *
     * @author Dong Hyun Roh
     */
    private void signupEventHandlers() {

        // Action on verify username button click
        this.theView.getBtnVerifyUsername().setOnAction(event -> {

            // Check if username is empty
            if (theView.getTextFieldUsername2().isEmpty()){
                showAlert("Missing Information", "Please enter a username", Alert.AlertType.WARNING);
            }
            // Verify username availability
            else if (theModel.verifyUsername(theView.getTextFieldUsername2())) {
                showAlert("Available username", "You can use this name", Alert.AlertType.INFORMATION);
                theView.getBtnCreateNewAccount().setDisable(false);
            }
            // Cannot use the username
            else{
                showAlert("Choose different username", "This username is already being used", Alert.AlertType.WARNING);
            }
        });


        // Action on create new account button click
        this.theView.getBtnCreateNewAccount().setOnAction(event -> {

            // Check if passwords are empty or mismatched
            if (theView.getTextFieldPassword2().isEmpty() || theView.getTextFieldConfirmPassword().isEmpty()){
                showAlert("Confirm your password", "Make sure to confirm your password"
                        , Alert.AlertType.WARNING);
            }
            else if (!theView.getTextFieldPassword2().equals(theView.getTextFieldConfirmPassword())){
                showAlert("Confirm your password", "Enter your password again correctly"
                        , Alert.AlertType.WARNING);
            }
            // Create a new account with provided username and password
            else {
                Gender gender = null;
                if (theView.getRbMale().isSelected()){
                    gender = Gender.MALE;
                }
                else{
                    gender = Gender.FEMALE;
                }

                theModel.createNewAccount(theView.getTextFieldUsername2(), theView.getTextFieldPassword2(), gender);
                showAlert("Success", "Created a new account", Alert.AlertType.INFORMATION);
            }
        });
    }


    private void calorieCalculatorEventHandlers() {

        theView.getCalculateButton().setOnAction(e -> handleCalculateButton());

        theView.getClearButton().setOnAction(e -> handleClearButton());

        theView.getBtnViewCalendar().setOnAction(event -> {
            if(theModel.getUserInformation() != null){
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/calendar/Calendar.fxml"));
                Parent root = null;
                try {
                    root = loader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                changeScene(event, new Scene(root));
            }
            else {
                showAlert("Cannot use this feature", "You have to create an account " +
                        "to use this feature", Alert.AlertType.INFORMATION);
            }
        });

        theView.getBtnChatBot().setOnAction(event -> {
            changeScene(event, new Scene(theView.getChatBotRoot(), 300, 200));
        });

    }


    private void handleCalculateButton() {
        double speed = ConversionUtil.convertSpeedToMeters(parseDouble(theView.getTextFieldSpeed()), theView.getComboBoxSpeed());
        double weight = ConversionUtil.convertWeightToKg(parseDouble(theView.getTextFieldWeight()), theView.getComboBoxWeight());
        double height = ConversionUtil.convertHeightToMeters(parseDouble(theView.getTextFieldHeight()), theView.getComboBoxHeight());
        double hours = parseDouble(theView.getTextFieldHours());
        double minutes = parseDouble(theView.getTextFieldMinutes());

        // Calculate calories based on the model
        double calculatedCalories = theModel.calculateCalories( hours * 60 + minutes, speed, weight, height);

        // Display the result
        showAlert("Calculation result", "Calculated Calories: " + calculatedCalories, Alert.AlertType.INFORMATION);
    }


    private void handleClearButton() {
        theView.speedTextField.clear();
        theView.weightTextField.clear();
        theView.heightTextField.clear();
        theView.hoursTextField.clear();
        theView.minutesTextField.clear();

    }


    private void handleAddButton() {

        //theChart.updateLineChart(LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd")), calculatedCalories);
    }


    /**
     * @author Donovan
     */
    private void chatBotEventHandlers() {

        theView.getSubmitButton().setOnAction(event -> {

            String name = theView.getNameInput().getText();
            double timeLimit = parseDoubleInput(theView.getTimeLimitInput().getText());
            double pounds = parseDoubleInput(theView.getPoundsInput().getText());
            double timePeriod = parseDoubleInput(theView.getTimePeriodInput().getText());

            if (timeLimit <= 0 || pounds <= 0 || timePeriod <= 0) {
                showAlert("Invalid input", "Please enter valid positive numeric values.", Alert.AlertType.WARNING);
                return;
            }

            double[] suggestedWorkout = ChatBot.suggestWorkout(timeLimit, pounds, timePeriod);

            showAlert("Suggested Workout",
                    "Hi " + name + "! Based on your inputs, here's a suggested workout over the course of the next " + timePeriod + " days:\n"
                            + "Workout: " + ChatBot.determineWorkoutChoice(suggestedWorkout[1]) + "\n"
                            + "Distance: " + String.format("%.2f", suggestedWorkout[0]) + " miles\n"
                            + "Speed: " + String.format("%.2f", suggestedWorkout[1]) + " miles per hour", Alert.AlertType.INFORMATION);

            // Prompt for another entry
            clearInputs(theView.getNameInput(), theView.getTimeLimitInput(), theView.getPoundsInput(), theView.getTimePeriodInput());
        });
    }


    private void clearInputs(TextField... textFields) {
        for (TextField textField : textFields) {
            textField.clear();
        }
    }




    // TODO combine 2 parseDouble methods
    private double parseDoubleInput(String input) {
        double result = 0.0;
        try {
            result = Double.parseDouble(input);
        } catch (NumberFormatException | NullPointerException e) {
            showAlert("Invalid input", "Please enter a valid numeric value.", Alert.AlertType.WARNING);
        }
        return result;
    }

    private double parseDouble(String text) {
        try {
            return Double.parseDouble(text);
        } catch (NumberFormatException e) {
            // Default value for invalid input
            return 0.0;
        }
    }


    /**
     * Handles various scene changes
     *
     * @author Dong Hyun Roh
     *
     * @param event
     * @param scene
     */
    private void changeScene(javafx.event.ActionEvent event, Scene scene){
        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


    // Donovan
    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
