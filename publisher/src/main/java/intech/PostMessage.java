package intech;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class PostMessage {
    public static int post(String jsonRequest) throws IOException {
        URL subscriberAddress = new URL("http://localhost:8080/sendMessage");

        HttpURLConnection connection = (HttpURLConnection) subscriberAddress.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-type", "application/json; utf-8");
        connection.setRequestProperty("Accept", "application/json");
        connection.setDoOutput(true);

        try (OutputStream outputStream = connection.getOutputStream()) {
            byte[] input = jsonRequest.getBytes(StandardCharsets.UTF_8);
            outputStream.write(input, 0, input.length);
        }

        return connection.getResponseCode();
    }
}
