package co.com.sofka.api;

import co.com.sofka.model.persona.Person;
import co.com.sofka.model.persona.gateways.PersonRepository;
import co.com.sofka.usecase.create.CreateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {
    private final CreateUseCase createUseCase;



    //private  final UseCase useCase;
//private  final UseCase2 useCase2;
    public Mono<ServerResponse> listenGETUseCase(ServerRequest serverRequest) {
        // usecase.logic();
        return ServerResponse.ok().bodyValue("");
    }

    public Mono<ServerResponse> listenGETOtherUseCase(ServerRequest serverRequest) {
        // useCase2.logic();
        return ServerResponse.ok().bodyValue("");
    }

    public Mono<ServerResponse> createPerson(ServerRequest serverRequest) {
        // usecase.logic();
        Mono<Person> personMono = serverRequest.bodyToMono((Person.class));

        return personMono.flatMap(person -> ServerResponse.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON)
                .body(createUseCase.create(person), Person.class));
    }
}
