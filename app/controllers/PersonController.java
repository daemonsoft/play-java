package controllers;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.PersonService;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

public class PersonController extends Controller {

    private PersonService personService;

    @Inject
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    public Result all() {
        return ok(Json.prettyPrint(Json.toJson(personService.all())));
    }

    public CompletionStage<Result> allBlocking() {
        return personService.allBlocking().thenApply(personList -> ok(Json.prettyPrint(Json.toJson(personList))));
    }
}
