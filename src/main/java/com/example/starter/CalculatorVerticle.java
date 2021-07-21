package com.example.starter;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;

public class CalculatorVerticle extends AbstractVerticle {

  @Override
  public void start() {
    this.registerConsumer();
  }

  private void registerConsumer() {
    EventBus eb = vertx.eventBus();

    //Add consumer
    eb.consumer("vertx.calculator.add", msg -> {
      Holder temp = (Holder)msg.body();
      msg.reply(String.format("Hello, sum = %d", temp.getFirstNum() + temp.getSecondNum()));
    });

    //Subtract consumer
    eb.consumer("vertx.calculator.subtract", msg -> {
      Holder temp = (Holder)msg.body();
      msg.reply(String.format("Hello, difference = %d", temp.getFirstNum() - temp.getSecondNum()));
    });

    //Multiply consumer
    eb.consumer("vertx.calculator.multiply", msg -> {
      Holder temp = (Holder)msg.body();
      msg.reply(String.format("Hello, product = %d", temp.getFirstNum() * temp.getSecondNum()));
    });
  }
}
