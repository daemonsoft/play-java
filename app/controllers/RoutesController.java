package controllers;

import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;

public class RoutesController extends Controller {

    public static final String TEXT_HTML = "text/html";

    public Result get() {
        return ok("This is a GET method test").as(TEXT_HTML);
    }

    public Result post() {
        return created("This is a POST method test").as(TEXT_HTML);
    }

    public Result put() {
        return created("This is a PUT method test").as(TEXT_HTML);
    }

    public Result patch() {
        return ok("This is a PATCH method test").as(TEXT_HTML);
    }

    public Result delete() {
        return ok("This is a DELETE method test").as(TEXT_HTML);
    }

    public Result query(String name) {

        return ok("Query parameter " + name).as(TEXT_HTML);
    }

    public Result path(String name) {
        return ok("Path parameter name=" + name).as(TEXT_HTML);
    }

    public Result headers() {

        Logger.info("<-- HEADERS -->");
        request().getHeaders().toMap().forEach((header, list) -> {
            Logger.info(header);
        });
        Logger.info("<-- END -->");

        return ok("Printing headers").as(TEXT_HTML);
    }

    public Result cookies() {

        Logger.info("<-- COOKIES -->");

        request().cookies().forEach(cookie -> Logger.info("Cookie name=" + cookie.name() + " value=" + cookie.value()));

        Logger.info("<-- END -->");

        return ok("Printing cookies").as(TEXT_HTML);
    }
}
