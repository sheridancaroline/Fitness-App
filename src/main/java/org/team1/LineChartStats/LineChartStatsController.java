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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LineChartStatsController {
    /**The line Chart view in the MVC */
    private LineChartStatsView theView;

    /**The line Chart model in the MVC */
    private LineChartStatsModel theModel;

    /**
     * construct an instance of the line Chart model and view
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
      */
    private void initEventHandlers() {
        //Update the chart when save is clicked
        theView.updateButton.setOnAction(e -> theModel.updateChart(theView.getUpdateRoot()));

        theView.getSaveButton().setOnAction(e -> handleSaveButton());
    }

    /**
     * Handle the save button by adding calories to the  line chart when
     * the user updates the Chart
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


