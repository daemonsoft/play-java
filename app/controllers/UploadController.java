package controllers;

import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

import java.io.File;

public class UploadController extends Controller {

    public Result index() {
        return ok(views.html.upload.render());
    }

    public Result upload() {
        Http.MultipartFormData<File> body = request().body().asMultipartFormData();
        Http.MultipartFormData.FilePart<File> data = body.getFile("data");

        if (data != null) {
            String fileName = data.getFilename();

            File file = data.getFile();

            File destination = new File("c:\\temp", fileName);
            boolean fileMove = file.renameTo(destination);

            if (!fileMove) {
                return badRequest("Error saving file");
            }

            return ok("File " + fileName + " uploaded to C:\\temp");

        } else {

            return badRequest("Missing file");

        }
    }
}
