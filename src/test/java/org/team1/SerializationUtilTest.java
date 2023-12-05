package org.team1;


import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class SerializationUtilTest {

    /** File name to be used for testing serialization */
    private static final String TEST_FILE_NAME = "testFile.ser";


    /**
     * Test serialization
     *
     * @author Dong Hyun Roh
     */
    @Test
    void serializeAndDeserializeObject() {

        // test data to be used to verify serialization
        String testData = "This is a test string";

        try {
            // Serialize the test data
            SerializationUtil.serialize(testData, TEST_FILE_NAME);

            // Deserialize the test data
            Object deserializedData = SerializationUtil.deserialize(TEST_FILE_NAME);

            // Check the deserialized data is not null
            assertNotNull(deserializedData);

            // Check that the deserialized data equals the original test data
            assertEquals(testData, deserializedData);

        } catch (IOException | ClassNotFoundException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

}