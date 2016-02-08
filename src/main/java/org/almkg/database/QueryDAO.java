package org.almkg.database;

import com.darylteo.vertx.promises.java.Promise;
import com.google.inject.Inject;
import io.vertx.core.json.JsonArray;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.sql.SQLConnection;
import io.vertx.ext.sql.UpdateResult;
import org.almkg.models.User;

/**
 * Created by yarnykh on 04.02.2016.
 */
public class QueryDAO {


    private IDBConnection connection;
    private static Logger logger = LoggerFactory.getLogger(QueryDAO.class);
//    public QueryDAO(IDBConnection conn) {
//        connection = conn;
//    }

    public static Promise createTables(SQLConnection connection) {
        final Promise promise = new Promise();
        StringBuilder query = new StringBuilder();
        query.append(DBConstants.CREATE).append(" user (login varchar(255), passwd varchar(255), passwd_salt varchar(255), name varchar(255));");
        connection.execute(query.toString(), event -> {
            if (event.succeeded()) {
                promise.fulfill(null);
            } else {
                promise.reject(event.cause());
            }
        });
        return promise;
    }

    public static Promise createUser(SQLConnection connection, String login, String password, String passwordSalt, String name) {
        final Promise promise = new Promise();
        StringBuilder query = new StringBuilder();
        query.append(DBConstants.INSERT_INTO).append(User.TABLE_NAME)
                .append(" (")
                .append(User.LOGIN_FIELD).append(User.PASSWORD_FIELD).append(User.PASSWORD_SALT_FIELD).append(User.NAME_FIELD)
                .append(") ")
                .append("values (?,?,?,?);");
        JsonArray params = new JsonArray().add(login).add(password).add(passwordSalt).add(name);
        connection.updateWithParams(query.toString(), params, res -> {
            if (res.succeeded()) {
                UpdateResult updateResult = res.result();
                logger.info("created user" + name);
                logger.info("No of rows updated: " + updateResult.getUpdated());
                promise.fulfill(null);
            } else {
                logger.error("Error while createUser(" + name + ")");
                promise.reject(res.cause());
            }
        });
        return promise;
    }
}
