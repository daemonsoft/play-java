package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Person;
import play.mvc.Controller;
import play.mvc.Result;

public class MyController extends Controller {

    public Result index() {
        return ok("Controller test");
    }

    public Result jacksonTest() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Person person = new Person();
        person.setName("Jackson");
        person.setLastname("Generated");
        return ok(mapper.writeValueAsString(person));
    }
}
