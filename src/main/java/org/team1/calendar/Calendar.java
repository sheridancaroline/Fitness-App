/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2023
 * Instructor: Prof. Brian King / Prof. Joshua Stough
 *
 * Name: Dong Hyun Roh
 * Section: 9am
 * Date: 11/27/23
 * Time: 11:52 PM
 *
 * Project: csci205_final_project
 * Package: org.team1.calendar
 * Class: CalendarController
 *
 * Description: Developed to improve the visual of the calendar
 * incorporated into fitnessappmvc. Have not completed the implementation
 *
 * ****************************************
 */
package org.team1.calendar;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import org.team1.WorkoutType;
import org.team1.Workout;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.*;

/** This class is not fully developed and integrated into the fitnessappmvc.
 *  The purpose of this class was to experiment with enhancing the visual aspect of the calendar
 *  that is currently being used in the fitnessappmvc
 * */
public class Calendar implements Initializable {

    ZonedDateTime dateFocus;
    ZonedDateTime today;

    @FXML
    private Text year;

    @FXML
    private Text month;

    @FXML
    private FlowPane calendar;

    private Map<LocalDate, ArrayList<Workout>> workoutsMap;

    /**
     * Initializes the calendar view with the current date and associated workouts.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dateFocus = ZonedDateTime.now();
        today = ZonedDateTime.now();
        workoutsMap = createWorkoutsMap(getWorkouts());

        drawCalendar();
    }

    @FXML
    void backOneMonth() {
        dateFocus = dateFocus.minusMonths(1);
        calendar.getChildren().clear();
        drawCalendar();
    }

    @FXML
    void forwardOneMonth() {
        dateFocus = dateFocus.plusMonths(1);
        calendar.getChildren().clear();
        drawCalendar();
    }

    /**
     * Draws the calendar view based on the current date and associated workouts.
     * The calendar displays dates and their corresponding workouts, if any.
     */
    private void drawCalendar() {
        year.setText(String.valueOf(dateFocus.getYear()));
        month.setText(String.valueOf(dateFocus.getMonth()));

        double calendarWidth = calendar.getPrefWidth();
        double calendarHeight = calendar.getPrefHeight();
        double strokeWidth = 1;
        double spacingH = calendar.getHgap();
        double spacingV = calendar.getVgap();


        int monthMaxDate = dateFocus.getMonth().maxLength();
        //Check for leap year
        if (dateFocus.getYear() % 4 != 0 && monthMaxDate == 29) {
            monthMaxDate = 28;
        }
        int dateOffset = ZonedDateTime.of(dateFocus.getYear(), dateFocus.getMonthValue(), 1, 0, 0, 0, 0, dateFocus.getZone()).getDayOfWeek().getValue();

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                StackPane stackPane = new StackPane();

                Rectangle rectangle = new Rectangle();
                rectangle.setFill(Color.TRANSPARENT);
                rectangle.setStroke(Color.BLACK);
                rectangle.setStrokeWidth(strokeWidth);
                double rectangleWidth = (calendarWidth / 7) - strokeWidth - spacingH;
                rectangle.setWidth(rectangleWidth);
                double rectangleHeight = (calendarHeight / 6) - strokeWidth - spacingV;
                rectangle.setHeight(rectangleHeight);
                stackPane.getChildren().add(rectangle);

                int calculatedDate = (j + 1) + (7 * i);
                if (calculatedDate > dateOffset) {
                    int currentDate = calculatedDate - dateOffset;
                    if (currentDate <= monthMaxDate) {
                        Text date = new Text(String.valueOf(currentDate));
                        double textTranslationY = -(rectangleHeight / 2) * 0.75;
                        date.setTranslateY(textTranslationY);
                        stackPane.getChildren().add(date);

                        LocalDate calendarDate = LocalDate.of(dateFocus.getYear(), dateFocus.getMonth(), currentDate);
                        List<Workout> workouts = workoutsMap.get(calendarDate);
                        if (workouts != null) {
                            createWorkoutsUI(workouts, rectangleHeight, rectangleWidth, stackPane);
                        }
                    }
                    if (today.getYear() == dateFocus.getYear() && today.getMonth() == dateFocus.getMonth() && today.getDayOfMonth() == currentDate) {
                        rectangle.setStroke(Color.BLUE);
                    }
                }
                calendar.getChildren().add(stackPane);
            }
        }

    }


    /**
     * Creates UI elements for displaying workouts associated with a specific date.
     *
     * @param workouts       List of workouts for the date
     * @param rectangleHeight Height of the rectangle UI element
     * @param rectangleWidth  Width of the rectangle UI element
     * @param stackPane       StackPane for placing the workout UI elements
     */
    private void createWorkoutsUI(List<Workout> workouts, double rectangleHeight, double rectangleWidth, StackPane stackPane) {
        VBox workoutsBox = new VBox();

        for (Workout workout : workouts) {
            Text text = new Text(workout.getWorkoutType().toString());
            text.setUserData(workout); // Store Workouts object in the userData property
            workoutsBox.getChildren().add(text);

            text.setOnMouseClicked(this::handleWorkoutTextClick); // Set mouse click event handler
        }

        workoutsBox.setTranslateY((rectangleHeight / 2) * 0.20);
        workoutsBox.setMaxWidth(rectangleWidth * 0.8);
        workoutsBox.setMaxHeight(rectangleHeight * 0.65);
        workoutsBox.setStyle("-fx-background-color:GRAY");
        stackPane.getChildren().add(workoutsBox);
    }

    /**
     * Handles the mouse click event on workout text elements to display the workouts for the clicked date.
     *
     * @param event Mouse click event triggering the display of workouts
     */
    private void handleWorkoutTextClick(MouseEvent event) {
        if (event.getSource() instanceof Text) {
            Text text = (Text) event.getSource();
            Object userData = text.getUserData();

            if (userData instanceof Workout) {
                Workout clickedWorkout = (Workout) userData;
                LocalDate workoutDate = clickedWorkout.getDate();
                List<Workout> workoutForDate = workoutsMap.get(workoutDate);

                if (workoutForDate != null && !workoutForDate.isEmpty()) {
                    for (Workout workout : workoutForDate) {
                        showAlert("Workout Information", workout.toString(), Alert.AlertType.INFORMATION);
                    }
                } else {
                    showAlert("No workout", "No workouts found for the selected date", Alert.AlertType.WARNING);
                }
            }
        }
    }


    /**
     * Creates a map where workout objects are grouped by their respective dates.
     *
     * @author Dong Hyun Roh
     * @param workoutList ArrayList containing Workout objects to be grouped by date
     * @return Map with LocalDate as keys and ArrayList of Workout objects as values
     */
    private Map<LocalDate, ArrayList<Workout>> createWorkoutsMap(ArrayList<Workout> workoutList) {
        Map<LocalDate, ArrayList<Workout>> workoutsMap = new HashMap<>();

        for (Workout workout : workoutList) {
            LocalDate workoutDate = workout.getDate();
            if (!workoutsMap.containsKey(workoutDate)) {
                workoutsMap.put(workoutDate, new ArrayList<>(List.of(workout)));
            } else {
                ArrayList<Workout> oldListByDate = workoutsMap.get(workoutDate);
                oldListByDate.add(workout);
                workoutsMap.put(workoutDate, oldListByDate);
            }
        }
        return workoutsMap;
    }


    /**
     * Generates a list of sample workouts for demonstration purposes.
     *
     * @author Dong Hyun Roh
     * @return An ArrayList containing sample Workout objects.
     */
    private ArrayList<Workout> getWorkouts() {

        // Initialize an empty ArrayList to store Workout objects
        ArrayList<Workout> workoutList = new ArrayList<>();

        // Generate sample Workout objects
        Workout day1 = new Workout(LocalDate.now(), WorkoutType.WALKING,5.5,6,70,900);
        Workout day2 = new Workout(LocalDate.of(2023,11,1), WorkoutType.WALKING,5.5,6,70,900);
        Workout day3 = new Workout(LocalDate.of(2023,11,2), WorkoutType.RUNNING,5.5,6,70,900);
        Workout day4 = new Workout(LocalDate.of(2023,11,25), WorkoutType.WALKING,5.5,6,70,900);
        Workout day5 = new Workout(LocalDate.of(2023,11,25), WorkoutType.WALKING,5.5,6,70,900);

        // Add the sample Workout objects to the ArrayList
        workoutList.add(day1);
        workoutList.add(day2);
        workoutList.add(day3);
        workoutList.add(day4);
        workoutList.add(day5);

        return workoutList;
    }


    /**
     * Displays an alert dialog with the specified title, message, and type.
     *
     * @author Donovan
     * @param title   The title of the alert dialog.
     * @param message The message to be displayed in the alert dialog.
     * @param type    The type of the alert dialog (e.g., INFORMATION, WARNING, ERROR).
     */
    private void showAlert(String title, String message, Alert.AlertType type) {

        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
