package org.team1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalorieCalculatorTest {

    /** the user input duration in minutes */
    private double durationInMins;

    /** the user's speed input converted to Meters per second */
    private double speedMeterPerSecond;

    /** the user's weight input converted to Kilograms  */
    private double weightInKg;

    /** the user's height input converted to Meters  */
    private double heightInMeter;


    /**
     * Set up the initial variables to test the
     * calculateCalorie method
     *
     * @author Amanda
     */
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
     *
     * @author Amanda
     */
    @DisplayName("CalorieCalculator() - test for correct calories calculated")
    @Test
    void calculateCalories() {

        //Calculate with a sample input
        double result = CalorieCalculator.calculateCalories(durationInMins ,speedMeterPerSecond ,weightInKg, heightInMeter );
        assertEquals(1841, result);

    }
}