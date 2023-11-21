package org.team1.CalorieCalculator;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.team1.Sex;
import org.team1.User;
import org.team1.WorkoutType;

public class CalorieCalculatorController {
    private CalorieCalculatorModel theModel;
    private CalorieCalculatorView theView;

    public CalorieCalculatorController(CalorieCalculatorModel theModel, CalorieCalculatorView theView) {
        this.theModel = theModel;
        this.theView = theView;

        initEventHandlers();
        //initBindings();
    }

    private void initEventHandlers() {
        //theView.getComboBoxSpeed().setOnAction(e -> handleOptionSelected(theView.getSpeedComboBox(), "Selected Speed/Pace "));
        //theView.getComboBoxDistance().setOnAction(e -> handleOptionSelected(theView.getDistanceComboBox(), "Selected Distance"));
        theView.getCalculateButton().setOnAction(e -> handleCalculateButton());
        theView.getClearButton().setOnAction(e -> handleClearButton());
    }
//    private void handleOptionSelected(ComboBox<String> comboBox, String message) {
//        String selectedValue = comboBox.getValue();
//        System.out.println(message + ": " + selectedValue);
//        // You can perform additional actions based on the selected value if needed
//    }
    private void handleCalculateButton() {
        WorkoutType selectedActivity = theView.getComboBoxActivity();
        double speed = parseDouble(theView.getTextFieldSpeed());
        String speedUnit = theView.getComboBoxSpeed();
        double distance = parseDouble(theView.getTextFieldDistance());
        String distanceUnit = theView.getComboBoxDistance();
        double hours = parseDouble(theView.getTextFieldHours());
        double minutes = parseDouble(theView.getTextFieldMinutes());

        // Assume we have a 'User' instance obtained from initial login!! this should be temporary
        User user = new User(Sex.MALE, 82);

        // Calculate calories based on the model
        double calculatedCalories = theModel.calculateCalories(user, selectedActivity, hours, minutes, speed, speedUnit, distance, distanceUnit);

        // Display/print to console
        System.out.println("Calculated Calories: " + calculatedCalories);
    }
    private void handleClearButton() {
        theView.speedTextField.clear();
        theView.distanceTextField.clear();
        theView.hoursTextField.clear();
        theView.minutesTextField.clear();

    }


    private double parseDouble(String text) {
        try {
            return Double.parseDouble(text);
        } catch (NumberFormatException e) {
            // Default value for invalid input
            return 0.0;
        }
    }


    private void initBindings() {
    }

    public void handleActionEvent(ActionEvent event) {
        //TODO related to validating input
//        try {
//            String s = this.theView.getTextFieldTempInput().getText();
//            // only convert if something has been entered
//            if (!s.isEmpty()) {
//                String result = this.theModel.strTempConvert(s);
//                this.theView.getLblResult().setText(result);
//            }
//        }
//        catch (NumberFormatException e) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Incorrect input!");
//            alert.setHeaderText("Incorrect input specified!");
//            alert.setContentText(String.format("Can not convert \"%s\"",
//                    this.theView.getTextFieldTempInput().getText()));
//            alert.show();
//        }
//    }
    }

}

