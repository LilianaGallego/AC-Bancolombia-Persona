package co.com.sofka.usecase.create;

import co.com.sofka.model.persona.Person;
import co.com.sofka.model.persona.gateways.PersonRepository;
import co.com.sofka.usecase.create.getways.EventPublisher;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreateUseCase {
    private final  PersonRepository personaRepository;
    private final EventPublisher eventPublisher;

    public Mono<Person> createPerson(Person persona)
    {
        return personaRepository.create(persona)
                .map(persona1 -> {eventPublisher.publish(persona1);
                    return  persona1;
                });
    }

}
