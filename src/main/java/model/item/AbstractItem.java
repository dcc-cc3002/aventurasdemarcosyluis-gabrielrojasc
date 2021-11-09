package model.item;

import java.util.Objects;
import model.characters.player.interfaces.IPlayers;

/** Class that represents an model.item */
public abstract class AbstractItem implements IItems {

  protected String name;

  /**
   * Create an model.item
   *
   * @param NAME the name of the model.item
   */
  public AbstractItem(String NAME) {
    this.name = NAME;
  }

  /** Returns the name */
  @Override
  public String getName() {
    return name;
  }

  /**
   * Applies the model.item to a player
   *
   * @param player the player to apply the model.item
   */
  @Override
  public abstract void applyTo(IPlayers player);

  /**
   * equals method override
   *
   * @param o the object to compare to
   * @return if o equals itself
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof IItems item)) return false;
    return Objects.equals(this.getName(), item.getName());
  }
}
