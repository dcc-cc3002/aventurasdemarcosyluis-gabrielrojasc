package com.example.aventurasdemarcoyluis;

public class HoneySyrup extends abstractItem {

  public HoneySyrup() {
    super();
    this.name = "HoneySyrup";
  }

  public void applyTo(IPlayers player) {
    int currFp = player.getFp();
    int maxFp = player.getMaxFp();
    if (currFp + 3 > maxFp) {
      player.setFp(maxFp);
    } else {
      player.setFp(currFp + 3);
    }
  }
}
