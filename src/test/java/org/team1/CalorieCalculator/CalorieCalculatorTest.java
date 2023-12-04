package org.team1.CalorieCalculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalorieCalculatorTest {
    private CalorieCalculator calculator;
    private double hours;
    private double minutes;
    private double speedPace;
    private String speedPaceUnit;
    private double weight;
    private String weightUnit;
    private double height;
    private String heightUnit;

    @BeforeEach
    void setUp() {
        this.hours =  0;
        this.minutes = 0;
        this.speedPace = 0;
        this.speedPaceUnit = "Kilometers per Hour";
        this.weight = 0;
        this.weightUnit = "Kilograms(kg)";
        this.height = 0;
        this.heightUnit= "centimeters(cm)";
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
        hours = 3;
        minutes = 30;
        speedPace = 10;
        weight = 70;
        height = 180;
        double result = CalorieCalculator.calculateCalories(hours, minutes, speedPace, speedPaceUnit, weight, weightUnit, height, heightUnit);
        assertEquals(2871.86, result);


        //change variables to the same value in a different unit of measurement but valuables stay the same
        speedPace = 10;
        weight = 70;
        height = 180;
        //assertEquals(2, result );

        //Test for change in calories given different unit of measurement
        speedPaceUnit = "Miles per Hour";
        weightUnit = "Pounds(lb)";
        heightUnit = "Inches(in)";
        assertEquals(9184.37, result);

    }

    /**
     * A test to make sure exceptions are thrown if incorrect inputs are given
     */
    @Test
    @DisplayName("calculateCaloriesException() - exception for incorrect input ")
    void calculateCaloriesException() {
        //Scan for variables = 0
        assertThrows(IllegalArgumentException.class, () -> CalorieCalculator.calculateCalories(hours, minutes, speedPace, speedPaceUnit, weight, weightUnit, height, heightUnit));

    }
}