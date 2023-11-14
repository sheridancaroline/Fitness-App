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

import java.text.SimpleDateFormat;
import java.util.*;

public class WorkoutManager {
    private Map<String, List<Workout>> monthlyWorkouts;
    private Map<String, List<Workout>> dailyWorkouts;

    public WorkoutManager() {
        this.monthlyWorkouts = new HashMap<>();
        this.dailyWorkouts = new HashMap<>();
    }

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

    private String formatDateKey(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    private String formatMonthKey(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        return dateFormat.format(date);
    }
}

