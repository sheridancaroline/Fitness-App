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

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
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
     * Initializes and sets up various event handlers for different functionalities
     * within the application, such as login, signup, calorie calculator,
     * chatBot, calendar, and menu bar features.
     *
     * @author Dong Hyun Roh
     */
    private void initEventHandlers() {

        // Sets up login related event handlers.
        loginEventHandlers();

        // Sets up signup related event handlers
        signupEventHandlers();

        // Sets up calorie calculator related event handlers
        calorieCalculatorEventHandlers();

        // Sets up chatbot related event handlers
        chatBotEventHandlers();

        // Sets up Calendar related event handlers
        calendarEventHandlers();

        // Sets up menubar related event handlers
        menuBarEventHandler();
    }


    /**
     * Sets up event handlers for controls in the login page
     *
     * @author Dong Hyun Roh
     */
    private void loginEventHandlers() {

        // Action on login button click
        this.theView.getBtnLogin().setOnAction(event -> {

            // If login credentials are verified
            if (handleLogin()){
                // Change the scene to the calorie calculator view
                changeScene(event, theView.getCalorieCalculatorRoot());

                // Check if there is workout information to be displayed in the chart
                if (theModel.getUserInformation().getPastWorkouts().firstEntry() != null){

                    // Initialize the chart
                    theView.getLineChart().getData().add(generateSeries());
                }

                // Enable the menu
                theView.getMenuView().setDisable(false);
            }
        });

        // Action on signup button click
        this.theView.getBtnSignup().setOnAction(event -> {
            // Change the scene to the signup view
            changeScene(event, theView.getSignupRoot());
        });

        // Action on guest button click
        this.theView.getBtnGuest().setOnAction(event -> {
            showAlert("Notification", "You want be able to use calendar and chart features",
                    Alert.AlertType.INFORMATION);

            // Change the scene to the calorie calculator view
            changeScene(event, theView.getCalorieCalculatorRoot());

            // Enable the menu but limit certain menuItems because it's a guest
            theView.getMenuView().setDisable(false);
            theView.getMenuItemChart().setDisable(true);
            theView.getMenuItemCalendar().setDisable(true);
        });
    }


    /**
     * Handles the login process by verifying user credentials.
     *
     * @author Dong Hyun Roh
     * @return true if login is successful, false otherwise.
     */
    private boolean handleLogin() {

        boolean result = false;

        // Check if username field is empty
        if (theView.getTextFieldUsername().isEmpty()){
            showAlert("Missing Information", "Enter your username", Alert.AlertType.WARNING);
        }
        // Check if password field is empty
        if (theView.getTextFieldPassword().isEmpty()){
            showAlert("Missing Information", "Enter password", Alert.AlertType.WARNING);
        }
        // Verify login credentials using the model
        else{
            // login verification succeeds
            if (theModel.verifyLogin(theView.getTextFieldUsername(), theView.getTextFieldPassword())){
                showAlert("Success", "Login successful", Alert.AlertType.INFORMATION);
                result = true;
            }
            // login verification fails.
            else{
                showAlert("Login Unsuccessful", "Make sure your username and password are correct"
                        , Alert.AlertType.WARNING);
            }
        }
        return result;
    }


    /**
     * Sets up event handlers for signup-related buttons and actions in the application view.
     * Handles actions such as verifying username availability and creating a new user account.
     *
     * @author Dong Hyun Roh
     */
    private void signupEventHandlers() {

        // Action on verify username button click
        this.theView.getBtnVerifyUsername().setOnAction(event -> handleVerifyUsernameButton());

        // Action on create new account button click
        this.theView.getBtnCreateNewAccount().setOnAction(event -> {

            // If account creation is successful
            if(handleCreateNewAccountButton()){
                // Change the scene to the calorie calculator view
                changeScene(event, theView.getCalorieCalculatorRoot());
                theView.getMenuView().setDisable(false);
            }
        });
    }


    /**
     * Handles the verification of a username's availability when {@code btnVerifyUsername} is clicked
     *
     * @author Dong Hyun Roh
     */
    private void handleVerifyUsernameButton() {

        // Check if username field is empty
        if (theView.getTextFieldUsername2().isEmpty()){
            showAlert("Missing Information", "Please enter a username", Alert.AlertType.WARNING);
        }
        // The username entered is available
        else if (theModel.verifyUsername(theView.getTextFieldUsername2())) {
            showAlert("Available username", "You can use this name", Alert.AlertType.INFORMATION);
            theView.getBtnCreateNewAccount().setDisable(false);
        }
        // The username entered is not available
        else{
            showAlert("Choose different username", "This username is already being used",
                    Alert.AlertType.WARNING);
        }
    }


    /**
     * Handles the process of creating a new user account based on the provided information.
     * Validates the input fields and creates a new account if the provided data is valid.
     *
     * @author Dong Hyun Roh
     * @return true if the new account creation is successful, false otherwise.
     */
    private boolean handleCreateNewAccountButton() {

        boolean result = false;

        // Check if the user entered both weight and height
        if (theView.getTextFieldWeight2().isEmpty() || theView.getTextFieldHeight2().isEmpty()){
            showAlert("Form Incomplete", "Make sure to enter both your weight and height"
                    , Alert.AlertType.WARNING);
        }
        // Check if password fields are empty
        else if (theView.getTextFieldPassword2().isEmpty() || theView.getTextFieldConfirmPassword().isEmpty()){
            showAlert("Confirm your password", "Make sure to confirm your password"
                    , Alert.AlertType.WARNING);
        }
        // Check if the passwords do not match
        else if (!theView.getTextFieldPassword2().equals(theView.getTextFieldConfirmPassword())){
            showAlert("Confirm your password", "Enter your password again correctly"
                    , Alert.AlertType.WARNING);
        }
        // Create a new account with provided information
        else {
            Gender gender = null;
            if (theView.getRbMale().isSelected()){
                gender = Gender.MALE;
            }
            else{
                gender = Gender.FEMALE;
            }

            theModel.createNewAccount(theView.getTextFieldUsername2(), theView.getTextFieldPassword2(),
                    gender, parseDouble(theView.getTextFieldWeight2()), parseDouble(theView.getTextFieldHeight2()));
            showAlert("Success", "Created a new account", Alert.AlertType.INFORMATION);

            result = true;
        }
        return result;
    }


    /**
     * Sets up event handlers for buttons related to the calorie calculator
     * functionality in the application view.
     *
     * @author Dong Hyun Roh
     */
    private void calorieCalculatorEventHandlers() {

        // Action on calculate button click
        theView.getBtnCalculate().setOnAction(e -> handleCalculateButton());

        // Action on clear button click
        theView.getBtnClear().setOnAction(e -> handleClearButton());
    }


    /**
     * Handles the action when the {@code btnCalculate} is clicked
     * Calculates the calories burned based on the input values and displays the result.
     *
     * @author Amanda
     */
    private void handleCalculateButton() {

        // Convert inputs to appropriate units for calculation
        double speed = ConversionUtil.convertSpeedToMeters(parseDouble(theView.getTextFieldSpeed()),
                theView.getComboBoxSpeed());
        double weight = ConversionUtil.convertWeightToKg(parseDouble(theView.getTextFieldWeight()),
                theView.getComboBoxWeight());
        double height = ConversionUtil.convertHeightToMeters(parseDouble(theView.getTextFieldHeight()),
                theView.getComboBoxHeight());
        double hours = parseDouble(theView.getTextFieldHours());
        double minutes = parseDouble(theView.getTextFieldMinutes());

        // Input Verification
        if (speed == 0 || weight == 0 || height == 0 || (hours == 0 && minutes == 0)){
            showAlert("Invalid Input", "Please enter non-zero values for ALL input fields", Alert.AlertType.WARNING);
        }
        else{
            // Calculate calories based on the model
            double calculatedCalories = CalorieCalculator.calculateCalories( hours * 60 + minutes,
                    speed, weight, height);

            // Display the result
            showAlert("Calculation result", "Calculated Calories: " + calculatedCalories,
                    Alert.AlertType.INFORMATION);
        }
    }


    /**
     * Handles the action when {@code btnClear} is clicked.
     * Clears input fields for speed, weight, height, hours, and minutes.
     *
     * @author Amanda
     */
    private void handleClearButton() {
        theView.speedTextField.clear();
        theView.weightTextField.clear();
        theView.heightTextField.clear();
        theView.hoursTextField.clear();
        theView.minutesTextField.clear();
    }


    /**
     * Sets up event handlers for elements related to the calendar functionality.
     * Handles actions such as displaying workouts for a selected date and showing
     * a dialog to add a workout.
     *
     * @author Caroline
     */
    private void calendarEventHandlers() {

        // Action when a date is selected in the DatePicker
        theView.getDatePicker().setOnAction(event -> {
            displayWorkoutsForSelectedDate(theView.getDatePicker().getValue(), theView.getTextArea());
        });

        // Action when the add button is clicked
        theView.getBtnAdd().setOnAction(event -> {
            showAddWorkoutDialog(theView.getDatePicker().getValue());
        });

        // Action on view calendar button click
        theView.getBtnViewCalendar().setOnAction(this::handleViewCalendarButton);
    }


    /**
     * Sets up the function of the calendar that allows the user to add a workout once they select a date
     *
     * @author Caroline
     * @param selectedDate the date the user selects that the workout will be added to
     */
    private void showAddWorkoutDialog(LocalDate selectedDate) {

        Dialog<Void> dialog = new Dialog<>();
        dialog.setTitle("Add Workout");

        // Create components for the dialog
        ComboBox<WorkoutType> typeComboBox = new ComboBox<>();
        typeComboBox.getItems().addAll(WorkoutType.values());
        typeComboBox.setPromptText("Select Workout Type");

        Spinner<Integer> hoursSpinner = new Spinner<>(0, 10, 0);
        Spinner<Integer> minutesSpinner = new Spinner<>(0, 59, 0);

        TextField textfieldSpeed = new TextField();

        // Layout components in the dialog
        VBox content = new VBox(new Label("Workout Date: " + selectedDate),
                typeComboBox,
                new Label("Duration:"),
                new HBox(new Label("Hours:"), hoursSpinner, new Label("Minutes:"), minutesSpinner),
                new HBox(new Label("Speed (m/s)"), textfieldSpeed));

        dialog.getDialogPane().setContent(content);

        // Add buttons to the dialog
        ButtonType addButton = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(addButton, ButtonType.CANCEL);

        // Handle button actions
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == addButton) {

                WorkoutType selectedType = typeComboBox.getValue();
                int duration = minutesSpinner.getValue() + hoursSpinner.getValue() * 60;
                double speed = parseDouble(textfieldSpeed.getText());
                double weight = theModel.getUserInformation().getWeight();
                double heightInM = (double) theModel.getUserInformation().getHeight()/100;
                double calculatedCalories = CalorieCalculator.calculateCalories(duration, speed, weight, heightInM);

                Workout newWorkout = new Workout(selectedDate, selectedType, speed, duration, weight, calculatedCalories);

                // update the user's workout information
                theModel.getUserInformation().addWorkout(newWorkout);
                theModel.updateUserInformation();

                // Immediately update the display in the textArea
                displayWorkoutsForSelectedDate(selectedDate, theView.getTextArea());
            }
            return null;
        });

        dialog.showAndWait();
    }


    /**
     * Display the workouts for the selected date, updates after a workout is added
     *
     * @author Caroline
     * @param selectedDate the date of the workouts to be displayed
     * @param textArea the location where workouts are displayed
     */
    private void displayWorkoutsForSelectedDate(LocalDate selectedDate, TextArea textArea) {

        textArea.clear();

        // Fetch and display daily workouts
        textArea.appendText("Workouts:\n");

        // Get the workouts for the selected date
        List<Workout> workouts = theModel.getUserInformation().getPastWorkouts().get(selectedDate);

        // Display each workout in a formatted block
        for (Workout workout : workouts) {

            // Convert the duration into hours and minutes
            int[] hoursAndMinutes = ConversionUtil.convertToHoursAndMinutes(workout.getDuration());

            String workoutBlock = String.format("%-12s %-15s %-10s %-16s %n",
                    workout.getDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")),
                    workout.getWorkoutType(),
                    hoursAndMinutes[0] + "h " + hoursAndMinutes[1] + "m ",
                    workout.getCaloriesBurned());
            textArea.appendText(workoutBlock);
        }
    }


    /**
     * Handles the action when the {@code btnViewCalendar} is clicked.
     * Display the calendar just for the users but not guests.
     * The calendar being displayed needs further improvement
     *
     * @author Dong Hyun Roh
     * @param event The ActionEvent generated by clicking {@code btnViewCalendar}
     */
    private void handleViewCalendarButton(ActionEvent event) {

        // It is a registered user
        if(theModel.getUserInformation() != null){

            // Load the Calendar view
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/calendar/Calendar.fxml"));
            Parent root = null;
            try {
                root = loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        }
        // It is a guest
        else {
            showAlert("Cannot use this feature", "You have to create an account " +
                    "to use this feature", Alert.AlertType.INFORMATION);
        }
    }


    /**
     * Sets up event handlers for the ChatBot feature in the application view.
     * Handles actions when the submit button is clicked to generate workout suggestions based on user input.
     *
     * @author Donovan
     */
    private void chatBotEventHandlers() {

        theView.getSubmitButton().setOnAction(event -> {

            // Retrieve user inputs from the view
            String name = theView.getNameInput().getText();
            double timeLimit = parseDouble(theView.getTimeLimitInput().getText());
            double pounds = parseDouble(theView.getPoundsInput().getText());
            double timePeriod = parseDouble(theView.getTimePeriodInput().getText());

            // Check if inputs are valid positive numeric values
            if (timeLimit <= 0 || pounds <= 0 || timePeriod <= 0) {
                showAlert("Invalid input", "Please enter valid positive numeric values.", Alert.AlertType.WARNING);
                return;
            }

            // Get suggested workout details from the ChatBot based on user inputs
            double[] suggestedWorkout = ChatBot.suggestWorkout(timeLimit, pounds, timePeriod);

            showAlert("Suggested Workout",  "Hi " + name + "! Based on your inputs, here's " +
                    "a suggested workout over the course of the next " + timePeriod + " days:\n"
                    + "Workout: " + ChatBot.determineWorkoutChoice(suggestedWorkout[1]) + "\n"
                    + "Distance: " + String.format("%.2f", suggestedWorkout[0]) + " miles\n"
                    + "Speed: " + String.format("%.2f", suggestedWorkout[1]) + " miles per hour", Alert.AlertType.INFORMATION);

            // Prompt for another entry
            clearInputs(theView.getNameInput(), theView.getTimeLimitInput(), theView.getPoundsInput(), theView.getTimePeriodInput());
        });
    }


    /**
     * Clears the text content of the specified TextField objects.
     *
     * @author Donovan
     * @param textFields The TextField objects whose content needs to be cleared.
     */
    private void clearInputs(TextField... textFields) {
        for (TextField textField : textFields) {
            textField.clear();
        }
    }


    /**
     * Parses the given string into a double value.
     * If the parsing fails, returns a default value of 0.0.
     *
     * @author Amanda and Donovan
     * @param text The string to be parsed into a double.
     * @return The parsed double value or 0.0 if parsing fails.
     */
    private double parseDouble(String text) {
        try {
            return Double.parseDouble(text);
        } catch (NumberFormatException e) {
            // Default value for invalid input
            return 0.0;
        }
    }


    /**
     * Sets up event handlers for menu items in the application's menu bar.
     * Handles actions when menu items are clicked to change scenes or exit the application.
     *
     * @author Amanda and Dong Hyun Roh
     */
    private void menuBarEventHandler(){

        // Action when 'Calorie Calculator' menu item is clicked
        theView.getMenuItemCalorieCalculator().setOnAction(event -> {
            changeScene(new BorderPane(theView.getCalorieCalculatorRoot()));
        });

        // Action when 'Calendar' menu item is clicked
        theView.getMenuItemCalendar().setOnAction(event -> {
            changeScene(new BorderPane(theView.getCalendarRoot()));
        });

        // Action when 'Chatbot' menu item is clicked
        theView.getMenuItemChatbot().setOnAction(event -> {
            changeScene(new BorderPane(theView.getChatBotRoot()));
        });

        // Action when 'Chart' menu item is clicked
        theView.getMenuItemChart().setOnAction(event -> {

            // Direct to the chart page
            changeScene(new BorderPane(theView.getChartRoot()));

            // Inform the user there is no past workout information saved yet
            if (theModel.getUserInformation().getPastWorkouts().firstEntry() == null){
                showAlert("Empty Chart", "It seems that you have created a new account! " +
                        "\n So we do not have any information to generate the chart "
                        , Alert.AlertType.INFORMATION);
            }
        });

        // Action when 'Exit' menu item is clicked
        theView.getMenuItemExit().setOnAction(event -> {
            Platform.exit();
        });
    }


    /**
     * Generates an XYChart.Series containing sample data of calories for specific dates.
     * Although this method generates sample data, we would have extracted data from userInformation in
     * {@link org.team1.fitnessappmvc.FitnessAppModel}
     *
     * @author Amanda and Dong Hyun
     * @return An XYChart.Series object representing calorie data over a range of dates.
     */
    private XYChart.Series<String, Number> generateSeries(){

        // Create a new XYChart.Series to hold calorie data
        XYChart.Series<String, Number> series = new XYChart.Series<>();

        series.setName("Calories");

        // Sample dates and corresponding calorie values
        String[] dates = {"10/12", "10/13", "10/14", "10/15", "10/16", "10/17", "10/18", "10/19", "10/20"};
        int[] calories = {362, 222, 156, 156, 1133, 120, 91, 45, 430};

        // Add data points to the series with dates and calorie values
        for (int i = 0; i < dates.length; i++) {
            series.getData().add(new XYChart.Data<>(dates[i], calories[i]));
        }
        return series;
    }


    /**
     * Changes the scene of the JavaFX application to a new scene
     * with the specified BorderPane as the root.
     *
     * @author Amanda
     * @param root for the new scene
     */
    public void changeScene(BorderPane root){

        Scene scene = new Scene(root, 650, 450);
        root.setTop(theView.getMenuBar());
        stage.setScene(scene);
    }


    /**
     * Changes the scene of the JavaFX application to a new scene
     * with the specified BorderPane as the root.
     *
     * @author Dong Hyun Roh
     * @param event that triggers the scene change.
     * @param root for the new scene
     */
    private void changeScene(javafx.event.ActionEvent event, BorderPane root){

        Scene scene = new Scene(root, 650, 450);
        root.setTop(theView.getMenuBar());
        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


    /**
     * Displays an alert dialog with the specified title, message, and type.
     *
     * @author Donovan
     * @param title   The title of the alert dialog.
     * @param message The message to be displayed in the alert dialog.
     * @param type    The type of the alert dialog (e.g., INFORMATION, WARNING, ERROR).
     */
    private void showAlert(String title, String message, Alert.AlertType type) {

        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}

