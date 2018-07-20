package controllers;

import models.Person;
import play.cache.AsyncCacheApi;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.PersonService;

import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.CompletionStage;

public class PersonController extends Controller {

    private PersonService personService;
    private AsyncCacheApi cache;

    @Inject
    public PersonController(PersonService personService, AsyncCacheApi cache) {
        this.cache = cache;
        this.personService = personService;
    }

    public CompletionStage<Result> all() {
        return cache.getOrElseUpdate("personList", this::allPersonFromDb).thenApplyAsync(personList -> ok(Json.toJson(personList)));
    }

    public CompletionStage<List<Person>> allPersonFromDb() {
        return personService.all();
    }


    public CompletionStage<Result> allBlocking() {
        return personService.allBlocking().thenApply(personList -> ok(Json.toJson(personList)));
    }

    public CompletionStage<Result> register() {
        Person person = Json.fromJson(request().body().asJson(), Person.class);

        return personService.save(person).thenApply(response -> created(Json.toJson(response)));
    }

    public CompletionStage<Result> registerBlocking() {
        Person person = Json.fromJson(request().body().asJson(), Person.class);
        return personService.saveBlocking(person).thenApply(response -> created(Json.toJson(response)));
    }
}
