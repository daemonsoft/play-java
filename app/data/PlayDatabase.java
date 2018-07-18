package data;

import org.h2.engine.Database;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.sql.Connection;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Singleton
class PlayDatabase {

    private Database db;
    private DatabaseExecutionContext executionContext;

    @Inject
    public PlayDatabase(Database db, DatabaseExecutionContext context) {
        this.db = db;
        this.executionContext = executionContext;
    }

    public CompletionStage<Void> updateSomething() {
        return CompletableFuture.runAsync(() -> {
            // get jdbc connection
            Connection connection = db.getLobConnectionForInit();

            // do whatever you need with the db connection
            return;
        }, executionContext);
    }
}