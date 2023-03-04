package co.com.sofka.events;

import co.com.sofka.model.persona.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQPublisher {
    public static final String EXCHANGE = "core-posts-events";

    public static final String ROUTING_KEY = "events.routing.key";

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQPublisher.class);

    private RabbitTemplate rabbitTemplate;

    public RabbitMQPublisher(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendJsonMessage(Person person){
        LOGGER.info(String.format("Message sent -> %s", person.toString()));
        rabbitTemplate.convertAndSend(EXCHANGE,ROUTING_KEY,person);
    }

}
