package org.almkg.database;

import com.darylteo.vertx.promises.java.Promise;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.sql.SQLConnection;

/**
 * Created by yarnykh on 04.02.2016.
 */
public class DBConnection implements IDBConnection {

    private static Logger logger = LoggerFactory.getLogger(DBConnection.class);

    @Override
    public Promise<SQLConnection> getConnection() {
        return null;
    }

//    @Override
//    public Promise<SQLConnection> getConnection() {
//        final Promise<SQLConnection> promise = new Promise();
//            JDBCClient client = JDBCClient.createShared(Vertx.vertx(), new JsonObject()
//                    .put("url", "jdbc:hsqldb:mem:test?shutdown=true")
//                    .put("driver_class", "org.hsqldb.jdbcDriver"));
//            client.getConnection(res -> {
//                if (res.succeeded()) {
//                    SQLConnection connection = res.result();
//                    promise.fulfill(connection);
//                } else {
//                    logger.fatal("Cannot create DB connection!");
//                    promise.reject(res.cause());
//                }
//            });
//        return promise;
//    }
}