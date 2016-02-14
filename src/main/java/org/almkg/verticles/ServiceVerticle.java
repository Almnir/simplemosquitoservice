package org.almkg.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.core.net.NetServer;
import io.vertx.core.parsetools.RecordParser;
import io.vertx.ext.jdbc.JDBCClient;
import io.vertx.ext.sql.SQLConnection;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.StaticHandler;
import org.almkg.database.CreateSQL;
import org.almkg.database.DBConstants;
import org.almkg.models.Device;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by yarnykh on 04.02.2016.
 */
public class ServiceVerticle extends AbstractVerticle {

    private Logger logger = LoggerFactory.getLogger(ServiceVerticle.class);
    private AtomicReference<SQLConnection> connection;
    private final String FROM_USER_EVENT_ADDRESS = "org.almkg.fromuser";
    private final String TO_USER_EVENT_ADDRESS = "org.almkg.touser";

    @Override
    public void start() throws Exception {
        logger.info("start service");
        JDBCClient client = JDBCClient.createShared(Vertx.vertx(), new JsonObject()
                .put("url", "jdbc:hsqldb:mem:test?shutdown=true")
                .put("driver_class", "org.hsqldb.jdbcDriver"));
        client.getConnection(res -> {
            if (res.succeeded()) {
                connection = new AtomicReference<>(res.result());
                connection.get().execute(CreateSQL.createDevice, event -> {
                    if (event.succeeded()) {
                        StringBuilder query = new StringBuilder();
                        Instant instant = Instant.now();
                        Timestamp ts = Timestamp.from(instant);
                        Date dt = Date.valueOf(ts.toLocalDateTime().toLocalDate());
                        Time time = Time.valueOf(ts.toLocalDateTime().toLocalTime());
                        logger.info(instant.toString());
                        logger.info(dt.toInstant().toString());
                        logger.info(time.toInstant().toString());
                        Device device = new Device.DeviceBuilder(549651730122213L).setDeviceDate(dt.toInstant()).setDeviceMode("a")
                                .setDeviceTime(time.toInstant()).setFlowControlEnabled(true).setFlowRateMode(1).setGasAvailability(true)
                                .setGasAvailabilityPrediction(1).setGasCylinderVolume(1).setHeaterTemperature(1.0f)
                                .setLightEnabled(true).setMotorTemperature(1.0f).setPassword("a").setReducerType(1).setTemperature(1.0f)
                                .setTimer1start(time.toInstant()).setTimer1stop(time.toInstant()).setTimer2start(time.toInstant())
                                .setTimer2stop(time.toInstant()).setUpdatedTimestamp(instant).setTimeUpdatedTimestamp(instant).setVersion("1")
                                .setWorkingTime(1).build();
                        String deviceString = device.toSQLString().getKey();
                        logger.info("deviceString: " + deviceString);
                        JsonArray deviceParams = device.toSQLString().getValue();
                        logger.info("deviceParams: " + deviceParams.toString());
                        query.append(DBConstants.INSERT_INTO).append(Device.TABLE_NAME).append(" ").append(deviceString)
                                .append(";");
                        logger.info(query.toString());
                        connection.get().updateWithParams(query.toString(), deviceParams, event1 -> {
                            if (event1.succeeded()) {
                                // общая шина сообщений
                                EventBus eventBus = vertx.eventBus();

                                // HTTP
                                Router router = Router.router(vertx);
                                router.route().handler(BodyHandler.create());
                                router.route(HttpMethod.POST, "/").consumes("application/json").handler(context -> {
                                    logger.info(context.getBody());
                                    JsonObject values = context.getBodyAsJson();
                                    if (values != null && values.size() != 0) {
                                        logger.info("POST запрос от клиента с данными прилетел!");
                                        logger.info(values.toString());
                                        // полетело по шине
                                        eventBus.send(FROM_USER_EVENT_ADDRESS, values.toString());
                                    }
                                    HttpServerResponse response = context.response();
                                    response.setStatusCode(204).end();
                                });
                                router.route().handler(StaticHandler.create());
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

                                        eventBus.consumer(FROM_USER_EVENT_ADDRESS, eventb -> {
                                            logger.info("данные от клиента обновить!");
                                            logger.info(eventb.body());
                                        });
                                    } else {
                                        logger.info("TCP Сервер не удалось запустить!");
                                    }
                                });

                            } else {
                                logger.fatal("execute sql statement failed ");
                                event1.cause().printStackTrace();
                            }
                        });
                    } else {
                        logger.fatal("create sql statement failed ");
                        event.cause().printStackTrace();
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
