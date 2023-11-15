package org.team1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.time.LocalDate;


public class LineChartStats extends Application {
    private LineChart<String,Number> lineChart;
    private XYChart.Series series;

    @Override public void start(Stage stage) {
        stage.setTitle("Tracker");

        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Date");

        lineChart = new LineChart<>(xAxis,yAxis);
        lineChart.setTitle("Calorie Tracker");

        series = new XYChart.Series();
        series.setName("Calories");

        series.getData().add(new XYChart.Data("11/12", 362));
        series.getData().add(new XYChart.Data("11/13", 222));
        series.getData().add(new XYChart.Data("11/14", 156));
        series.getData().add(new XYChart.Data("11/15", 156));
        series.getData().add(new XYChart.Data("11/16", 1133));
        series.getData().add(new XYChart.Data("11/17", 120));
        series.getData().add(new XYChart.Data("11/18", 91));
        series.getData().add(new XYChart.Data("11/19", 45));
        series.getData().add(new XYChart.Data("11/20", 430));


        Scene scene  = new Scene(lineChart,800,600);
        Button addButton = new Button("Update");
        //TODO create a new window to update chart
        //addButton.setOnAction(e -> UpdateWindow());

        lineChart.getData().add(series);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

