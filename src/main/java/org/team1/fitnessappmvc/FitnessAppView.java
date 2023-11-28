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
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

/**
 * This is the "view" in the MVC design for the fitness application.
 * Initializes all nodes for the scene graph for this view.
 */
public class FitnessAppView {

    /** The model that contains the data and logic behind this view */
    private FitnessAppModel theModel;

    private VBox root;

    // Controls used in the login page
    private VBox loginRoot;
    private TextField textFieldUsername;
    private TextField textFieldPassword;
    private Button btnLogin;
    private Button btnSignup;
    private Button btnGuest;


    // Controls used in the signup page
    private VBox signupRoot;
    private TextField textFieldUsername2;
    private TextField textFieldPassword2;
    private TextField textFieldConfirmPassword;
    private Button btnCreateNewAccount;
    private Button btnVerifyUsername;
    private RadioButton rbMale;
    private RadioButton rbFemale;


    /**
     * Constructs the FitnessAppView, initializing with the given model.
     *
     * @param theModel The model associated with this view.
     */
    public FitnessAppView(FitnessAppModel theModel){

        this.theModel = theModel;

        root = new VBox();

        initSceneGraph();
        initStyling();
    }

    public VBox getLoginRoot() {

        root = loginRoot;
        return loginRoot;
    }

    public VBox getSignupRoot() {

        root = signupRoot;
        return signupRoot;
    }

    public VBox getRoot(){
        return root;
    }

    public String getTextFieldUsername() {
        return textFieldUsername.getText();
    }

    public String getTextFieldUsername2() {
        return textFieldUsername2.getText();
    }

    public String getTextFieldPassword() {
        return textFieldPassword.getText();
    }

    public String getTextFieldPassword2() {
        return textFieldPassword2.getText();
    }

    public String getTextFieldConfirmPassword() { return textFieldConfirmPassword.getText(); }

    public Button getBtnLogin() {
        return btnLogin;
    }

    public Button getBtnSignup() {
        return btnSignup;
    }

    public Button getBtnGuest() {
        return btnGuest;
    }

    public Button getBtnCreateNewAccount() { return btnCreateNewAccount; }

    public Button getBtnVerifyUsername() { return btnVerifyUsername; }

    public RadioButton getRbMale() { return rbMale; }

    public RadioButton getRbFemale() { return rbFemale; }

    public Scene getSignupScene(){
        return new Scene(getSignupRoot());
    }

    public Scene getLoginScene(){
        return new Scene(getLoginRoot());
    }

    /**
     * @author Dong Hyun Roh
     */
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

    /**
     * Initialize the entire scene graph
     */
    private void initSceneGraph() {

        initLoginPage();
        initSignupPage();
    }

    /**
     * @author Dong Hyun Roh
     */
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

    /**
     * @author Dong Hyun Roh
     */
    public void initSignupPage(){

        signupRoot = new VBox();

        Label lblSignupHeading = new Label("Signup");
        lblSignupHeading.setId("lblSignupHeading");

        signupRoot.getChildren().add(lblSignupHeading);

        VBox userInformationBox = new VBox();

        Label lblUsername = new Label("Username");
        btnVerifyUsername = new Button("Verify");
        textFieldUsername2 = new TextField();

        Label lblPassword = new Label("Password");
        textFieldPassword2 = new TextField();

        Label lblConfirmPassword = new Label("Confirm Password");
        textFieldConfirmPassword = new TextField();

        // radio button group to allow the user to select gender
        ToggleGroup group = new ToggleGroup();
        rbMale = new RadioButton("Male");
        rbFemale = new RadioButton("Female");
        rbMale.setToggleGroup(group);
        rbFemale.setToggleGroup(group);
        rbMale.setSelected(true);

        VBox genderBox = new VBox();
        genderBox.getChildren().addAll(rbMale, rbFemale);

        signupRoot.getChildren().add(genderBox);

        btnCreateNewAccount = new Button("Create a new account");
        btnCreateNewAccount.setDisable(true);

        userInformationBox.getChildren().addAll(lblUsername, textFieldUsername2, btnVerifyUsername);
        userInformationBox.getChildren().addAll(lblPassword, textFieldPassword2);
        userInformationBox.getChildren().addAll(lblConfirmPassword, textFieldConfirmPassword);
        userInformationBox.getChildren().addAll(new Separator(), btnCreateNewAccount);

        signupRoot.getChildren().add(userInformationBox);
    }

}
