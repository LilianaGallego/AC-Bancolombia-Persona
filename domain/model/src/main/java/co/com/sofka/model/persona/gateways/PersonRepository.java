package co.com.sofka.model.persona.gateways;

import co.com.sofka.model.persona.Person;
import reactor.core.publisher.Mono;

public interface PersonRepository {
    Mono<Person> create(Person persona);
}
