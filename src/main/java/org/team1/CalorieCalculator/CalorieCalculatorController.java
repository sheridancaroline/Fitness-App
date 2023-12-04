package org.team1.CalorieCalculator;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import org.team1.LineChartStats.LineChartStatsMain;
import org.team1.LineChartStats.LineChartStatsView;
import org.team1.Gender;
import org.team1.User;
import org.team1.WorkoutType;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CalorieCalculatorController {

    /**CalorieCalculator Model */
    private CalorieCalculatorModel theModel;

    /**CalorieCalculator View */
    private CalorieCalculatorView theView;

    /**Line Chart View  */
    private LineChartStatsView theChart;

    /** total calories calulated */
    double calculatedCalories;

    /**
     * @author amandaagambire
     * create instances of the calorie calculator model and view
     * @param theModel CalorieCalculator Model
     * @param theView CalorieCalculator View
     */
    public CalorieCalculatorController(CalorieCalculatorModel theModel, CalorieCalculatorView theView) {
        this.theModel = theModel;
        this.theView = theView;

        initEventHandlers();
        //initBindings();

    }

    /**
     * @author amandaagambire
     * Assign Handlers to the buttons
     */
    private void initEventHandlers() {
        theView.getCalculateButton().setOnAction(e -> handleCalculateButton());
        theView.getClearButton().setOnAction(e -> handleClearButton());
        //theView.getAddButton().setOnAction(e -> handleAddButton());
    }

    /**
     * @author Amanda Agambire
     * handle the calculate button to get the
     * variables for the calorie formula
     */
    private void handleCalculateButton() {
        if (!validateInput()) {
            return;
        }
        else {
            double speed = parseDouble(theView.getTextFieldSpeed());
            String speedUnit = theView.getComboBoxSpeed();
            double weight = parseDouble(theView.getTextFieldWeight());
            String weightUnit = theView.getComboBoxWeight();
            double height = parseDouble(theView.getTextFieldHeight());
            String heightUnit = theView.getComboBoxHeight();
            double hours = parseDouble(theView.getTextFieldHours());
            double minutes = parseDouble(theView.getTextFieldMinutes());


            // Calculate calories based on the model
            calculatedCalories = theModel.calculateCalories(hours, minutes, speed, speedUnit, weight, weightUnit, height, heightUnit);

            // Display/print to console
            System.out.println("Calculated Calories: " + calculatedCalories);
        }
    }


    /**
     * @author Amanda Agambire
     * Clear the text fields when clear button clicked
     */
    private void handleClearButton() {
        theView.speedTextField.clear();
        theView.weightTextField.clear();
        theView.hoursTextField.clear();
        theView.minutesTextField.clear();
    }

    /**
     * @author Amanda Agambire
     *  Add the calculated calories to the line chart
     */
    private void handleAddButton() {
        theChart.updateLineChart(LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd")), calculatedCalories);

    }


    /**
     * @author Amanda Agambire
     * take user input by converting a string to double
     * @param text - input
     * @return double value
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
     * Creates a Warning alert with a given message to warn the
     * user of an input error
     * @param message - error message
     */
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Check Input ");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    /**
     * checks if any variables are 0
     * @return true/false depending on if input is valid or not
     */
    private boolean validateInput() {
        //get all variables
        double speed = parseDouble(theView.getTextFieldSpeed());
        double weight = parseDouble(theView.getTextFieldWeight());
        double height = parseDouble(theView.getTextFieldHeight());
        double hours = parseDouble(theView.getTextFieldHours());
        double minutes = parseDouble(theView.getTextFieldMinutes());


        // Check any variables = 0
        if (speed == 0 || weight == 0 || height == 0 || (hours == 0 && minutes == 0)) {
            // Alert the user to enter non-zero values
            showAlert("Please enter non-zero values for ALL input fields.");

            //return false so that the other calculations don't proceed
            return false;
        }

        return true;
    }




}

