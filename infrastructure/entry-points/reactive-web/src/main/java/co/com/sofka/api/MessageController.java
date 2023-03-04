package co.com.sofka.api;

import co.com.sofka.events.RabbitMQPublisher;
import co.com.sofka.model.persona.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

    private RabbitMQPublisher producer;

    public MessageController(RabbitMQPublisher producer) {
        this.producer = producer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestBody Person person){
        producer.sendJsonMessage(person);
        return  ResponseEntity.ok("Message sent to RabbitMQ ...");

    }
}
