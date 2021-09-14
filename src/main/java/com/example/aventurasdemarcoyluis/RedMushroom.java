package com.example.aventurasdemarcoyluis;

public class RedMushroom implements Items {
  public RedMushroom() {}

  public void applyTo(Players player) {
    int currHp = player.getHp();
    int maxHp = player.getMaxHp();

    player.setHp(currHp + (int) (maxHp * 0.1));
  }
}
