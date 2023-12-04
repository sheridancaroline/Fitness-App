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
 * Description: This represents the basic GUI part of our fitness application.
 * This includes the code to create the scene graph for the app, and
 * the styling of the display.
 *
 * ****************************************
 */
package org.team1.fitnessappmvc;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
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
    private Button btnCalculate;
    private Button btnClear;
    private Button addButton;
    private ComboBox<WorkoutType> activityComboBox;
    private ComboBox<String> speedComboBox;
    private ComboBox<String> weightComboBox;
    private ComboBox<String> heightComboBox;


    /** Controls used in the chatBot page */
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
    private Button btnViewCalendar;


    /** Controls used in the chart page */
    private BorderPane chartRoot;
    private VBox chartInformation;
    private LineChart<String, Number> lineChart;


    /** Menu bar to be displayed for layout */
    private MenuBar menuBar;
    private MenuItem menuItemCalorieCalculator;
    private MenuItem menuItemCalendar;
    private MenuItem menuItemChatbot;
    private MenuItem menuItemChart;
    private Menu menuView;
    private MenuItem menuItemExit;
    private Menu menuFile;



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


    /** Getter methods for controls for chatBot page */
    public TextField getNameInput() { return nameInput; }
    public TextField getTimeLimitInput() { return timeLimitInput; }
    public TextField getPoundsInput() { return poundsInput; }
    public TextField getTimePeriodInput() { return timePeriodInput; }
    public Button getSubmitButton() { return submitButton; }


    /** Getter methods for controls for calorie calculator page */
    public String getTextFieldSpeed() { return speedTextField.getText(); }
    public String getComboBoxSpeed() { return speedComboBox.getValue(); }
    public String getTextFieldWeight() { return weightTextField.getText(); }
    public String getComboBoxWeight() { return weightComboBox.getValue(); }
    public String getTextFieldHeight() { return heightTextField.getText(); }
    public String getComboBoxHeight() { return heightComboBox.getValue(); }
    public String getTextFieldHours() { return hoursTextField.getText(); }
    public String getTextFieldMinutes() { return minutesTextField.getText();}
    public Button getBtnCalculate() { return btnCalculate; }
    public Button getBtnClear() { return btnClear; }
    public Button getBtnViewCalendar() {return btnViewCalendar; }


    /** Getter methods for controls in Menubar  */
    public MenuBar getMenuBar() { return menuBar;}
    public MenuItem getMenuItemCalorieCalculator() { return menuItemCalorieCalculator;}
    public MenuItem getMenuItemCalendar() { return menuItemCalendar;}
    public MenuItem getMenuItemChatbot() { return menuItemChatbot;}
    public MenuItem getMenuItemChart() { return menuItemChart; }
    public Menu getMenuView() { return menuView;}
    public MenuItem getMenuItemExit() { return menuItemExit; }


    /** Getter methods for controls for calendar page */
    public DatePicker getDatePicker() { return datePicker; }
    public TextArea getTextArea() { return textArea; }
    public Button getBtnAdd() { return btnAdd; }


    /** Getter methods for controls for chart page */
    public BorderPane getChartRoot() { return chartRoot; }
    public LineChart<String, Number> getLineChart() { return lineChart; }


    /**
     * Initializes styling properties for various root elements and their corresponding information sections.
     *
     * @author Dong Hyun Roh
     */
    private void initStyling() {

        // Styling for loginRoot and loginInformation
        loginRoot.setPadding(new Insets(0,0,40,0));
        loginInformation.setAlignment(Pos.CENTER);
        loginInformation.setSpacing(10);
        loginInformation.setPadding(new Insets(40,100,40,100));

        // Styling for signupRoot and signupInformation
        signupRoot.setPadding(new Insets(0,0,40,0));
        signupInformation.setAlignment(Pos.CENTER);
        signupInformation.setSpacing(10);
        signupInformation.setPadding(new Insets(40,100,40,100));

        // Styling for calorieCalculatorRoot and calorieCalculatorInformation
        calorieCalculatorRoot.setPadding(new Insets(0,0,40,0));
        calorieCalculatorInformation.setAlignment(Pos.CENTER);
        calorieCalculatorInformation.setSpacing(10);
        calorieCalculatorInformation.setPadding(new Insets(40,100,40,100));

        // Styling for chatBotRoot
        chatBotRoot.setPadding(new Insets(20, 20, 20, 20));
        chatBotRoot.setSpacing(10);
    }


    /**
     * Initializes the menu bar with various menus and menu items for different functionalities.
     *
     * @author Amanda and Dong Hyun Roh
     */
    private void initMenuBar() {

        // Create menu items for different functionalities
        menuItemCalorieCalculator = new MenuItem("Calorie Calculator");
        menuItemCalendar = new MenuItem("Calendar");
        menuItemChatbot = new MenuItem("Chatbot");
        menuItemChart = new MenuItem("Chart");

        // Create a 'View' menu containing related menu items and disable it initially
        menuView = new Menu("View", null, menuItemCalorieCalculator,
                menuItemCalendar, menuItemChatbot, menuItemChart);
        menuView.setDisable(true);

        // Create an 'Exit' menu item within the 'File' menu
        menuItemExit = new MenuItem("Exit");
        menuFile = new Menu("File", null, menuItemExit);

        // Create a MenuBar with 'View' and 'File' menus
        menuBar = new MenuBar( menuView, menuFile);
    }


    /**
     * Initializes the scene graph by setting up different pages within the application.
     *
     * @author Dong Hyun Roh
     */
    private void initSceneGraph() {

        // Initialize different pages
        initLoginPage();
        initSignupPage();
        initCalorieCalculatorPage();
        initChatBotPage();
        initCalendarPage();
        initChartPage();
    }


    /**
     * Initializes the chart page by creating necessary components and setting up the layout.
     *
     * @author Amanda
     */
    private void initChartPage() {

        chartRoot = new BorderPane();

        chartInformation = new VBox();
        lineChart = new LineChart<>(new CategoryAxis(), new NumberAxis());
        chartInformation.getChildren().add(lineChart);

        chartRoot.setCenter(chartInformation);
    }


    /**
     * Initializes the calendar page by creating necessary components and setting up the layout.
     *
     * @author Caroline
     */
    private void initCalendarPage() {

        calendarRoot = new BorderPane();

        datePicker = new DatePicker();
        textArea = new TextArea();
        btnViewCalendar = new Button("View Calendar");
        btnAdd = new Button("+");

        VBox vBoxButtons = new VBox(btnAdd, btnViewCalendar);
        VBox vbox = new VBox(datePicker, textArea);
        calendarRoot.setCenter(vbox);
        calendarRoot.setBottom(vBoxButtons);
        BorderPane.setMargin(btnAdd, new Insets(10));
    }


    /**
     * Initializes the ChatBot page by creating necessary components and setting up the layout.
     *
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
     * Initializes the login page by creating necessary components and setting up the layout.
     *
     * @author Dong Hyun Roh
     */
    public void initLoginPage(){

        // Create a BorderPane for the login page
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
     * Initializes the signup page by creating necessary components and setting up the layout.
     *
     * @author Dong Hyun Roh
     */
    public void initSignupPage(){

        // Create a BorderPane for the signup page
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
     * Initializes the Calorie Calculator page by creating necessary components and setting up the layout.
     *
     * @author Amanda
     */
    public void initCalorieCalculatorPage(){

        this.calorieCalculatorRoot = new BorderPane();
        this.calorieCalculatorInformation = new VBox();

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
        btnCalculate = new Button("Calculate");
        //Clear Calories Button
        btnClear = new Button("Clear ");
        //Clear Calories Button
        addButton = new Button("Add to Chart");
        buttonSection.getChildren().addAll(btnClear, btnCalculate, addButton);

        calorieCalculatorInformation.getChildren().addAll(activitySection, durationSection, speedSection, weightSection, heightSection, buttonSection);
        calorieCalculatorRoot.setCenter(calorieCalculatorInformation);
    }


    /**
     * Creates a ComboBox<String> with specified items and a prompt text.
     *
     * @author Amanda Agambire
     * @param promptText initial option
     * @param items other unit options
     * @return A ComboBox<String> populated with provided items and displaying the specified prompt text.
     */
    private ComboBox<String> dropDownOptions(String promptText, String... items) {
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll(items);
        comboBox.setPromptText(promptText);
        return comboBox;
    }


    /**
     * Creates a ComboBox<WorkoutType> with WorkoutType values and a prompt text.
     *
     * @author Amanda Agambire
     * @param promptText The prompt text to be displayed initially in the ComboBox.
     * @return A ComboBox<WorkoutType> populated with WorkoutType values and displaying the specified prompt text.
     */
    private ComboBox<WorkoutType> activityDropDownOptions(String promptText) {
        ComboBox<WorkoutType> comboBox = new ComboBox<>();
        comboBox.getItems().addAll(WorkoutType.values());
        comboBox.setPromptText(promptText);
        return comboBox;
    }
}
