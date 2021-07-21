package com.example.starter;

public class Holder {
  private Integer firstNum;
  private Integer secondNum;

  public Holder() {
  }

  public Holder(Integer firstNum, Integer secondNum) {
    this.firstNum = firstNum;
    this.secondNum = secondNum;
  }

  public Integer getFirstNum() {
    return firstNum;
  }

  public void setFirstNum(Integer firstNum) {
    this.firstNum = firstNum;
  }

  public Integer getSecondNum() {
    return secondNum;
  }

  public void setSecondNum(Integer secondNum) {
    this.secondNum = secondNum;
  }
}
