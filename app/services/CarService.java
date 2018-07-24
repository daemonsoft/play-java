package services;

import com.fasterxml.jackson.databind.JsonNode;
import models.Car;
import play.libs.Json;
import play.libs.ws.WSBodyReadables;
import play.libs.ws.WSBodyWritables;
import play.libs.ws.WSClient;
import play.libs.ws.WSResponse;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionStage;

public class CarService implements WSBodyReadables, WSBodyWritables {
    private final WSClient ws;
    private String url = "http://localhost:9001/vehicle";

    @Inject
    public CarService(WSClient ws) {
        this.ws = ws;
    }

    public CompletionStage<List<Car>> all() {
        return ws.url(url)
                .get()
                .thenApply((WSResponse r) -> {
                    List<Car> cars = new ArrayList<>();

                    r.getBody(json()).elements().forEachRemaining(jsonNode -> cars.add(Json.fromJson(jsonNode, Car.class)));

                    return cars;
                });
    }

    public CompletionStage<Car> save(Car car) {
        JsonNode json = Json.toJson(car);
        return ws.url(url).post(json).thenApplyAsync(wsResponse -> {
            if (wsResponse.getStatus() == 201) {
                return car;
            }
            return null;
        });
    }
}
