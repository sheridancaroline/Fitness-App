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

public class SerializationUtil {

    // deserialize to Object from given file
    //https://www.digitalocean.com/community/tutorials/serialization-in-java
    public static Object deserialize(String fileName) throws IOException,
            ClassNotFoundException {


        FileInputStream fileInputStream = new FileInputStream(fileName);
        //System.out.println(1);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Object obj = objectInputStream.readObject();
        objectInputStream.close();
        return obj;
    }

    // serialize the given object and save it to file
    public static void serialize(Object obj, String fileName)
            throws IOException {


        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(obj);

        fileOutputStream.close();
        System.out.println(1);

    }
}
