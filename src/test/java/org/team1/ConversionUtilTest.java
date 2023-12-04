package org.team1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.*;

class ConversionUtilTest {

    private DecimalFormat df;

    @BeforeEach
    void setUp() {
        df = new DecimalFormat("###.##");
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * A test to ensure units are correctly converted to meters per second
     */
    @Test
    @DisplayName("convertWeightToKg()- test converting given weight to Kg")
    void convertSpeedToMeters() {

        //convert mph to meters per second
        double mphToMetersPerSecond = ConversionUtil.convertSpeedToMeters(10, "Miles per Hour");
        assertEquals("4.47", df.format(mphToMetersPerSecond) );

        //convert kmph to meters per second
        double kmphToMetersPerSecond = ConversionUtil.convertSpeedToMeters(15, "Kilometers per Hour");
        assertEquals("4.17", df.format(kmphToMetersPerSecond) );

    }


    /**
     * A test to make sure weight units are converted to Kilograms
     */
    @Test
    @DisplayName("convertWeightToKg()- test converting given weight to Kg")
    void convertWeightToKg() {

        //convert pounds to Kilograms
        double poundsToKg = ConversionUtil.convertWeightToKg(180, "Pound (lb)");
        assertEquals("81.65", df.format(poundsToKg) );
    }


    /**
     * A test to make sure height units are converted to Meters
     */
    @Test
    @DisplayName("convertHeightToMeters()- test converting height to meters")
    void convertHeightToMeters() {
        //convert inches to Meters
        double inchesToMeters = ConversionUtil.convertHeightToMeters(50, "inches(in)");
        assertEquals(1.27, inchesToMeters );

        //convert centimeters to Meters
        double centimetersToMeters = ConversionUtil.convertHeightToMeters(180, "centimeters(cm)");
        assertEquals(1.8, centimetersToMeters );

    }

    /**
     * A test to make sure minutes are converted
     * to 0 hours and x minutes if duration is below 60
     * and x hours and x minutes if duration is above 60 minutes
     */
    @Test
    @DisplayName("convertToHourAndMinutes()- test converting minutes to  hours and minutes")
    void convertToHourAndMinutes() {

        //check duration is assigned to only minutes
        int[] Minutes = ConversionUtil.convertToHoursAndMinutes(3);
        assertTrue(Minutes[0] == 0 );
        assertTrue(Minutes[1] == 3);

        //check duration is assigned to both minutes and hours if over 60 minutes
        int[] hoursAndMinutes = ConversionUtil.convertToHoursAndMinutes(80);
        assertTrue(hoursAndMinutes[0] == 1 );
        assertTrue(hoursAndMinutes[1] == 20);

    }

}