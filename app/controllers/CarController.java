package controllers;

import models.Car;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.CarService;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

public class CarController extends Controller {

    private final CarService carService;

    @Inject
    public CarController(CarService carService) {
        this.carService = carService;
    }

    public CompletionStage<Result> index() {
        return carService.all().thenApply(cars -> ok(Json.toJson(cars)));
    }

    public CompletionStage<Result> insert() {
        Car car = Json.fromJson(request().body().asJson(), Car.class);
        return carService.save(car).thenApply(response -> {
            if (null == response) {
                return badRequest();
            }
            return created(Json.toJson(response));
        });
    }
}