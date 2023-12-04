package org.team1;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.team1.CalorieCalculator.CalorieCalculatorController;
import org.team1.CalorieCalculator.CalorieCalculatorModel;
import org.team1.CalorieCalculator.CalorieCalculatorView;
import org.team1.LineChartStats.LineChartStatsController;
import org.team1.LineChartStats.LineChartStatsModel;
import org.team1.LineChartStats.LineChartStatsView;
import org.team1.WorkoutCalendarApp;

public class FitnessAppCombinedView extends Application {
    /** Primary stage for layout */
    private Stage stage;
    /** Primary scene for layout */
    private Scene scene;

    /** Menu bar to be displayed for layout */
    private MenuBar menuBar;

    /** CalorieCalculator Model*/
    private CalorieCalculatorModel theModel;

    /** CalorieCalculator View*/
    private CalorieCalculatorView theView;

    /** CalorieCalculator Controller*/
    private CalorieCalculatorController theController;

    /** LineChartStats View*/
    private LineChartStatsView lineView;

    /** LineChartStats Model*/
    private LineChartStatsModel lineModel;

    /** LineChartStats Controller*/
    private LineChartStatsController lineController;


    private WorkoutCalendarApp calender;






    @Override
    public void init() throws Exception {
        super.init();
    }


    /**
     *
     * @param stage the primary stage for this application, onto which
     * the application scene can be set.
     * Applications may create other stages, if needed, but they will not be
     * primary stages.
     * @throws Exception
     */
    public void start(Stage stage) throws Exception {
         //Initialize instances for the Calorie Calculator
        this.stage = stage;

        this.theModel = new CalorieCalculatorModel();
        this.theView = new CalorieCalculatorView(theModel);
        this.theController = new CalorieCalculatorController(theModel, theView);
        this.lineModel = new LineChartStatsModel();
        this.lineView = new LineChartStatsView(lineModel);
        this.lineController = new LineChartStatsController( lineModel, lineView);
        this.calender = new WorkoutCalendarApp();


        // Create menu bar
        menuBar = createMenuBar();

        // Set the initial scene
        setScene(createSceneOne());

        // Set up the stage
        stage.setTitle("Fitness App");
        stage.show();


    }
    private MenuBar createMenuBar() {
        MenuItem viewOneMenuItem = new MenuItem("Calorie Calculator");
        viewOneMenuItem.setOnAction(e -> setScene(createSceneOne()));

        MenuItem viewTwoMenuItem = new MenuItem("Your Stats");
        viewTwoMenuItem.setOnAction(e -> setScene(createSceneTwo()));

        MenuItem viewThreeMenuItem = new MenuItem("Calender");
        viewThreeMenuItem.setOnAction(e -> setScene(createSceneThree()));

        Menu viewMenu = new Menu("View", null, viewOneMenuItem, viewTwoMenuItem, viewThreeMenuItem);
        //

        MenuItem exitMenuItem = new MenuItem("Exit");
        exitMenuItem.setOnAction(e -> Platform.exit());
        Menu fileMenu = new Menu("File", null, exitMenuItem);

        MenuBar menuBar = new MenuBar(fileMenu, viewMenu);
        menuBar.setMinSize(MenuBar.USE_PREF_SIZE, MenuBar.USE_PREF_SIZE);
        return menuBar;
    }

    private void setScene(BorderPane root) {
        scene = new Scene(root, 650, 300);
        root.setTop(menuBar);
        stage.setScene(scene);
    }

    private BorderPane createSceneOne() {
        return new BorderPane(theView.getRoot());
    }

    private BorderPane createSceneTwo() {

        return new BorderPane(lineView.getChartRoot());
    }
    private BorderPane createSceneThree() {
        BorderPane borderPane = new BorderPane();
        calender.start(stage);
        borderPane.setCenter(calender.getRoot());
        return borderPane;
    }

    public static void main(String[] args) {
        launch(args);
    }
}



