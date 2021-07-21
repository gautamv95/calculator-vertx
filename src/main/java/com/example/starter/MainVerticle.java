package com.example.starter;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.MultiMap;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainVerticle extends AbstractVerticle {

  private static final Logger logger = LoggerFactory.getLogger(MainVerticle.class);

  @Override
  public void start() {
    vertx.eventBus().registerDefaultCodec(Holder.class, new IdentityCodec(Holder.class));
    Integer port = 3000;
    vertx.deployVerticle(new CalculatorVerticle());
    Router router = Router.router(vertx);
    router.get("/add").handler(this::add);
    router.get("/subtract").handler(this::subtract);
    router.get("/multiply").handler(this::multiply);
    router.get("/").handler(this::hello);

    logger.info("Started HTTP Server, on port: ", port);
    vertx.createHttpServer().requestHandler(router).listen(port);
  }

  void hello(RoutingContext ctx) {
    ctx.request().response().end("Hello");
  }

  void add(RoutingContext ctx) {
    Holder holder = new Holder(0,0);
    MultiMap qParams = ctx.queryParams();
    if(qParams.contains("l1") && qParams.contains("l2")) {
      holder.setFirstNum(Integer.parseInt(qParams.get("l1")));
      holder.setSecondNum(Integer.parseInt(qParams.get("l2")));
    }
    vertx.eventBus().request("vertx.calculator.add", holder, reply -> {
      ctx.request().response().end((String)reply.result().body());
    });
  }

  void subtract(RoutingContext ctx) {
    Holder holder = new Holder(0,0);
    MultiMap qParams = ctx.queryParams();
    if(qParams.contains("l1") && qParams.contains("l2")) {
      holder.setFirstNum(Integer.parseInt(qParams.get("l1")));
      holder.setSecondNum(Integer.parseInt(qParams.get("l2")));
    }
    vertx.eventBus().request("vertx.calculator.subtract", holder, reply -> {
      ctx.request().response().end((String)reply.result().body());
    });
  }

  void multiply(RoutingContext ctx) {
    Holder holder = new Holder(0,0);
    MultiMap qParams = ctx.queryParams();
    if(qParams.contains("l1") && qParams.contains("l2")) {
      holder.setFirstNum(Integer.parseInt(qParams.get("l1")));
      holder.setSecondNum(Integer.parseInt(qParams.get("l2")));
    }
    vertx.eventBus().request("vertx.calculator.multiply", holder, reply -> {
      ctx.request().response().end((String)reply.result().body());
    });
  }
}
