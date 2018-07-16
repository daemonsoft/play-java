package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class RoutesController extends Controller {

    public Result get(){
        return ok("This is a GET test");
    }

    public Result post(){
        return created("This is a POST method test");
    }

    public Result put(){
        return created("This is a PUT method test");
    }

    public Result patch(){
        return ok("This is a PATCH method test");
    }

    public Result delete(){
        return ok("This is a DELETE method test");
    }
}
