/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2023
 * Instructor: Prof. Brian King / Prof. Joshua Stough
 *
 * Name: Caroline Sheridan
 * Section: 9 AM
 * Date: 11/14/23
 * Time: 1:48 PM
 *
 * Project: csci205_final_project
 * Package: org.team1
 * Class: WorkoutManager
 *
 * Description:
 *
 * ****************************************
 */
package org.team1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class WorkoutManager {
    private Map<String, List<Workout>> monthlyWorkouts;
    private Map<String, List<Workout>> dailyWorkouts;

    /**
     * Create an instance of workout manager that stores the daily and monthly workouts
     */
    public WorkoutManager() {
        this.monthlyWorkouts = new HashMap<>();
        this.dailyWorkouts = new HashMap<>();
        initializeHardcodedWorkouts();
    }

    /**
     * Initialize hardcoded workouts so they appear in the calendar GUI
     */
    private void initializeHardcodedWorkouts() {
        Workout workout1 = new Workout(WorkoutType.RUN, LocalDate.now(), 200, 30, 0);
        Workout workout2 = new Workout(WorkoutType.WALK, LocalDate.now(), 100, 20, 0);
        Workout workout3 = new Workout(WorkoutType.RUN, LocalDate.of(2023, 11, 22), 60, 10, 0);

        addWorkout(workout1);
        addWorkout(workout2);
        addWorkout(workout3);
    }

    /**
     * Add a workout to the daily and monthly workouts to be stored
     * @param workout to be added
     */
    public void addWorkout(Workout workout) {
        // Add the workout to the map organized by day
        String dayKey = formatDateKey(workout.getDate());
        List<Workout> workoutsOfDay = dailyWorkouts.computeIfAbsent(dayKey, k -> new ArrayList<>());
        workoutsOfDay.add(workout);
        dailyWorkouts.put(dayKey, workoutsOfDay);

        // Add the workout to the map organized by month
        String monthKey = formatMonthKey(workout.getDate());
        List<Workout> workoutsOfMonth = monthlyWorkouts.computeIfAbsent(monthKey, k -> new ArrayList<>());
        workoutsOfMonth.add(workout);
        monthlyWorkouts.put(monthKey, workoutsOfMonth);
    }

    public List<Workout> getWorkoutsForDay(String dayKey) {
        return dailyWorkouts.get(dayKey);
    }

    public List<Workout> getWorkoutsForMonth(String monthKey) {
        return monthlyWorkouts.get(monthKey);
    }

    public Map<String, List<Workout>> getDailyWorkouts() {
        return dailyWorkouts;
    }

    public Map<String, List<Workout>> getMonthlyWorkouts() {
        return monthlyWorkouts;
    }

    /**
     * Format the date so it can be added to the daily workouts
     * @param date to be formatted
     * @return the formatted date as a String
     */
    private String formatDateKey(LocalDate date) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    /**
     * Format the date so it can be added to the monthly workouts
     * @param date to be formatted
     * @return the formatted date as a String
     */
    private String formatMonthKey(LocalDate date) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM");
        return dateFormat.format(date);
    }
}

