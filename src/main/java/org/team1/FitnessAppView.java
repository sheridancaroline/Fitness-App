package org.team1;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FitnessAppView extends Application {
    private BorderPane layout;
    private final Node CalorieCalculatorPage = new CalorieCalculatorPage();
    private final Node viewTwo = new ViewTwo();

//    public static void main(String[] args) {
//        launch(args);
//    }

    public void start(Stage stage) throws Exception {
        // View menu
        MenuItem viewOneMenuItem = new MenuItem("Calorie Calculator");
        viewOneMenuItem.setOnAction(e -> setView(CalorieCalculatorPage));
        MenuItem viewTwoMenuItem = new MenuItem("Your Stats");
        viewTwoMenuItem.setOnAction(e -> setView(viewTwo));
        Menu viewMenu = new Menu(
                "View", null,
                viewOneMenuItem, viewTwoMenuItem
        );

        // File menu
        MenuItem exitMenuItem = new MenuItem("Exit");
        exitMenuItem.setOnAction(e -> Platform.exit());
        Menu fileMenu = new Menu(
                "File", null,
                exitMenuItem
        );

        MenuBar menuBar = new MenuBar(
                fileMenu, viewMenu
        );
        menuBar.setMinSize(MenuBar.USE_PREF_SIZE, MenuBar.USE_PREF_SIZE);

        // Layout scene
        layout = new BorderPane();
        layout.setTop(menuBar);
        setView(CalorieCalculatorPage);

        stage.setScene(
                new Scene(layout, 300, 200)
        );
        stage.show();
    }

    private void setView(Node view) {
        layout.setCenter(view);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class CalorieCalculatorPage extends StackPane {
    public CalorieCalculatorPage() {
        setStyle("-fx-background-color: lightblue; -fx-font-size: 30px;");
        getChildren().add(new Label("View One"));
    }
}

class ViewTwo extends StackPane {
    public ViewTwo() {
        setStyle("-fx-background-color: cornsilk; -fx-font-size: 30px;");
        getChildren().add(new Label("View Two"));
    }
}

