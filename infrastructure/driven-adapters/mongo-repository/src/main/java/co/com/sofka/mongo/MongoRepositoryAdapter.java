package co.com.sofka.mongo;

import co.com.sofka.model.persona.Person;
import co.com.sofka.model.persona.gateways.PersonRepository;
import co.com.sofka.mongo.document.PersonDocument;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Repository
public class MongoRepositoryAdapter extends AdapterOperations<Person, PersonDocument, String, MongoDBRepository>


{


    public MongoRepositoryAdapter(MongoDBRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Person.class));
    }

}
