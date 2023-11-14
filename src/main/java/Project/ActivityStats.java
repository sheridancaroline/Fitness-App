package Project;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ActivityStats {

    private int totalSteps;
    private int totalCalories;
    private LocalDateTime lastRecordedTime;

    public ActivityStats() {
        this.totalSteps = 0;
        this.totalCalories = 0;
        this.lastRecordedTime = LocalDateTime.now();
    }

    public void recordSteps(int steps) {
        totalSteps += steps;
        lastRecordedTime = LocalDateTime.now();
    }

    public void recordCalories(int calories) {
        totalCalories += calories;
        lastRecordedTime = LocalDateTime.now();
    }

    public void displayStats() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("Fitness Tracker Stats (Last Recorded Time: " + lastRecordedTime.format(formatter) + "):");
        System.out.println("Total Steps: " + totalSteps);
        System.out.println("Total Calories Burned: " + totalCalories);
    }

    public static void main(String[] args) {
        ActivityStats activityStats = new ActivityStats();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Record Steps");
            System.out.println("2. Record Calories");
            System.out.println("3. Display Stats");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the number of steps: ");
                    int steps = scanner.nextInt();
                    activityStats.recordSteps(steps);
                    break;
                case 2:
                    System.out.print("Enter the number of calories: ");
                    int calories = scanner.nextInt();
                    activityStats.recordCalories(calories);
                    break;
                case 3:
                    activityStats.displayStats();
                    break;
                case 4:
                    System.out.println("Exiting... Thank you for using the Fitness Tracker!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}