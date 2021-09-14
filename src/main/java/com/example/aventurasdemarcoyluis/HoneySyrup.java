package com.example.aventurasdemarcoyluis;

public class HoneySyrup implements Items {
  public HoneySyrup() {}

  public void applyTo(Players player) {
    int currFp = player.getFp();
    player.setFp(currFp + 3);
  }
}
