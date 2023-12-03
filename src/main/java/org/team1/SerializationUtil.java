/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2023
 * Instructor: Prof. Brian King / Prof. Joshua Stough
 *
 * Name: Dong Hyun Roh
 * Section: 9am
 * Date: 11/14/23
 * Time: 4:37 PM
 *
 * Project: csci205_final_project
 * Package: org.team1
 * Class: SerializationUtil
 *
 * Description:
 *
 * ****************************************
 */
package org.team1;

import java.io.*;

/**
 * Utility class for object serialization and deserialization.
 */
public class SerializationUtil {

    /**
     * Deserialize an object from the given file.
     *
     * @see <a href = "https://www.digitalocean.com/community/tutorials/serialization-in-java">
     *     https://www.digitalocean.com/community/tutorials/serialization-in-java</a>
     *
     * @author Dong Hyun Roh
     * @param fileName File path from which to deserialize the object
     * @return Deserialized object
     * @throws IOException If an I/O error occurs during deserialization
     * @throws ClassNotFoundException If the class of the serialized object cannot be found
     */
    public static Object deserialize(String fileName) throws IOException,
            ClassNotFoundException {

        FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Object obj = objectInputStream.readObject();
        objectInputStream.close();
        return obj;
    }


    /**
     * Serialize the given object and save it to a file.
     *
     * @see <a href = "https://www.digitalocean.com/community/tutorials/serialization-in-java">
     *      *     https://www.digitalocean.com/community/tutorials/serialization-in-java</a>
     *
     * @author Dong Hyun Roh
     * @param obj Object to be serialized
     * @param fileName File path to which the object will be serialized
     * @throws IOException If an I/O error occurs during serialization
     */
    public static void serialize(Object obj, String fileName)
            throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(obj);
        fileOutputStream.close();
    }
}
