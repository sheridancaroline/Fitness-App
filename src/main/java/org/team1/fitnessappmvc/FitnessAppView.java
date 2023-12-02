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

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.team1.WorkoutType;


/**
 * This is the "view" in the MVC design for the fitness application.
 * Initializes all nodes for the scene graph for this view.
 */
public class FitnessAppView {

    /** The model that contains the data and logic behind this view */
    private FitnessAppModel theModel;

    private Scene scene;


    /** Controls used in the login page */

    private BorderPane loginRoot;
    private VBox loginInformation;
    private TextField textFieldUsername;
    private TextField textFieldPassword;
    private Button btnLogin;
    private Button btnSignup;
    private Button btnGuest;


    /** Controls used in the signup page */
    private BorderPane signupRoot;
    private VBox signupInformation;
    private TextField textFieldUsername2;
    private TextField textFieldPassword2;
    private TextField textFieldConfirmPassword;
    private Button btnCreateNewAccount;
    private Button btnVerifyUsername;
    private RadioButton rbMale;
    private RadioButton rbFemale;
    private TextField textFieldWeight;
    private TextField textFieldHeight;


    /** Controls used in the calorie calculator page */

    private BorderPane calorieCalculatorRoot;
    private VBox calorieCalculatorInformation;
    public TextField speedTextField;
    public TextField weightTextField;
    public TextField heightTextField;
    public TextField hoursTextField;
    public TextField minutesTextField;
    private Button calculateButton;
    private Button clearButton;
    private Button addButton;
    private ComboBox<WorkoutType> activityComboBox;
    private ComboBox<String> speedComboBox;
    private ComboBox<String> weightComboBox;
    private ComboBox<String> heightComboBox;


    /** Controls used in the chatbot page */
    private VBox chatBotRoot;
    private TextField nameInput;
    private TextField timeLimitInput;
    private TextField poundsInput;
    private TextField timePeriodInput;
    private Button submitButton;


    /** Controls used in the calendar page */

    private BorderPane calendarRoot;
    private DatePicker datePicker;
    private TextArea textArea;
    private Button btnAdd;




    // TODO replace with menubar
    private Button btnViewCalendar;
    private Button btnChatBot;

    /** Menu bar to be displayed for layout */
    private MenuBar menuBar;
    private MenuItem menuItemCalorieCalculator;
    private MenuItem menuItemCalendar;
    private MenuItem menuItemChatbot;
    private Menu menuView;
    private MenuItem menuItemExit;
    private Menu menuFile;
    private Menu menuLogin;
    private MenuItem menuItemLogin;


    /**
     * Constructs the FitnessAppView, initializing with the given model.
     *
     * @param theModel The model associated with this view.
     */
    public FitnessAppView(FitnessAppModel theModel){

        this.theModel = theModel;

        initMenuBar();
        initSceneGraph();
        initStyling();
    }



    /** Getter methods for different roots */


    public VBox getChatBotRoot() {return chatBotRoot;}
    public BorderPane getCalorieCalculatorRoot() { return calorieCalculatorRoot; }
    //public VBox getLoginRoot() { return loginRoot; }
    public BorderPane getLoginRoot() {return loginRoot;}
    public BorderPane getSignupRoot() { return signupRoot; }
    public BorderPane getCalendarRoot() { return calendarRoot; }


    /** Getter methods for controls for login page */
    public String getTextFieldUsername() { return textFieldUsername.getText(); }
    public String getTextFieldPassword() { return textFieldPassword.getText(); }
    public Button getBtnLogin() { return btnLogin; }
    public Button getBtnSignup() { return btnSignup; }
    public Button getBtnGuest() { return btnGuest; }


    /** Getter methods for controls for signup page */
    public String getTextFieldUsername2() { return textFieldUsername2.getText(); }
    public String getTextFieldPassword2() { return textFieldPassword2.getText(); }
    public String getTextFieldWeight2() { return textFieldWeight.getText(); }
    public String getTextFieldHeight2() { return textFieldHeight.getText(); }
    public String getTextFieldConfirmPassword() { return textFieldConfirmPassword.getText(); }
    public Button getBtnCreateNewAccount() { return btnCreateNewAccount; }
    public Button getBtnVerifyUsername() { return btnVerifyUsername; }
    public RadioButton getRbMale() { return rbMale; }
    public RadioButton getRbFemale() { return rbFemale; }


    /** Getter methods for controls for chatbot page */
    public TextField getNameInput() { return nameInput; }
    public TextField getTimeLimitInput() { return timeLimitInput; }
    public TextField getPoundsInput() { return poundsInput; }
    public TextField getTimePeriodInput() { return timePeriodInput; }
    public Button getSubmitButton() { return submitButton; }


    /** Getter methods for controls for calorie calculator page */
    public WorkoutType getComboBoxActivity() { return activityComboBox.getValue(); }
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


    // TODO replace
    public Button getBtnViewCalendar() {return btnViewCalendar; }
    public Button getBtnChatBot() { return  btnChatBot; }

    // TODO incorporate menubar


    public MenuBar getMenuBar() { return menuBar;}

    public MenuItem getMenuItemCalorieCalculator() { return menuItemCalorieCalculator;}

    public MenuItem getMenuItemCalendar() { return menuItemCalendar;}

    public MenuItem getMenuItemChatbot() { return menuItemChatbot;}

    public Menu getMenuView() { return menuView;}

    public MenuItem getMenuItemExit() {return menuItemExit;}

    public Menu getMenuFile() {return menuFile;}

    public Menu getMenuLogin() {
        return menuLogin;
    }

    public MenuItem getMenuItemLogin() {
        return menuItemLogin;
    }

    /** Getter methods for controls for calendar page */
    public DatePicker getDatePicker() { return datePicker; }
    public TextArea getTextArea() { return textArea; }
    public Button getBtnAdd() { return btnAdd; }


    /**
     * @author Dong Hyun Roh
     */
    private void initStyling() {

        loginRoot.setPadding(new Insets(0,0,40,0));

        loginInformation.setAlignment(Pos.CENTER);
        loginInformation.setSpacing(10);
        loginInformation.setPadding(new Insets(40,100,40,100));


        signupRoot.setPadding(new Insets(0,0,40,0));

        signupInformation.setAlignment(Pos.CENTER);
        signupInformation.setSpacing(10);
        signupInformation.setPadding(new Insets(40,100,40,100));

        //signupRoot.setAlignment(Pos.CENTER);

        //signupRoot.setPrefSize(350,500);
        //signupRoot.setPadding(new Insets(40,40,40,40));
        //signupRoot.setSpacing(10);

        calorieCalculatorRoot.setPadding(new Insets(0,0,40,0));

        calorieCalculatorInformation.setAlignment(Pos.CENTER);
        calorieCalculatorInformation.setSpacing(10);
        calorieCalculatorInformation.setPadding(new Insets(40,100,40,100));
//        calorieCalculatorRoot.setPrefSize(500,500);




        chatBotRoot.setPadding(new Insets(20, 20, 20, 20));
        chatBotRoot.setSpacing(10);
    }

    private void initMenuBar() {
        menuItemCalorieCalculator = new MenuItem("Calorie Calculator");
        menuItemCalendar = new MenuItem("Calendar");
        menuItemChatbot = new MenuItem("Chatbot");

        menuView = new Menu("View", null, menuItemCalorieCalculator, menuItemCalendar, menuItemChatbot);
        menuView.setDisable(true);

        menuItemExit = new MenuItem("Exit");

        // TODO move to controller
        menuItemExit.setOnAction(e -> Platform.exit());

        menuFile = new Menu("File", null, menuItemExit);


//        menuItemLogin = new MenuItem("Login Page");
//        menuLogin = new Menu("Login", null, menuItemLogin);

//        menuBar = new MenuBar(menuLogin, menuView, menuFile);

        menuBar = new MenuBar( menuView, menuFile);







    }


    /**
     * Initialize the entire scene graph
     */
    private void initSceneGraph() {

        initLoginPage();
        initSignupPage();
        initCalorieCalculatorPage();
        initChatBotPage();
        initCalendarPage();

    }


    /**
     * @author Caroline
     */
    private void initCalendarPage() {
        calendarRoot = new BorderPane();

        datePicker = new DatePicker();
        textArea = new TextArea();
        btnAdd = new Button("+");

        VBox vbox = new VBox(datePicker, textArea);
        calendarRoot.setCenter(vbox);
        calendarRoot.setBottom(btnAdd);
        BorderPane.setMargin(btnAdd, new Insets(10));

    }

    /**
     * @author Donovan
     */
    private void initChatBotPage() {
        chatBotRoot = new VBox();

        nameInput = new TextField();
        nameInput.setPromptText("Enter your name");

        timeLimitInput = new TextField();
        timeLimitInput.setPromptText("Enter workout time limit (Minutes)");

        poundsInput = new TextField();
        poundsInput.setPromptText("Enter the number of pounds to lose");

        timePeriodInput = new TextField();
        timePeriodInput.setPromptText("Enter the time span to lose weight (Days)");

        submitButton = new Button("Submit");

        chatBotRoot.getChildren().addAll(nameInput, timeLimitInput, poundsInput, timePeriodInput, submitButton);
    }


    /**
     * @author Dong Hyun Roh
     */
    public void initLoginPage(){

        loginRoot = new BorderPane();

        loginInformation = new VBox();

        Label lblLoginHeading = new Label("Member Login");

        VBox usernameBox = new VBox();
        Label lblUsername = new Label("Username");
        textFieldUsername = new TextField();
        usernameBox.getChildren().addAll(lblUsername, textFieldUsername);

        VBox passwordBox = new VBox();
        Label lblPassword = new Label("Password");
        textFieldPassword = new TextField();
        passwordBox.getChildren().addAll(lblPassword, textFieldPassword);

        btnLogin = new Button("Login");
        btnSignup = new Button("Signup");
        btnGuest = new Button("Continue as a guest");

        loginInformation.getChildren().addAll(lblLoginHeading, usernameBox,
                passwordBox, btnLogin, btnSignup, new Separator(), btnGuest);

        loginRoot.setCenter(loginInformation);
    }


    /**
     * @author Dong Hyun Roh
     */
    public void initSignupPage(){

        signupRoot = new BorderPane();

        signupInformation = new VBox();

        Label lblSignupHeading = new Label("Signup");

        VBox userInformationBox = new VBox();

        // radio button group to allow the user to select gender
        ToggleGroup group = new ToggleGroup();
        rbMale = new RadioButton("Male");
        rbFemale = new RadioButton("Female");
        rbMale.setToggleGroup(group);
        rbFemale.setToggleGroup(group);
        rbMale.setSelected(true);

        VBox genderBox = new VBox();
        genderBox.getChildren().addAll(rbMale, rbFemale);


        Label lblWeight = new Label("Weight");
        textFieldWeight = new TextField();
        textFieldWeight.setPromptText("Enter in kg");

        Label lblHeight = new Label("Height");
        textFieldHeight = new TextField();
        textFieldHeight.setPromptText("Enter in cm");

        userInformationBox.getChildren().addAll(lblWeight, textFieldWeight, lblHeight, textFieldHeight);

        Label lblUsername = new Label("Username");
        btnVerifyUsername = new Button("Verify");
        textFieldUsername2 = new TextField();

        Label lblPassword = new Label("Password");
        textFieldPassword2 = new TextField();

        Label lblConfirmPassword = new Label("Confirm Password");
        textFieldConfirmPassword = new TextField();

        btnCreateNewAccount = new Button("Create a new account");
        btnCreateNewAccount.setDisable(true);

        userInformationBox.getChildren().addAll(lblUsername, textFieldUsername2, btnVerifyUsername,
                lblPassword, textFieldPassword2, lblConfirmPassword, textFieldConfirmPassword,
                new Separator(), btnCreateNewAccount);

        signupInformation.getChildren().addAll(lblSignupHeading, genderBox, userInformationBox);

        signupRoot.setCenter(signupInformation);
    }

    /**
     * @author Amanda
     */
    public void initCalorieCalculatorPage(){

        this.calorieCalculatorRoot = new BorderPane();
        this.calorieCalculatorInformation = new VBox();

        btnViewCalendar = new Button("View Calendar");

        calorieCalculatorInformation.getChildren().addAll(btnViewCalendar);


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

        calorieCalculatorInformation.getChildren().addAll(activitySection, durationSection, speedSection, weightSection, heightSection, buttonSection);
        calorieCalculatorRoot.setCenter(calorieCalculatorInformation);
    }


    //format of all drop down options
    private ComboBox<String> dropDownOptions(String promptText, String... items) {
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll(items);
        comboBox.setPromptText(promptText);
        return comboBox;
    }


    private ComboBox<WorkoutType> activityDropDownOptions(String promptText) {
        ComboBox<WorkoutType> comboBox = new ComboBox<>();
        comboBox.getItems().addAll(WorkoutType.values());
        comboBox.setPromptText(promptText);
        return comboBox;
    }


}
