package com.example.aventurasdemarcoyluis;

public class RedMushroom implements Items {
  public RedMushroom() {}

  public void applyTo(Characters character) {
    int currHp = character.getHp();
    int maxHp = character.getMaxHp();

    character.setHp(currHp + (int) ((double) maxHp * 0.1));
  }
}
