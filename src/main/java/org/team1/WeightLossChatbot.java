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

        try {
            System.out.print("Hi there! What's your name? ");
            String name = scanner.nextLine();

            System.out.print("Would you prefer running or walking? ");
            String workoutChoice = scanner.nextLine().toLowerCase();

            System.out.print("How far are you willing to go (in miles)? ");
            double distance = scanner.nextDouble();

            System.out.print("At what max speed are you willing to go (in miles per hour)? *Top walking speed is around 3mph ");
            double speed = scanner.nextDouble();

            System.out.print("How many pounds do you want to lose? ");
            double pounds = scanner.nextDouble();
            double calorieInput = pounds * 3500;
            double[] suggestedWorkout = suggestWorkout(distance, speed, calorieInput);

            System.out.println("\nHi " + name + "! Based on your inputs, here's a suggested workout:");
            System.out.println("Workout: " + workoutChoice);
            System.out.println("Distance: " + String.format("%.2f", suggestedWorkout[0]) + " miles");
            System.out.println("Speed: " + String.format("%.2f", suggestedWorkout[1]) + " miles per hour");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid numeric values.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static double[] suggestWorkout(double distance, double speed, double calorieInput) {
        double caloriesBurnedPerMile = 100; // Adjust this value based on your estimation

        // Calculate the suggested workout based on calories input
        double suggestedDistance = calorieInput / caloriesBurnedPerMile;
        double suggestedSpeed = speed; // You may adjust this based on your recommendation

        return new double[]{suggestedDistance, suggestedSpeed};
    }
}
