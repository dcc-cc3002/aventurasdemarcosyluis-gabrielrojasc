package com.example.aventurasdemarcoyluis;

public class HoneySyrup extends abstractItem {

  public HoneySyrup() {
    super();
    this.name = "HoneySyrup";
  }

  public void applyTo(Players player) {
    int currFp = player.getFp();
    player.setFp(currFp + 3);
  }
}
