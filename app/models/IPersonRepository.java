package models;

import com.google.inject.ImplementedBy;

import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;

@ImplementedBy(PersonRepository.class)
public interface IPersonRepository {

    CompletionStage<Person> add(Person person);

    CompletionStage<List<Person>> list();
}