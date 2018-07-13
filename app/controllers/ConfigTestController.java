package controllers;

import com.google.inject.Inject;
import com.typesafe.config.Config;
import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;

public class ConfigTestController extends Controller {

    private final Config config;

    @Inject
    public ConfigTestController(Config config) {
        this.config = config;
    }

    public Result index() {
        String applicationName = config.getString("application.name");
        Logger.info("application.name = " + applicationName);
        return ok(applicationName);
    }
}
