package org.team1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Workout {
    public WorkoutType workoutType;

    public LocalDate date;

    public int caloriesBurned;

    public int minutesDuration;

    public int secondsDuration;

    public Workout(WorkoutType workoutType, LocalDate date, int minutesDuration, int secondsDuration) {
        this.workoutType = workoutType;
        this.date = date;
        //this.caloriesBurned = caloriesBurned;
        this.minutesDuration = minutesDuration;
        this.secondsDuration = secondsDuration;
    }

    public WorkoutType getWorkoutType() {
        return workoutType;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    public int getMinutesDuration() {
        return minutesDuration;
    }

    public int getSecondsDuration() {
        return secondsDuration;
    }

    public String toString() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        // Format the workout information
        String formattedDate = dateFormat.format(date);
        String formattedType = workoutType.toString();
        String formattedDuration = String.format("%d:%02d", minutesDuration, secondsDuration);
        String formattedCalories = Integer.toString(caloriesBurned);

        return "[" + formattedDate + ", " + formattedType + ", " + formattedDuration + ", " + formattedCalories + "]";
    }
}




