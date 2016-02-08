package org.almkg.database;

import com.darylteo.vertx.promises.java.Promise;
import io.vertx.ext.sql.SQLConnection;

/**
 * Created by yarnykh on 04.02.2016.
 */
public interface IDBConnection {
    public Promise<SQLConnection> getConnection();
}
