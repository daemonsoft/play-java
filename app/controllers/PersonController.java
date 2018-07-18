package controllers;

import models.Person;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.PersonService;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

public class PersonController extends Controller {

    public static final String APPLICATION_JSON = "application/json";
    private PersonService personService;

    @Inject
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    public CompletionStage<Result> all() {
        return personService.all().thenApply(personList -> ok(Json.prettyPrint(Json.toJson(personList))).as(APPLICATION_JSON));
    }

    public CompletionStage<Result> allBlocking() {
        return personService.allBlocking().thenApply(personList -> ok(Json.prettyPrint(Json.toJson(personList))).as(APPLICATION_JSON));
    }

    public CompletionStage<Result> register() {
        Person person = Json.fromJson(request().body().asJson(), Person.class);
        return personService.save(person).thenApply(response -> created(Json.prettyPrint(Json.toJson(response))).as(APPLICATION_JSON));
    }

    public CompletionStage<Result> registerBlocking() {
        Person person = Json.fromJson(request().body().asJson(), Person.class);
        return personService.saveBlocking(person).thenApply(response -> created(Json.prettyPrint(Json.toJson(response))).as(APPLICATION_JSON));
    }
}
