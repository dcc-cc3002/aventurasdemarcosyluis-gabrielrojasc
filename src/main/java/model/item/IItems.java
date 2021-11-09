package model.item;

import model.characters.player.interfaces.IPlayers;

/** Interface that represents the model.item */
public interface IItems {

  /** Returns the name */
  String getName();

  /**
   * Applies the model.item to a player
   *
   * @param player the player to apply the model.item
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
