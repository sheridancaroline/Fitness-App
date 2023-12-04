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
 * Class: LineChartStatsController
 *
 * Description: This is the MVC controller class for
 * lineChart program
 *
 * ****************************************
 */
package org.team1.linechartmvc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LineChartStatsController {

    /**The line Chart view in the MVC */
    private LineChartStatsView theView;

    /**The line Chart model in the MVC */
    private LineChartStatsModel theModel;


    /**
     * construct an instance of the line Chart model and view
     *
     * @author Amanda Agambire
     * @param theModel - the line chart model
     * @param theView - the line chart view
     */
    public LineChartStatsController( LineChartStatsModel theModel, LineChartStatsView theView) {
        this.theModel = theModel;
        this.theView = theView;
        initEventHandlers();
    }


    /**
     * An event handler that handle user action on the save and Calculate button
     *
     * @author Amanda Agambire
     */
    private void initEventHandlers() {
        //Update the chart when save is clicked
        theView.getUpdateButton().setOnAction(e -> theModel.updateChart(theView.getUpdateRoot()));

        theView.getSaveButton().setOnAction(e -> handleSaveButton());
    }


    /**
     * Handle the save button by adding calories to the  line chart when
     * the user updates the Chart
     *
     * @author Amanda Agambire
     */
    private void handleSaveButton() {
        try {
            double currentCals = Double.parseDouble(theView.getUpdateCals().getText());
            theModel.updateLineChart(LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd")), currentCals);
        } catch (NumberFormatException ex) {
            System.out.println("Please enter a valid number for calories");
        }
    };


}
