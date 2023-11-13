/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2023
 * Instructor: Prof. Brian King / Prof. Joshua Stough
 *
 * Name: Donovan Coleman
 * Section: 10:00 am
 * Date: 11/13/23
 * Time: 10:06 AM
 *
 * Project: csci205_final_project
 * Package: org.team1
 * Class: gpTrainer
 *
 * Description:
 *
 * ****************************************
 */
package org.team1;

//public class GPTrainer {
////api: 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
//}
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class GPTrainer {

    public static String chatGPT(String prompt) {
        String url = "https://api.openai.com/v1/chat/completions";
        String apiKey = "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";
        String model = "gpt-3.5-turbo";

        try {
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer " + apiKey);
            connection.setRequestProperty("Content-Type", "application/json");

            // The request body
            String body = "{\"model\": \"" + model + "\", \"messages\": [{\"role\": \"user\", \"content\": \"" + prompt + "\"}]}";
            connection.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(body);
            writer.flush();
            writer.close();

            // Response from ChatGPT
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;

            StringBuffer response = new StringBuffer();

            while ((line = br.readLine()) != null) {
                response.append(line);
            }
            br.close();

            // calls the method to extract the message.
            return extractMessageFromJSONResponse(response.toString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String extractMessageFromJSONResponse(String response) {
        int start = response.indexOf("content")+ 11;

        int end = response.indexOf("\"", start);

        return response.substring(start, end);

    }

    public static void main(String[] args) {

        System.out.println(chatGPT("hello, how are you? Can you tell me what's a Fibonacci Number?"));

    }
}