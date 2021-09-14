package com.example.aventurasdemarcoyluis;

public class RedMushroom implements Items {

  private String name="RedMushroom";

  public RedMushroom() {}

  public String getName() {
    return null;
  }

  public void applyTo(Players player) {
    int currHp = player.getHp();
    int maxHp = player.getMaxHp();

    player.setHp(currHp + (int) (maxHp * 0.1));
  }
}
