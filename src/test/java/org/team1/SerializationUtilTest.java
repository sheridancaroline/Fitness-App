package org.team1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.team1.Workout;

import java.io.FileOutputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SerializationUtilTest {
    private String fileName;
    private ArrayList<UserInformation> userInformations;

    @BeforeEach
    void setUp() {

        // create user info array list
        //call seialize on user arry list

        fileName = "userInformation.ser";
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void deserialize() {
    }

    @Test
    void serialize() {

    }
}