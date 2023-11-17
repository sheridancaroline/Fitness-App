package org.team1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class LineChartStats extends Application {
    private LineChart<String,Number> lineChart;
    private XYChart.Series series;
    private VBox chartRoot;
    private VBox updateRoot;
    private TextField updateCals;
    private Label updateCalsLabel;
    private Button updateButton;
    private Button updateSaveButton;


    @Override public void start(Stage stage) {
        stage.setTitle("Tracker");

        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Date");

        chartRoot = new VBox();
        updateButton = new Button("UPDATE");
        chartRoot.getChildren().add(updateButton);

        lineChart = new LineChart<>(xAxis,yAxis);
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



        Scene scene  = new Scene(chartRoot,800,600);
        //String currentDate = new DatePicker(LocalDate.now()).getValue().toString();
        updateButton.setOnAction(e ->  updateChart());

        lineChart.getData().add(series);

        stage.setScene(scene);
        stage.show();
    }

    private void updateChart() {
        updateRoot = new VBox();
        Stage updateStage = new Stage();
        updateStage.setTitle("Update Calorie Tracker");
        updateStage.setScene(new Scene(updateRoot,400,300));

        //String currentDate = new DatePicker(LocalDate.now()).getValue().toString();
        DateTimeFormatter dateFormat= DateTimeFormatter.ofPattern("MM/dd");
        String currentDate = LocalDate.now().format(dateFormat);

        updateCals = new TextField();
        updateCals.setPromptText("Calories");
        updateCals.setFocusTraversable(false);

        updateCalsLabel = new Label("Caloies");

        updateSaveButton = new Button("SAVE");
        updateSaveButton.setOnAction(e -> {
            //String currentCals = updateCals.getText();
            try {
                double currentCals = Double.parseDouble(updateCals.getText());
                updateLineChart(currentDate, currentCals);
                updateStage.close();
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a valid number for calories");
            }
        });



        updateRoot.getChildren().addAll(updateCals, updateCalsLabel, updateSaveButton);

        updateStage.show();


    }
    private void updateLineChart(String date, double calories) {
       // XYChart.Data<String, Number> newData = new XYChart.Data<>(calories, date);
        series.getData().add(new XYChart.Data(date, calories));
        //lineChart.getData().add(series);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

