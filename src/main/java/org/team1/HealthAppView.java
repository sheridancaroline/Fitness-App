package org.team1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HealthAppView extends Application {

    private VBox loginRoot;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        initSceneGraph();

        Scene scene = new Scene(getLoginRoot(), 500, 480);

        primaryStage.setTitle("Running App");
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();

    }

    public VBox getLoginRoot() {
        return loginRoot;
    }

    public HealthAppView(){
        initSceneGraph();
    }

    private void initSceneGraph() {

        loginRoot = new VBox();

        Label lblHeading = new Label("Member Login");
        lblHeading.setId("lblHeading");

        lblHeading.setStyle("-fx-pref-width: 500;" +
                            "-fx-pref-height: 50;" +
                            "-fx-font-size: 20;" +
                            "-fx-alignment: center;"
        );

        lblHeading.setAlignment(Pos.CENTER);

        loginRoot.getChildren().add(lblHeading);




    }
}
