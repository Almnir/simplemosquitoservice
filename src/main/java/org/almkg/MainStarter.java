package org.almkg;

import io.vertx.core.*;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import org.almkg.verticles.ServiceVerticle;

import java.io.File;
import java.io.IOException;
import java.util.function.Consumer;

/**
 * Created by yarnykh on 04.02.2016.
 */
public class MainStarter {

    public static void main(String[] args) {
//        Injector injector = Guice.createInjector(binder -> {
//            binder.bind(IDBConnection.class).to(DBConnection.class);
//        });
        VertxOptions options = new VertxOptions().setClustered(false);
        DeploymentOptions deploymentOptions = new DeploymentOptions();
        deploymentOptions.setInstances(4);
        String verticleID = ServiceVerticle.class.getName();
        runVerticle(verticleID, options, deploymentOptions, handler -> {
            if (!handler.succeeded()) {
                System.out.println("Service verticle failed to deploy!");
                handler.cause().printStackTrace();
            }

        });
    }

    static void runVerticle(String verticleID, VertxOptions options, DeploymentOptions
            deploymentOptions, Handler<AsyncResult<String>> completionHandler) {
        if (options == null) {
            options = new VertxOptions();
        }
        String dir = "simplemosquitoservice/src/main/java/verticles/";

        try {
            File current = new File(".").getCanonicalFile();
            if (dir.startsWith(current.getName()) && !dir.equals(current.getName())) {
                dir = dir.substring(current.getName().length() + 1);
            }
        } catch (IOException e) {
        }

        System.setProperty("vertx.cwd", dir);

        Consumer<Vertx> runner = vertx -> {
            try {
                if (deploymentOptions != null) {
                    vertx.deployVerticle(verticleID, deploymentOptions, completionHandler);
                } else {
                    vertx.deployVerticle(verticleID, completionHandler);
                }
            } catch (Throwable t) {
                t.printStackTrace();
            }
        };
        Vertx vertx = Vertx.vertx(options);
        runner.accept(vertx);
    }
}
