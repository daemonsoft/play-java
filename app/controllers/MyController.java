package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.User;
import play.mvc.Controller;
import play.mvc.Result;

public class MyController extends Controller {

    public Result index() {
        return ok("Controller test");
    }

    public Result jacksonTest() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        User user = new User();
        user.setName("Jackson");
        user.setLastname("Generate");
        return ok(mapper.writeValueAsString(user));
    }
}
