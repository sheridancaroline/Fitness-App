package org.team1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class UserInformationTest {

    private UserInformation userInformation;

    private Workout day1;

    private Workout day2;

    @BeforeEach
    void setUp() {

        day1 = new Workout(LocalDate.of(2023,12,1), WorkoutType.WALKING,
                5.5,6,70,900);

        day2 = new Workout(LocalDate.of(2023,12,2), WorkoutType.WALKING,
                5.5,6,70,900);

        userInformation = new UserInformation("rohbot", "1234", Gender.MALE , 77, 178);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addWorkout() {
        userInformation.addWorkout(day1);
        assertTrue(userInformation.getPastWorkouts().get(day1.getDate()).get(0).equals(day1));

        userInformation.addWorkout(day2);
        assertTrue(userInformation.getPastWorkouts().get(day2.getDate()).get(0).equals(day2));
    }
}