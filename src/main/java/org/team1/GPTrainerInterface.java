package org.team1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GPTrainerInterface extends Application {

    private VBox root;
    private HBox topPane;
    private TextField textFieldInputName;
    private Button btn;
    private Text textNameOutput;

    public void initSceneGraph(){
        this.root = new VBox();
        this.root.setSpacing(10);
        this.root.setPadding(new Insets(15));
        this.root.setAlignment(Pos.CENTER);

//
        this.topPane = new HBox();
        this.topPane.setSpacing(10);
        this.topPane.setAlignment(Pos.CENTER);
        root.getChildren().add(this.topPane);
//

        this.topPane.getChildren().add(new Label("Please ask your question and I'll assist how I can:"));
        this.textFieldInputName = new TextField();
        this.topPane.getChildren().add(this.textFieldInputName);


        this.btn = new Button("Ask GPTrainer");
        root.getChildren().add(this.btn);
//
        root.getChildren().add(new Separator());
//
        this.textNameOutput = new Text();
        this.textNameOutput.setFont(Font.font(null, FontWeight.BOLD, 30));
        this.textNameOutput.setFill(Color.AQUAMARINE);

        //Setting up reflection & dropshadow
        Reflection reflection = new Reflection();
        reflection.setFraction(0.9);


        this.textNameOutput.setEffect(reflection);

        root.getChildren().add(this.textNameOutput);


        btn.setOnAction((event -> {
            String name = this.textFieldInputName.getText();
            System.out.println("Hello, "+ name +"!");
            this.textNameOutput.setText(name);
        }));


    }
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        initSceneGraph();

        primaryStage.setScene(new Scene(this.root));

        primaryStage.sizeToScene();

        primaryStage.setTitle("Person GPTrainer!");

        primaryStage.show();

    }
}
