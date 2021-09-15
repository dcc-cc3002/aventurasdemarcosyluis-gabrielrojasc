package com.example.aventurasdemarcoyluis;

public class Star extends abstractItem {

  public Star() {
    super();
    this.name = "Star";
  }

  public void applyTo(Players player) {
    int currHp = player.getHp();
  }
}
