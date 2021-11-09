package model.item;

import model.characters.player.interfaces.IPlayers;

/** Class that represetn the model.item Red Mushroom */
public class RedMushroom extends AbstractItem {

  /** Create a Red Mushroom */
  public RedMushroom() {
    super("RedMushroom");
  }

  /**
   * Applies the model.item to a player
   *
   * @param player the player to apply the model.item
   */
  @Override
  public void applyTo(IPlayers player) {
    int currHp = player.getHp();
    int maxHp = player.getMaxHp();
    player.setHp(currHp + (int) (maxHp * 0.1));
  }
}
