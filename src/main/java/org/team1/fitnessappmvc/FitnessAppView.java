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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.team1.Activity;


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



    private VBox calorieCalculatorRoot;

    /** TextField */
    public TextField speedTextField;
    public TextField weightTextField;
    public TextField heightTextField;
    public TextField hoursTextField;
    public TextField minutesTextField;

    /** Buttons */
    private Button calculateButton;
    private Button clearButton;
    private Button addButton;

    /** ComboBoxes */
    private ComboBox<Activity> activityComboBox;
    private ComboBox<String> speedComboBox;
    private ComboBox<String> weightComboBox;
    private ComboBox<String> heightComboBox;



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



    public VBox getCalorieCalculatorRoot() {
        root = calorieCalculatorRoot;
        return root;
    }
    public Activity getComboBoxActivity() { return activityComboBox.getValue(); }
    public String getTextFieldSpeed() { return speedTextField.getText(); }
    public String getComboBoxSpeed() { return speedComboBox.getValue(); }
    public String getTextFieldWeight() { return weightTextField.getText(); }
    public String getComboBoxWeight() { return weightComboBox.getValue(); }
    public String getTextFieldHeight() { return heightTextField.getText(); }
    public String getComboBoxHeight() { return heightComboBox.getValue(); }
    public String getTextFieldHours() { return hoursTextField.getText(); }
    public String getTextFieldMinutes() { return minutesTextField.getText();}
    public Button getCalculateButton() { return calculateButton; }
    public Button getClearButton() { return clearButton; }
    public Button getAddButton() { return addButton;}


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

        calorieCalculatorRoot.setSpacing(5);
        calorieCalculatorRoot.setPrefSize(500,500);

        calorieCalculatorRoot.setPadding(new Insets(10,5,10,5));
        calorieCalculatorRoot.setAlignment(Pos.CENTER);
    }

    /**
     * Initialize the entire scene graph
     */
    private void initSceneGraph() {

        initLoginPage();
        initSignupPage();
        initCalorieCalculatorPage();
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

    public void initCalorieCalculatorPage(){
        this.calorieCalculatorRoot = new VBox();

        // Activity
        HBox activitySection= new HBox();
        activityComboBox = activityDropDownOptions("Select Activity");
        Label activityLabel = new Label("Activity:  ");
        activitySection.getChildren().addAll(activityLabel, activityComboBox);


        // Speed/Pace
        HBox speedSection= new HBox();
        speedTextField = new TextField();
        speedComboBox = dropDownOptions("Select Unit", "Miles per Hour", "Meters per Second", "Kilometers per Hour");
        speedComboBox.getSelectionModel().selectFirst();
        Label speedLabel = new Label("Speed/Pace:  ");
        speedSection.getChildren().addAll(speedLabel, speedTextField, speedComboBox);


        // Duration
        HBox durationSection= new HBox();
        Label durationLabel = new Label("Duration:  ");
        hoursTextField = new TextField();
        hoursTextField.setPromptText("hours");

        minutesTextField = new TextField();
        minutesTextField.setPromptText("minutes");
        durationSection.getChildren().addAll(durationLabel, hoursTextField, minutesTextField);


        // Weight
        HBox weightSection= new HBox();
        weightTextField = new TextField();
        weightComboBox = dropDownOptions( "Select Unit","Kilograms(kg)", "Pound (lb)");
        weightComboBox.getSelectionModel().selectFirst();
        Label weightLabel = new Label("Current Weight:  ");
        weightSection.getChildren().addAll(weightLabel, weightTextField, weightComboBox);


        // Height
        HBox heightSection= new HBox();
        heightTextField = new TextField();
        heightComboBox = dropDownOptions( "Select Unit","inches(in)", "centimeters(cm)");
        heightComboBox.getSelectionModel().selectFirst();
        Label heightLabel = new Label("Current Height:  ");
        heightSection.getChildren().addAll(heightLabel, heightTextField, heightComboBox);


        //Calculate Calories Button
        HBox buttonSection= new HBox();
        calculateButton = new Button("Calculate");
        //Clear Calories Button
        clearButton = new Button("Clear ");
        //Clear Calories Button
        addButton = new Button("Add to Chart");
        buttonSection.getChildren().addAll(clearButton, calculateButton, addButton);


        calorieCalculatorRoot.getChildren().addAll(activitySection, durationSection, speedSection, weightSection, heightSection, buttonSection);
    }

    //format of all drop down options
    private ComboBox<String> dropDownOptions(String promptText, String... items) {
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll(items);
        comboBox.setPromptText(promptText);
        return comboBox;
    }

    private ComboBox<Activity> activityDropDownOptions(String promptText) {
        ComboBox<Activity> comboBox = new ComboBox<>();
        comboBox.getItems().addAll(Activity.values());
        comboBox.setPromptText(promptText);
        return comboBox;
    }


}
