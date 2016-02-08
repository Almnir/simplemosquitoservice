package org.almkg;

import com.google.inject.Guice;
import com.google.inject.Injector;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import org.almkg.database.DBConnection;
import org.almkg.database.IDBConnection;
import org.almkg.verticles.ServiceVerticle;

/**
 * Created by yarnykh on 04.02.2016.
 */
public class MainStarter {

    private static Logger logger = LoggerFactory.getLogger(MainStarter.class);

    public static void main(String[] args) {
//        Injector injector = Guice.createInjector(binder -> {
//            binder.bind(IDBConnection.class).to(DBConnection.class);
//        });
        ServiceVerticle serviceVerticle = new ServiceVerticle();
        DeploymentOptions options = new DeploymentOptions();
        options.setInstances(4);
        Vertx.vertx().deployVerticle(serviceVerticle, options, res -> {
            if (res.succeeded()) {
                logger.info("Service verticle deployed!");
            } else {
                logger.fatal("Service verticle failed to deploy!");
            }
        });
    }
}
