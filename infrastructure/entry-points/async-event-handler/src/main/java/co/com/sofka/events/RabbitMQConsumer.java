package co.com.sofka.events;

import co.com.sofka.model.persona.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {
    public static final String EVENTS_QUEUE = "events.queue";
    public static final String GENERAL_QUEUE = "general.queue";
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConsumer.class);

    @RabbitListener(queues = EVENTS_QUEUE)
    public void  consultJson(Person person){
        LOGGER.info(String.format("Recieved Json message ->%s", person.toString()));
    }
}
