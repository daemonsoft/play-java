package controllers;

import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

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

        return ok();
    }
}
