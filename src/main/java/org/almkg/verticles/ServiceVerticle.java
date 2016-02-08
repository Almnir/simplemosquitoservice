package org.almkg.verticles;

import com.darylteo.vertx.promises.java.Promise;
import com.google.inject.Inject;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.core.net.NetServer;
import io.vertx.core.parsetools.RecordParser;
import io.vertx.ext.jdbc.JDBCClient;
import io.vertx.ext.sql.SQLConnection;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;
import org.almkg.database.IDBConnection;
import org.almkg.database.QueryDAO;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by yarnykh on 04.02.2016.
 */
public class ServiceVerticle extends AbstractVerticle {

    private Logger logger = LoggerFactory.getLogger(ServiceVerticle.class);
    private AtomicReference<SQLConnection> connection;
    private final String EVENT_ADDRESS = "datatest";

    @Override
    public void start() throws Exception {
        JDBCClient client = JDBCClient.createShared(Vertx.vertx(), new JsonObject()
                .put("url", "jdbc:hsqldb:mem:test?shutdown=true")
                .put("driver_class", "org.hsqldb.jdbcDriver"));
        client.getConnection(res -> {
            if (res.succeeded()) {
                connection = new AtomicReference<>(res.result());

                // общая шина сообщений
                EventBus eventBus = vertx.eventBus();

                // HTTP
                Router router = Router.router(vertx);
                router.route().handler(StaticHandler.create().setWebRoot("public"));
                router.post("/form").produces("application/json").handler(context -> {
                    JsonObject values = context.getBodyAsJson();
                    if (values.size() != 0) {
                        logger.debug("POST запрос от клиента с данными прилетел!");
                        logger.debug(values.toString());
                        // полетело по шине
                        eventBus.send(EVENT_ADDRESS, values.toString());
                    }
                    HttpServerResponse response = context.response();
//                    response.putHeader("content-type", "application/json");
//                    response.write(new JsonObject().put("dsd","dsd").encode()).end();
                    response.end();
                });
                vertx.createHttpServer().requestHandler(router::accept).listen(8080);

                // TCP

                NetServer server = vertx.createNetServer();
                ArrayList<String> myList = new ArrayList<String>();
                server.connectHandler(socket -> {
                    myList.add(socket.writeHandlerID());
                    socket.handler(RecordParser.newDelimited("\n", buffer -> {
                        logger.info("Получил данные с ведра!"+ buffer.toString());
                        for ( String s: myList) {
                            if (!s.equals(socket.writeHandlerID())) {
                                vertx.eventBus().publish(s, buffer);
                            }
                        }
                        //socket.write(buffer);
                    }));
                    socket.closeHandler(v -> {
                        myList.remove(socket.writeHandlerID());
                        logger.info("Обработчик закрылся");
                    });
                });

                server.listen(4321, "localhost", tcpres -> {
                    if (tcpres.succeeded()) {
                        logger.info("TCP Сервер запущен!");

                        // eventbus подписчик

                        eventBus.consumer("data", event -> {
                            logger.debug("данные от клиента обновить!");
                            logger.debug(event.body());
                        });
                    } else {
                        logger.info("TCP Сервер не удалось запустить!");
                    }
                });


                // DB connection
            } else {
                logger.fatal("Cannot create DB connection!");
                logger.fatal(res.cause().getMessage());
                vertx.close();
            }
        });


        super.start();
    }

    @Override
    public void stop() throws Exception {
        connection.get().close();
        super.stop();
    }
}
