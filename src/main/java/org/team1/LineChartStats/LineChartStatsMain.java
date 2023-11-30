package org.team1.LineChartStats;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class LineChartStatsMain extends Application {

    private LineChartStatsModel theModel;
    private LineChartStatsView theView;
    private LineChartStatsController theController;

    public void init() throws Exception {
        super.init();
        this.theModel = new LineChartStatsModel();
        this.theView = new LineChartStatsView(theModel);
        this.theController = new LineChartStatsController(theModel, theView);
    }

    public static void main(String[] args) {
        launch(args);
    }


    @Override public void start(Stage stage) {
        Scene scene = new Scene(this.theView.getChartRoot(), 800, 600);
        stage.setTitle("Tracker");
        stage.setScene(scene);
        stage.show();
    }
}



