package actions;

import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Results;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class AuthAction extends Action.Simple {

    private static final String TOKEN = "tkn";

    @Override
    public CompletionStage<Result> call(Http.Context ctx) {
        if (ctx._requestHeader().headers().get(TOKEN).isEmpty()) {
            return CompletableFuture.completedFuture(Results.forbidden("Not authorized").as("text/html"));
        }
        return delegate.call(ctx);
    }
}
