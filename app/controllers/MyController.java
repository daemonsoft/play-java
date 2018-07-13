package controllers;

import play.mvc.*;

public class MyController extends Controller {
	
    public Result index() {
    	
        return ok("Controller test");
    }
}
