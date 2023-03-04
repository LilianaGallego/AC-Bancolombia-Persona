package co.com.sofka.usecase.create.getways;

import co.com.sofka.model.persona.Person;

public interface EventPublisher {
    void publish(Person person);
}
