package org.team1.LineChartStats;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.Axis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class LineChartStatsView extends Node {
    private LineChart<String, Number> lineChart;
    Axis<String> xAxis = new CategoryAxis();
    Axis<Number> yAxis = new NumberAxis();
    private XYChart.Series series;

    private VBox chartRoot;
    private VBox updateRoot;

    private TextField updateCals;
    private Label updateCalsLabel;
    Button updateButton;
    private Button updateSaveButton;

    public VBox getChartRoot() {
        return chartRoot;
    }

    public LineChartStatsView(LineChartStatsModel theModel) {
        chartRoot = new VBox();
        initSceneGraph();
//        initStyling();
    }

    private void initSceneGraph() {
        updateButton = new Button("UPDATE");
        chartRoot.getChildren().add(updateButton);


        lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Calorie Tracker");

        chartRoot.getChildren().add(lineChart);

        series = new XYChart.Series();
        series.setName("Calories");
        series.getData().add(new XYChart.Data("1/12", 362));
        series.getData().add(new XYChart.Data("5/13", 222));
        series.getData().add(new XYChart.Data("9/14", 156));
        series.getData().add(new XYChart.Data("9/15", 156));
        series.getData().add(new XYChart.Data("10/16", 1133));
        series.getData().add(new XYChart.Data("10/17", 120));
        series.getData().add(new XYChart.Data("10/18", 91));
        series.getData().add(new XYChart.Data("10/19", 45));
        series.getData().add(new XYChart.Data("10/20", 430));

        lineChart.getData().add(series);

        // Initialize updateRoot
        updateRoot = new VBox();
        updateCals = new TextField();
        updateCals.setPromptText("Calories");
        updateCals.setFocusTraversable(false);

        updateCalsLabel = new Label("Calories");

        updateSaveButton = new Button("SAVE");
        updateSaveButton.setOnAction(e -> {
            try {
                double currentCals = Double.parseDouble(updateCals.getText());
                updateLineChart(LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd")), currentCals);
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a valid number for calories");
            }
        });

        updateRoot.getChildren().addAll(updateCals, updateCalsLabel, updateSaveButton);

    }

    public void updateChart() {
        Stage updateStage = new Stage();
        updateStage.setTitle("Update Calorie Tracker");
        updateStage.setScene(new Scene(updateRoot, 400, 300));
        updateStage.show();
    }

    public void updateLineChart(String date, double calories) {
        List<XYChart.Data<String, Number>> dataList = series.getData();

        // Check if a data point with the same date already exists
        for (int i = 0; i < dataList.size(); i++) {
            XYChart.Data<String, Number> data = dataList.get(i);
            if (data.getXValue().equals(date)) {
                // Update the existing data point
                Number existingCalories = data.getYValue();
                double updatedCalories = existingCalories.doubleValue() + calories;
                data.setYValue(updatedCalories);

                // Make sure we exit the method after updating
                return;
            }
        }
        //  no existing data point with the same date  ->  add a new data point
        dataList.add(new XYChart.Data<>(date, calories));

    }
}


