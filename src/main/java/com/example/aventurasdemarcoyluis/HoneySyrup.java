package com.example.aventurasdemarcoyluis;

public class HoneySyrup implements Items {

  private String name = "HoneySyrup";

  public HoneySyrup() {}

  public String getName() {
    return name;
  }

  public void applyTo(Players player) {
    int currFp = player.getFp();
    player.setFp(currFp + 3);
  }
}
