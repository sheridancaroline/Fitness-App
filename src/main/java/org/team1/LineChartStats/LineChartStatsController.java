package org.team1.LineChartStats;

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

