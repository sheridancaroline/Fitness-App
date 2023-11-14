/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2023
 * Instructor: Prof. Brian King / Prof. Joshua Stough
 *
 * Name: Dong Hyun Roh
 * Section: 9am
 * Date: 11/10/23
 * Time: 1:11 PM
 *
 * Project: csci205_final_project
 * Package: org.team1.fitnessappmvc
 * Class: FitnessAppView
 *
 * Description:
 *
 * ****************************************
 */
package org.team1.fitnessappmvc;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;


public class FitnessAppView {

    /** The model that contains the data and logic behind this view */
    private FitnessAppModel theModel;

    private VBox root;

    private VBox loginRoot;

    private VBox signupRoot;

    private TextField textFieldUsername;

    private TextField textFieldPassword;

    private TextField textFieldConfirmPassword;

    private Button btnLogin;

    private Button btnSignup;

    private Button btnGuest;

    private Button btnCreateNewAccount;


    public FitnessAppView(FitnessAppModel theModel){

        this.theModel = theModel;

        root = new VBox();

        initSceneGraph();
        initStyling();
    }

    public VBox getLoginRoot() {
        return loginRoot;
    }

    public VBox getSignupRoot() {
        return signupRoot;
    }

    public VBox getRoot(){
        return root;
    }

    public TextField getTextFieldUsername() {
        return textFieldUsername;
    }

    public TextField getTextFieldPassword() {
        return textFieldPassword;
    }

    public Button getBtnLogin() {
        return btnLogin;
    }

    public Button getBtnSignup() {
        return btnSignup;
    }

    public Button getBtnGuest() {
        return btnGuest;
    }

    public Scene getSignupScene(){
        return new Scene(getSignupRoot());
    }

    public Scene getLoginScene(){
        return new Scene(getLoginRoot());
    }

    private void initStyling() {

        loginRoot.setAlignment(Pos.CENTER);

        loginRoot.setPrefSize(350, 500);
        loginRoot.setPadding(new Insets(40,40,40,40));
        loginRoot.setSpacing(10);


        signupRoot.setAlignment(Pos.CENTER);

        signupRoot.setPrefSize(350,500);
        signupRoot.setPadding(new Insets(40,40,40,40));
        signupRoot.setSpacing(10);

    }

    private void initSceneGraph() {

        initLoginPage();
        initSignupPage();

    }

    private void initLoginPage(){

        loginRoot = new VBox();

        Label lblLoginHeading = new Label("Member Login");
        lblLoginHeading.setId("lblLoginHeading");

        VBox usernameBox = new VBox();
        VBox passwordBox = new VBox();

        Label lblUsername = new Label("Username");
        textFieldUsername = new TextField();

        usernameBox.getChildren().addAll(lblUsername, textFieldUsername);

        Label lblPassword = new Label("Password");
        textFieldPassword = new TextField();

        passwordBox.getChildren().addAll(lblPassword, textFieldPassword);

        loginRoot.getChildren().addAll(lblLoginHeading, usernameBox, passwordBox);

        btnLogin = new Button("Login");
        btnSignup = new Button("Signup");

        loginRoot.getChildren().addAll(btnLogin, btnSignup);

        loginRoot.getChildren().add(new Separator());

        btnGuest = new Button("Continue as a guest");

        loginRoot.getChildren().add(btnGuest);


    }

    public void initSignupPage(){

        signupRoot = new VBox();

        Label lblSignupHeading = new Label("Signup");
        lblSignupHeading.setId("lblSignupHeading");

        signupRoot.getChildren().add(lblSignupHeading);

        VBox userInformationBox = new VBox();

        Label lblUsername = new Label("Username");
        Button btnVerifyUsername = new Button("Verify");
        textFieldUsername = new TextField();


        Label lblPassword = new Label("Password");
        textFieldPassword = new TextField();

        Label lblConfirmPassword = new Label("Confirm Password");
        textFieldConfirmPassword = new TextField();

        btnCreateNewAccount = new Button("Create a new account");

        userInformationBox.getChildren().addAll(lblUsername, textFieldUsername, btnVerifyUsername);
        userInformationBox.getChildren().addAll(lblPassword, textFieldPassword);
        userInformationBox.getChildren().addAll(lblConfirmPassword, textFieldConfirmPassword);
        userInformationBox.getChildren().addAll(new Separator(), btnCreateNewAccount);

        signupRoot.getChildren().add(userInformationBox);


    }


}
