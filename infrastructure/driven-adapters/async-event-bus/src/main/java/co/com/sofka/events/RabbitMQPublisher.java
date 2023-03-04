package co.com.sofka.events;

import co.com.sofka.model.persona.Person;
import co.com.sofka.usecase.create.getways.EventPublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class RabbitMQPublisher implements EventPublisher {
    public static final String EXCHANGE = "core-posts-events";

    public static final String ROUTING_KEY = "events.routing.key";

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQPublisher.class);

    private RabbitTemplate rabbitTemplate;

    public RabbitMQPublisher(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }


    @Override
    public void publish(Person person) {
        LOGGER.info(String.format("Message sent -> %s", person.toString()));
        rabbitTemplate.convertAndSend(EXCHANGE,ROUTING_KEY,person);

    }
}
