package controllers;

import actors.HelloActor;
import actors.HelloActorProtocol;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import play.mvc.Controller;
import play.mvc.Result;
import scala.compat.java8.FutureConverters;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.concurrent.CompletionStage;

import static akka.pattern.Patterns.ask;

@Singleton
public class HelloActorController extends Controller {

    final ActorRef helloActor;

    @Inject
    public HelloActorController(ActorSystem actorSystem) {
        helloActor = actorSystem.actorOf(HelloActor.getProps());
    }

    public CompletionStage<Result> sayHello(String name) {
        return FutureConverters.toJava(ask(helloActor, new HelloActorProtocol.SayHello(name), 1000))
                .thenApply(response -> ok((String) response));
    }
}
