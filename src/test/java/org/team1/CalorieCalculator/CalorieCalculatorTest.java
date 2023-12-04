package org.team1.CalorieCalculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalorieCalculatorTest {
    private double durationInMins;
    private double speedMeterPerSecond;
    private double weightInKg;
    private double heightInMeter;
    @BeforeEach
    void setUp() {
        this.durationInMins = 80 ;
        this.speedMeterPerSecond = 3.5;
        this.weightInKg= 82;
        this.heightInMeter = 1.8;
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * A test to makes sure the correct values are returned given the formula:
     * Calories burned per minute = (0.035  X body weight in kg) +
     * (Velocity in m/s ^ 2) / (Height in m) X (0.029) X (body weight in kg)
     */
    @Test
    @DisplayName("CalorieCalculator() - test for correct calories calculated")
    void calculateCalories() {

        //Calculate with a sample input
        double result = CalorieCalculator.calculateCalories(durationInMins ,speedMeterPerSecond ,weightInKg, heightInMeter );
        assertEquals(1841, result);

    }

}