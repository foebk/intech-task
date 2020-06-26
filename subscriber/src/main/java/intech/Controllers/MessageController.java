package intech.Controllers;

import intech.DTO.MessageDTO;
import intech.Services.ActionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    private final ActionService actionService;

    Logger logger = LogManager.getLogger(MessageController.class);

    @Autowired
    public MessageController(ActionService actionService) {
        this.actionService = actionService;
    }

    @PostMapping("/sendMessage")
    public String getMessage(@RequestBody MessageDTO messageDTO) {
        logger.info("Message has been received. Content: \n" + messageDTO.toString());
        logger.info("Trying save entity...");
        actionService.saveAction(messageDTO);
        logger.info("Entity saved");
        return "ok";
    }
}
