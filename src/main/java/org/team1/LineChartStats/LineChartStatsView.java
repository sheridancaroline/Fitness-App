/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2023
 * Instructor: Brian King
 * Secction: 9am
 * Lab Section: 01
 *
 * Name: Amanda Agambire
 * Date: 08/25/2023
 *
 * Lab/ Assignment: CSCI Final Project
 *
 * Description:
 *
 * *****************************************/
package org.team1.LineChartStats;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.team1.CalorieCalculator.CalorieCalculatorModel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class LineChartStatsView extends Node {
    /** The line chart model*/
    private LineChartStatsModel theModel;

    /** The line chart Vbox root */
    private VBox chartRoot;

    /** The line chart update Tab Vbox root */
    private VBox updateRoot;


    /** TextField */
    private TextField updateCals;

    /** Label */
    private Label updateCalsLabel;

    /** Button */
    private Button updateSaveButton;

    /** Button */
    Button updateButton;


    /**
     * get Chart Root
      * @return chartRoot
     */
    public VBox getChartRoot() {
        return chartRoot;
    }
    /**
     * get Update Root
     * @return updateRoot
     */
    public VBox getUpdateRoot() {
        return updateRoot;
    }

    /**
     * get Update Cals
     * @return updateCals
     */
    public TextField getUpdateCals() {
        return updateCals;
    }

    /**
     * get Update Calorie Label
     * @return - updateCalsLabel
     */
    public Label getUpdateCalsLabel() {
        return updateCalsLabel;
    }
    /**
     * get  Save Button
     * @return - updateSaveButton
     */
    public Button getSaveButton() {
        return updateSaveButton;
    }

    /**
     * Construct a new instance of the linechart model
     * @param theModel - linechart model
     */
    public LineChartStatsView(LineChartStatsModel theModel) {
        this.theModel = theModel;
        chartRoot = new VBox();
        initSceneGraph();

    }


    /**
     * Initialize the entire scene graph
     */
    private void initSceneGraph() {
        updateButton = new Button("UPDATE");
        chartRoot.getChildren().add(updateButton);
        theModel.generateLineChart();
        chartRoot.getChildren().add(theModel.lineChart);


        // Initialize updateRoot
        updateRoot = new VBox();
        updateCals = new TextField();
        updateCals.setPromptText("Calories");
        updateCals.setFocusTraversable(false);

        //create update label and button
        updateCalsLabel = new Label("Calories");
        updateSaveButton = new Button("SAVE");

        //Add to update root
        updateRoot.getChildren().addAll(updateCals, updateCalsLabel, updateSaveButton);

    }


}


