package com.example.aventurasdemarcoyluis;

/** Class that represents the item Honey Syrup */
public class HoneySyrup extends AbstractItem {

  /** Create a Honey Syrup */
  public HoneySyrup() {
    super("HoneySyrup");
  }

  /**
   * Applies the item to a player
   *
   * @param player the player to apply the item
   */
  @Override
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
