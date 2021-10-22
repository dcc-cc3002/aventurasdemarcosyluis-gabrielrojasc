package item;

import player.interfaces.IPlayers;

/** Interface that represents the item */
public interface IItems {

  /** Returns the name */
  String getName();

  /**
   * Applies the item to a player
   *
   * @param player the player to apply the item
   */
  void applyTo(IPlayers player);

  /**
   * equals method override
   *
   * @param o the object to compare to
   * @return if o equals itself
   */
  @Override
  boolean equals(Object o);
}
