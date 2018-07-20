package services;


import models.IPersonRepository;
import models.Person;
import play.libs.concurrent.Futures;

import javax.inject.Inject;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import static java.time.temporal.ChronoUnit.SECONDS;

public class PersonService {

    private List<Person> personList;
    private final Futures futures;
    private IPersonRepository personRepository;

    @Inject
    public PersonService(Futures futures, IPersonRepository personRepository) {
        this.futures = futures;
        this.personRepository = personRepository;

        personList = new ArrayList<>();
        Person person;
        for (int i = 0; i < 10; i++) {
            person = new Person();
            person.setName("Name " + (i + 1));
            person.setLastname("Lastname " + (i + 1));
            personList.add(person);
        }
    }

    public CompletionStage<List<Person>> all() {
        return personRepository.list();
    }

    public CompletionStage<List<Person>> allBlocking() {
        return futures.delayed(() -> CompletableFuture.supplyAsync(() -> personList), Duration.of(2, SECONDS));
    }

    public CompletionStage<Person> save(Person person) {

        return personRepository.add(person);
    }

    public CompletionStage<Person> saveBlocking(Person person) {
        return futures.delayed(() -> CompletableFuture.supplyAsync(() -> {
            personList.add(person);
            return person;
        }), Duration.of(2, SECONDS));
    }
}
