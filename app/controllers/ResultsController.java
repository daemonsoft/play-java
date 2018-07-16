package controllers;

import actions.AuthAction;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.With;

public class ResultsController extends Controller {

    public Result customResponse() {

        response().setHeader("header-name", "header-value");

        response().setCookie(
                Http.Cookie.builder("mycookie", "cookie-test")
                        .withSecure(false)
                        .withHttpOnly(true)
                        .withSameSite(Http.Cookie.SameSite.STRICT)
                        .build()
        );

        return ok("Response with custom header and cookie").as("text/html");
    }

    @With(AuthAction.class)
    public Result composedAction() {
        return ok("Token exists").as("text/html");
    }
}