package org.team1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import org.team1.Workout;
import org.team1.WorkoutType;

public class WorkoutManager {
    private Map<String, List<org.team1.Workout>> monthlyWorkouts;
    private Map<String, List<org.team1.Workout>> dailyWorkouts;

    public WorkoutManager() {
        this.monthlyWorkouts = new HashMap<>();
        this.dailyWorkouts = new HashMap<>();
        initializeHardcodedWorkouts();
    }

    private void initializeHardcodedWorkouts() {
        Workout workout1 = new Workout(WorkoutType.RUNNING, LocalDate.now(), 200, 30);
        Workout workout2 = new Workout(WorkoutType.WALKING, LocalDate.now(), 100, 20);
        Workout workout3 = new Workout(WorkoutType.RUNNING, LocalDate.of(2023, 11, 22), 60, 10);

        addWorkout(workout1);
        addWorkout(workout2);
        addWorkout(workout3);
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

    private String formatDateKey(LocalDate date) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    private String formatMonthKey(LocalDate date) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM");
        return dateFormat.format(date);
    }
}


