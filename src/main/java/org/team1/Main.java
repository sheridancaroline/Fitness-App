package org.team1;

import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static org.team1.WorkoutType.RUN;

public class Main {
    private static final WorkoutManager workoutManager = new WorkoutManager();
    private static User user;
    private static char sex;
    private static double weight;

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        // Ask for user's sex
        System.out.println("Enter your sex (M/F): ");
        sex = scnr.next().toUpperCase().charAt(0);

        // Ask for users weight
        System.out.println("Enter your weight in pounds: ");
        weight = scnr.nextDouble();

        // Create a new user
        user = new User(sex, weight);

        // Prompt user by asking if they want to enter a workout
        System.out.println("Welcome to workout log! Would you like to log a workout? (Y/N)");

        if (scnr.next().equalsIgnoreCase("Y")) {
            logWorkout(scnr);
        } else {
            System.out.println("Goodbye!");
        }

    }
    public static void logWorkout(Scanner scnr) {
        System.out.println("Please select a workout type: ");
        System.out.println("1: RUN");
        System.out.println("2: WALK");

        int workoutTypeChoice = scnr.nextInt();
        WorkoutType selectedWorkoutType = getWorkoutTypeFromChoice(workoutTypeChoice);

        System.out.println("Enter date of the workout (yyyy-MM-dd): ");
        String dateString = scnr.next();
        Date workoutDate = parseDate(dateString);

        System.out.println("Enter duration minutes: ");
        int minutesDuration = scnr.nextInt();

        System.out.println("Enter duration seconds: ");
        int secondsDuration = scnr.nextInt();

        // Calculate calories based on user input
        int calculatedCalories = CalorieCalculator.calculateCalories(selectedWorkoutType, sex, weight, minutesDuration, secondsDuration);

        // Create a new workout
        Workout newWorkout = new Workout(selectedWorkoutType, workoutDate, calculatedCalories, minutesDuration, secondsDuration);

        // Add the workout to the manager
        workoutManager.addWorkout(newWorkout);

        System.out.println("Workout logged successfully!");

        // Display daily and monthly workouts
        displayDailyWorkouts(workoutDate);
        displayMonthlyWorkouts(workoutDate);

    }

    private static WorkoutType getWorkoutTypeFromChoice(int choice) {
        switch (choice) {
            case 1:
                return WorkoutType.RUN;
            case 2:
                return WorkoutType.WALK;
            default:
                throw new IllegalArgumentException("Invalid workout type choice");
        }
    }

    private static Date parseDate(String dateString) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.parse(dateString);
        } catch(ParseException e) {
            throw new IllegalArgumentException("Invalid date format. Please use yyyy-MM-dd");
        }
    }

    private static void displayDailyWorkouts(Date date) {
        String dayKey = formatDateKey(date);
        List<Workout> workoutsForDay = workoutManager.getWorkoutsForDay(dayKey);

        System.out.println("Daily workouts for " + dayKey + ": " + workoutsForDay);
    }
    private static void displayMonthlyWorkouts(Date date) {
        String monthKey = formatMonthKey(date);
        List<Workout> workoutsForMonth =  workoutManager.getWorkoutsForMonth(monthKey);

        System.out.println("Monthly Workouts for " + monthKey +  ": " + workoutsForMonth);
    }

    private static String formatDateKey(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    private static String formatMonthKey(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        return dateFormat.format(date);
    }
}
