package services;


import models.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class PersonService {

    private List<Person> personList;

    public PersonService() {
        personList = new ArrayList<>();
        Person person;
        for (int i = 0; i< 10 ; i++){
            person = new Person();
            person.setName("Name " + (i+1));
            person.setLastname("Lastname " + (i+1));
            personList.add(person);
        }
    }

    public CompletableFuture<List<Person>> all(){
        return CompletableFuture.completedFuture(personList);
    }


}
