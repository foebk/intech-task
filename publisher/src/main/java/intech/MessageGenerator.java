package intech;

import java.time.Instant;
import java.util.Random;

public class MessageGenerator {
    public static MessageDTO generateMessage() {
        MessageDTO messageDTO = new MessageDTO();
        String[] actions = {"PURCHASE", "SUBCRIPTION"};

        Random random = new Random();

        messageDTO.setMsisdn(random.nextInt(1000000000));
        messageDTO.setAction(actions[random.nextInt(2)]);
        messageDTO.setTimestamp(Instant.now().getEpochSecond());

        return messageDTO;
    }
}
