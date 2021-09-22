package com.example.aventurasdemarcoyluis;

public class Star extends abstractItem {

  public Star() {
    super();
    this.name = "Star";
  }

  public void applyTo(IPlayers player) {
    int currHp = player.getHp();
    long stopTime = System.currentTimeMillis() + 6000;
    while (System.currentTimeMillis() < stopTime) {
      player.setHp(currHp);
    }
  }
}
