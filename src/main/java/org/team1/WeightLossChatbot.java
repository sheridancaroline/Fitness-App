/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2023
 * Instructor: Prof. Brian King / Prof. Joshua Stough
 *
 * Name: Donovan Coleman
 * Section: 10:00 am
 * Date: 11/28/23
 * Time: 12:32 PM
 *
 * Project: csci205_final_project
 * Package: org.team1
 * Class: PersonalTrainer
 *
 * Description:
 *
 * ****************************************
 */
package org.team1;
import java.util.InputMismatchException;
import java.util.Scanner;

public class WeightLossChatbot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = askForStringInput("Hi there! What's your name? ", scanner);

        String workoutChoice = askForWorkoutChoice("Would you prefer running or walking? ", scanner).toLowerCase();

        double distance = askForDoubleInput("How far are you willing to go (in miles)? ", scanner);

        double speed = askForDoubleInput("At what max speed are you willing to go (in miles per hour)? *Top walking speed is around 3mph ", scanner);

        double pounds = askForDoubleInput("How many pounds do you want to lose? ", scanner);
        double calorieInput = pounds * 3500;

        double[] suggestedWorkout = suggestWorkout(distance, speed, calorieInput);

        System.out.println("\nHi " + name + "! Based on your inputs, here's a suggested workout:");
        System.out.println("Workout: " + workoutChoice);
        System.out.println("Distance: " + String.format("%.2f", suggestedWorkout[0]) + " miles");
        System.out.println("Speed: " + String.format("%.2f", suggestedWorkout[1]) + " miles per hour");

        scanner.close();
    }

    private static String askForStringInput(String prompt, Scanner scanner) {
        String input = "";
        boolean isValid = false;
        do {
            try {
                System.out.print(prompt);
                input = scanner.nextLine();
                isValid = true;
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine(); // Consume the invalid input to prevent an infinite loop
            }
        } while (!isValid);
        return input;
    }

    private static String askForWorkoutChoice(String prompt, Scanner scanner) {
        String input = "";
        boolean isValid = false;
        do {
            input = askForStringInput(prompt, scanner).toLowerCase();
            if (input.equals("walking") || input.equals("running")) {
                isValid = true;
            } else {
                System.out.println("Invalid input. Please enter either 'walking' or 'running'.");
            }
        } while (!isValid);
        return input;
    }

    private static double askForDoubleInput(String prompt, Scanner scanner) {
        double input = 0.0;
        boolean isValid = false;
        do {
            try {
                System.out.print(prompt);
                input = scanner.nextDouble();
                isValid = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid numeric value.");
                scanner.nextLine(); // Consume the invalid input to prevent an infinite loop
            }
        } while (!isValid);
        return input;
    }

    private static double[] suggestWorkout(double distance, double speed, double calorieInput) {
        double caloriesBurnedPerMile = 100; // Adjust this value based on your estimation

        // Calculate the suggested workout based on calories input
        double suggestedDistance = calorieInput / caloriesBurnedPerMile;
        double suggestedSpeed = speed; // You may adjust this based on your recommendation

        return new double[]{suggestedDistance, suggestedSpeed};
    }
}
