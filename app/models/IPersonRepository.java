package models;

import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;

import com.google.inject.ImplementedBy;

@ImplementedBy(PersonRepository.class)
public interface IPersonRepository {

    CompletionStage<Person> add(Person person);

    CompletionStage<Stream<Person>> list();
}