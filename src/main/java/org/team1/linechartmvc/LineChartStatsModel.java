/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2023
 * Instructor: Prof. Brian King / Prof. Joshua Stough
 *
 * Name: Amanda Agambire
 * Section: 9am
 * Date: 11/30/23
 * Time: 5:12 PM
 *
 * Project: csci205_final_project
 * Package: org.team1.linechartmvc
 * Class: LineChartStatsModel
 *
 * Description:
 *
 * ****************************************
 */
package org.team1.linechartmvc;

import javafx.scene.Scene;
import javafx.scene.chart.Axis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.util.List;

public class LineChartStatsModel {

    /** the  line chart that displays teh user's calories over time*/
    public LineChart<String, Number> lineChart;

    /** the X axis of the line chart which records the date as strings */
    public Axis<String> xAxis;

    /** the Y axis of the line chart which records the calories as numbers */
    public Axis<Number> yAxis;

    /** series of data items */
    public XYChart.Series series;

    /** Line chart data items stored as a list */
    public List<XYChart.Data<String, Number>> dataList;


    /**
     * Instantiate the key components of the line Chart
     *
     * @author Amanda Agambire
     */
    public LineChartStatsModel() {
        this.xAxis = new CategoryAxis();
        this.yAxis = new NumberAxis();
        this.lineChart = new LineChart<>(xAxis, yAxis);
        this.series = new XYChart.Series();
        this.dataList = series.getData();
    }

    /**
     * A method that sets a tile for the line chart and
     * adds data points to the chart
     *
     * @author Amanda Agambire
     * @return - the line chart
     */
    public LineChart<String, Number> generateLineChart(){
        lineChart.setTitle("Calorie Tracker");
        series.setName("Calories");
        series.getData().add(new XYChart.Data("10/12", 362));
        series.getData().add(new XYChart.Data("10/13", 222));
        series.getData().add(new XYChart.Data("10/14", 156));
        series.getData().add(new XYChart.Data("10/15", 156));
        series.getData().add(new XYChart.Data("10/16", 1133));
        series.getData().add(new XYChart.Data("10/17", 120));
        series.getData().add(new XYChart.Data("10/18", 91));
        series.getData().add(new XYChart.Data("10/19", 45));
        series.getData().add(new XYChart.Data("10/20", 430));

        lineChart.getData().add(series);
        return lineChart;
    }

    /**
     * Update the line Chart by adding the new calories to the sum
     *  of on a given date
     *
     * @author Amanda Agambire
     * @param date - the X data point
     * @param calories - the Y data point
     */
    public void updateLineChart(String date, double calories) {

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

    /**
     * Set up an update Chart tab that allows the user to
     * input new calorie values that can be added to the chart
     *
     * @author Amanda Agambire
     * @param updateRoot - the root the update line chart tab
     */
    public void updateChart(VBox updateRoot) {
        Stage updateStage = new Stage();
        updateStage.setTitle("Update Calorie Tracker");
        updateStage.setScene(new Scene(updateRoot, 400, 300));
        updateStage.show();
    }

}


