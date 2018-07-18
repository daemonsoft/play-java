package services;


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

    @Inject
    public PersonService(Futures futures) {
        this.futures = futures;
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
        return CompletableFuture.completedFuture(personList);
    }

    public CompletionStage<List<Person>> allBlocking() {
        return futures.delayed(() -> CompletableFuture.supplyAsync(() -> personList), Duration.of(2, SECONDS));
    }

    public CompletionStage<Person> save(Person person) {

        personList.add(person);

        return CompletableFuture.completedFuture(person);
    }

    public CompletionStage<Person> saveBlocking(Person person) {
        return futures.delayed(() -> CompletableFuture.supplyAsync(() -> {
            personList.add(person);
            return person;
        }), Duration.of(2, SECONDS));
    }
}
