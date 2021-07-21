package com.example.starter;

import io.vertx.core.buffer.Buffer;
import io.vertx.core.eventbus.MessageCodec;

public class IdentityCodec implements MessageCodec {
  private final Class aClass;

  public IdentityCodec(Class aClass) {
    this.aClass = aClass;
  }

  @Override
  public void encodeToWire(Buffer buffer, Object o) {

  }

  @Override
  public Object decodeFromWire(int pos, Buffer buffer) {
    return null;
  }

  @Override
  public Object transform(Object o) {
    return o;
  }

  @Override
  public String name() {
    return aClass.getName() + "Codec";
  }

  @Override
  public byte systemCodecID() {
    return -1;
  }
}
