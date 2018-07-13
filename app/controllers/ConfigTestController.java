package controllers;

import com.google.inject.Inject;
import com.typesafe.config.Config;

import play.mvc.Controller;
import play.mvc.*;

public class ConfigTestController extends Controller{

	@Inject
	Config config;
	
	public Result index() {
		
		return ok(config.getString("application.name"));
	}
}
