package co.com.sofka.mongo.helper;

import co.com.sofka.model.persona.Person;
import co.com.sofka.model.persona.gateways.PersonRepository;
import co.com.sofka.mongo.MongoDBRepository;
import co.com.sofka.mongo.MongoRepositoryAdapter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class PersonRepositoryImpl implements PersonRepository {

    private final MongoRepositoryAdapter dto;


    @Override
    public Mono<Person> create(Person person) {
        return dto.save(person);
    }
}

