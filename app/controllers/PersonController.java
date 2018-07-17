package controllers;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.PersonService;

import javax.inject.Inject;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;

public class PersonController extends Controller {


    private PersonService personService;

    @Inject
    PersonController(PersonService personService) {
        this.personService = personService;
    }

    public CompletionStage<Result> all() throws ExecutionException, InterruptedException {
        return CompletableFuture.completedFuture(ok(Json.prettyPrint(Json.toJson(personService.all().get()))));
    }
}
