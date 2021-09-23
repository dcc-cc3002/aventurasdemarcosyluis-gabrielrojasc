package com.example.aventurasdemarcoyluis;

import java.util.Objects;

/** Class that represents an item */
public abstract class AbstractItem implements IItems {

  protected String name;

  /**
   * Creates an item
   *
   * @param NAME the name of the item
   */
  public AbstractItem(String NAME) {
    this.name = NAME;
  }

  /** Returns the name */
  public String getName() {
    return name;
  }

  /**
   * Applies the item to a player
   *
   * @param player the player to apply the item
   */
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
