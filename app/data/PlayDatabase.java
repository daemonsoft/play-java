package data;

import models.Person;
import play.db.Database;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Singleton
public class PlayDatabase {

    private Database db;

    @Inject
    public PlayDatabase(Database db) {
        this.db = db;
    }

    public CompletionStage<Void> save(Person person) {
        return CompletableFuture.runAsync(() -> {
            // get jdbc connection
            Connection connection = db.getConnection();
            try {
                System.out.println("conn  "+ connection.getClientInfo());

            } catch (SQLException e) {
                e.printStackTrace();
            }
            // do whatever you need with the db connection
            return;
        });
    }
}