/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2023
 * Instructor: Prof. Brian King
 *
 * Name: Amanda Agambire
 * Section: 01
 * Date: 11/10/23
 * Time: 9:09 AM
 *
 * Project: csci205_final_project
 * Package: org.team1
 * Class: CalorieCalculator
 *
 * Description:
 *
 * ****************************************
 */
package org.team1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CalorieCalculatorView extends Application {
    private CalorieCalculatorModel theModel;

    public VBox getRoot() {
        return root;
    }

    private VBox root;

    /** FlowPane */
    private FlowPane topPane;

    /** TextField  */
    private TextField textFieldTempInput;

    /** Label  */
    private Label lblResult;


    /** Button  */
    private Button btnConvert;
    public CalorieCalculatorView(CalorieCalculatorModel theModel) {
        this.theModel = theModel;
        initSceneGraph();
        initStyling();
    }

    public static void main(String[] args) {
        launch(args);
    }
    /**
     * The main entry point for all JavaFX applications.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        initSceneGraph();

        // Apply styling to our scene graph nodes
        initStyling();

        // Initialize Event handlers
        initEventHandlers();

        // add the scene graph to the stage
        primaryStage.setScene(new Scene(this.root));

        // automatically resizes the window to show content on the stage
        primaryStage.sizeToScene();

        // set the title
        primaryStage.setTitle("Calories burned calculator");

        // display the stage
        primaryStage.show();
    }

    /**
     * Initialize the entire scene graph
     */
    private void initEventHandlers() {

    }

    /**
     * Initialize the styling for the content in the scene graph
     */
    private void initStyling() {
        root.setSpacing(5);
        root.setPrefWidth(250);
        root.setPadding(new Insets(10, 5, 10, 5));
        root.setAlignment(Pos.CENTER);
    }

    /**
     * Initializing event handlers
     */
    private void initSceneGraph() {
        root = new VBox();

        topPane = new FlowPane();

        textFieldTempInput = new TextField()
;
        //Label
        topPane.getChildren().add(new Label( " Calories Burned Calculator "));
        root.getChildren().add(topPane);


    }
}
