package org.team1.CalorieCalculator;

import javafx.event.ActionEvent;
import org.team1.LineChartStats.LineChartStatsMain;
import org.team1.LineChartStats.LineChartStatsView;
import org.team1.Sex;
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
     * Assign ac
     */
    private void initEventHandlers() {
        theView.getCalculateButton().setOnAction(e -> handleCalculateButton());
        theView.getClearButton().setOnAction(e -> handleClearButton());
        //theView.getAddButton().setOnAction(e -> handleAddButton());
    }

    private void handleCalculateButton() {
        //WorkoutType selectedActivity = theView.getComboBoxActivity();
        double speed = parseDouble(theView.getTextFieldSpeed());
        String speedUnit = theView.getComboBoxSpeed();
        double weight = parseDouble(theView.getTextFieldWeight());
        String weightUnit = theView.getComboBoxWeight();
        double height = parseDouble(theView.getTextFieldHeight());
        String heightUnit = theView.getComboBoxHeight();
        double hours = parseDouble(theView.getTextFieldHours());
        double minutes = parseDouble(theView.getTextFieldMinutes());

        // Assume we have a 'User' instance obtained from initial login!! this should be temporary
        //User user = new User(Sex.MALE, 82,2.5);

        // Calculate calories based on the model
        calculatedCalories = theModel.calculateCalories( hours, minutes, speed, speedUnit, weight, weightUnit, height, heightUnit);

        // Display/print to console
        System.out.println("Calculated Calories: " + calculatedCalories);
    }
    private void handleClearButton() {
        theView.speedTextField.clear();
        theView.weightTextField.clear();
        theView.hoursTextField.clear();
        theView.minutesTextField.clear();

    }
    private void handleAddButton() {

        theChart.updateLineChart(LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd")), calculatedCalories);

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

