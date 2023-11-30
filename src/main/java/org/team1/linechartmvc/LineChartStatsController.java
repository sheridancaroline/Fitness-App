/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2023
 * Instructor: Prof. Brian King / Prof. Joshua Stough
 *
 * Name: Dong Hyun Roh
 * Section: 9am
 * Date: 11/30/23
 * Time: 5:12 PM
 *
 * Project: csci205_final_project
 * Package: org.team1.linechartmvc
 * Class: LineChartStatsController
 *
 * Description:
 *
 * ****************************************
 */
package org.team1.linechartmvc;

public class LineChartStatsController {
    private LineChartStatsView theView;
    private LineChartStatsModel theModel;
    public LineChartStatsController( LineChartStatsModel theModel, LineChartStatsView theView) {
        this.theModel = theModel;
        this.theView = theView;
        initEventHandlers();
    }

    private void initEventHandlers() {
        theView.updateButton.setOnAction(e -> theView.updateChart());

        //theView.getClearButton().setOnAction(e -> handleClearButton());
    }


}

