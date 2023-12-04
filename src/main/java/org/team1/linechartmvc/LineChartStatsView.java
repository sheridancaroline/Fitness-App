/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2023
 * Instructor: Prof. Brian King / Prof. Joshua Stough
 *
 * Name: Amanda Agambire
 * Section: 9am
 * Date: 11/30/23
 * Time: 5:13 PM
 *
 * Project: csci205_final_project
 * Package: org.team1.linechartmvc
 * Class: LineChartStatsView
 *
 * Description:
 *
 * ****************************************
 */
package org.team1.linechartmvc;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;


public class LineChartStatsView extends Node {

    /** The line chart model*/
    private LineChartStatsModel theModel;

    /** The line chart Vbox root */
    private VBox chartRoot;

    /** The line chart update Tab Vbox root */
    private VBox updateRoot;

    /** TextField */
    private TextField updateCals;

    /** Button */
    private Button updateSaveButton;

    /** Button */
    private Button updateButton;


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
     * get update Button
     * @return - updateButton
     */
    public Button getUpdateButton() {
        return updateButton;
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
     *
     * @author Amanda Agambire
     * @param theModel - linechart model
     */
    public LineChartStatsView(LineChartStatsModel theModel) {
        this.theModel = theModel;
        chartRoot = new VBox();
        initSceneGraph();
    }


    /**
     * Initialize the entire scene graph
     *
     * @author Amanda Agambire
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
        Label updateCalsLabel = new Label("Calories");
        updateSaveButton = new Button("SAVE");

        //Add to update root
        updateRoot.getChildren().addAll(updateCals, updateCalsLabel, updateSaveButton);
    }


}


