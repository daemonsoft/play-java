package controllers;

import akka.stream.javadsl.FileIO;
import akka.stream.javadsl.Source;
import akka.util.ByteString;
import play.http.HttpEntity;
import play.mvc.Controller;
import play.mvc.ResponseHeader;
import play.mvc.Result;

import java.io.File;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Optional;

public class ActionsController extends Controller {

    public Result anOkReturn() {
        return ok("This is an OK 200 return");
    }

    public Result aNotAuthorizedReturn() {
        return unauthorized("401 UNAUTHORIZED\n" +
                "The request has not been applied because it lacks valid authentication credentials for the target resource.");
    }

    public Result anInternalServerErrorReturn() {
        return internalServerError();
    }

    public Result aPdfFileReturn() {

        File file = new File("public/pdfs/sample.pdf");

        if(!file.exists() || !file.canRead()){
            return badRequest("Can´t read the file").as("text/html");
        }

        Path path = file.toPath();
        Source<ByteString, ?> source = FileIO.fromPath(path);
        Optional<Long> contentLength = Optional.of(file.length());

        return new Result(
                new ResponseHeader(200, Collections.emptyMap()),
                new HttpEntity.Streamed(source, contentLength, Optional.of("application/pdf"))
        );
    }
}

