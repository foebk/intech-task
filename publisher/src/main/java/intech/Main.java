package intech;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        System.out.println("Publisher is running");

        URL subscriberAddress = null;

        try {
            subscriberAddress = new URL("http://localhost:8080/sendMessage");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        while (true) {
            System.out.println("Press Enter key to generate and send a message");
            try {
                System.in.read();
                logger.info("Enter key has been pressed. Generating message...");
                MessageDTO messageDTO = MessageGenerator.generateMessage();
                logger.info("Message has been generated. Сontent:".concat(messageDTO.toString()));
                logger.info("Sending message to ".concat(subscriberAddress.toString()));

                ObjectMapper objectMapper = new ObjectMapper();
                String jsonRequest = objectMapper.writeValueAsString(messageDTO);

                int responseCode = PostMessage.post(jsonRequest);

                if (responseCode == 200) {
                    logger.info("Message has been sent");
                }
                else {
                    logger.info("Message not sent. HTTP error: ".concat(String.valueOf(responseCode)));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
