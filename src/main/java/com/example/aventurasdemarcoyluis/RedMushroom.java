package com.example.aventurasdemarcoyluis;

public class RedMushroom extends abstractItem {

  public RedMushroom() {
    super();
    this.name = "RedMushroom";
  }

  public void applyTo(Players player) {
    int currHp = player.getHp();
    int maxHp = player.getMaxHp();
    player.setHp(currHp + (int) (maxHp * 0.1));
  }
}
