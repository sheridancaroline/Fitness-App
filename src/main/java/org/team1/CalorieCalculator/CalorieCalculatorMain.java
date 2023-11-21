package org.team1.CalorieCalculator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalorieCalculatorMain extends Application {
    private CalorieCalculatorModel theModel;
    private CalorieCalculatorView theView;
    private CalorieCalculatorController theController;
    @Override
    public void init() throws Exception {
        super.init();
        this.theModel = new CalorieCalculatorModel();
        this.theView = new CalorieCalculatorView(theModel);
        this.theController = new CalorieCalculatorController(theModel, theView);
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(this.theView.getRoot(),650,300);
//        scene.getStylesheets().add(
//                getClass().getResource("/lab10/tempconvertermvc.css")
//                        .toExternalForm());
        primaryStage.setTitle("Calories burned calculator");
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();

        //initSceneGraph();
        //initStyling();
        //initEventHandlers();
    }
}
