package org.team1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final WorkoutManager workoutManager = new WorkoutManager();
    private static User user;

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        // Ask for user's sex
        System.out.println("Enter your sex (M/F): ");
        char sex = scnr.next().toUpperCase().charAt(0);

        // Ask for users weight
        System.out.println("Enter your weight in pounds: ");
        double weight = scnr.nextDouble();

        // Create a new user
        user = new User(sex, weight);

        // Prompt user by asking if they want to enter a workout
        System.out.println("Welcome to workout log! Would you like to log a workout? (Y/N)");

        while (scnr.next().equalsIgnoreCase("Y")) {

            logWorkout(scnr);

            System.out.println("Welcome to workout log! Would you like to log a workout? (Y/N)");
        }

        System.out.println("Goodbye!");

    }
    public static void logWorkout(Scanner scnr) {
        System.out.println("Please select a workout type: ");
        System.out.println("1: RUN");
        System.out.println("2: WALK");

        int workoutTypeChoice = scnr.nextInt();
        WorkoutType selectedWorkoutType = getWorkoutTypeFromChoice(workoutTypeChoice);

        LocalDate workoutDate = null;
        while (workoutDate == null) {
            System.out.println("Enter date of the workout (MM/dd/yyyy): ");
            String dateString = scnr.next();
            workoutDate = parseDate(dateString);
        }

        System.out.println("Enter duration minutes: ");
        int minutesDuration = scnr.nextInt();

        System.out.println("Enter duration seconds: ");
        int secondsDuration = scnr.nextInt();

        // Calculate calories based on user input
        int calculatedCalories = CalorieCalculator.calculateCalories(selectedWorkoutType, user.sex, user.weight, minutesDuration, secondsDuration);

        // Create a new workout
        Workout newWorkout = new Workout(selectedWorkoutType, workoutDate, calculatedCalories, minutesDuration, secondsDuration);

        // Add the workout to the manager
        workoutManager.addWorkout(newWorkout);

        System.out.println("Workout logged successfully!");

        displayWorkouts(workoutDate);

    }

    private static void displayWorkouts(LocalDate workoutDate) {
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

    private static LocalDate parseDate(String dateString) {
        try {
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            // Parse the input date and then format it to the desired output format
            return LocalDate.parse(LocalDate.parse(dateString, inputFormatter).format(outputFormatter));
        } catch (Exception e) {
            System.out.println("Invalid date format. Please use MM/dd/yyyy");
            return null; // Return null for an invalid date
        }
    }

    private static void displayDailyWorkouts(LocalDate date) {
        String dayKey = formatDateKey(date);
        List<Workout> workoutsForDay = workoutManager.getWorkoutsForDay(dayKey);

        System.out.println("Daily workouts for " + dayKey + ": " + workoutsForDay);
    }
    private static void displayMonthlyWorkouts(LocalDate date) {
        String monthKey = formatMonthKey(date);
        List<Workout> workoutsForMonth =  workoutManager.getWorkoutsForMonth(monthKey);

        System.out.println("Monthly Workouts for " + monthKey +  ": " + workoutsForMonth);
    }

    private static String formatDateKey(LocalDate date) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    private static String formatMonthKey(LocalDate date) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM");
        return dateFormat.format(date);
    }
}
