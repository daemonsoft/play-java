package controllers;

import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;

public class RoutesController extends Controller {

    public Result get() {
        return ok("This is a GET method test").as("text/html");
    }

    public Result post() {
        return created("This is a POST method test").as("text/html");
    }

    public Result put() {
        return created("This is a PUT method test").as("text/html");
    }

    public Result patch() {
        return ok("This is a PATCH method test").as("text/html");
    }

    public Result delete() {
        return ok("This is a DELETE method test").as("text/html");
    }

    public Result query(String name) {

        return ok("Query parameter " + name).as("text/html");
    }

    public Result path(String name) {
        return ok("Path parameter name=" + name).as("text/html");
    }

    public Result headers() {

        Logger.info("<-- HEADERS -->");
        request().getHeaders().toMap().forEach((header, list) -> {
            Logger.info(header);
        });
        Logger.info("<-- END -->");

        return ok("Printing headers").as("text/html");
    }

    public Result cookies() {

        Logger.info("<-- COOKIES -->");

        request().cookies().forEach(cookie -> Logger.info("Cookie name=" + cookie.name() + " value=" + cookie.value()));

        Logger.info("<-- END -->");

        return ok("Printing cookies").as("text/html");
    }

}
