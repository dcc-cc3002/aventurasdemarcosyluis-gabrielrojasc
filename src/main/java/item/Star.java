package item;

import player.interfaces.IPlayers;

/** Class that represents the item Star */
public class Star extends AbstractItem {

  /** Create a Star */
  public Star() {
    super("Star");
  }

  /**
   * Applies the item to a player
   *
   * @param player the player to apply the item
   */
  @Override
  public void applyTo(IPlayers player) {
    int currHp = player.getHp();
    long stopTime = System.currentTimeMillis() + 6000;
    while (System.currentTimeMillis() < stopTime) {
      player.setHp(currHp);
    }
  }
}
