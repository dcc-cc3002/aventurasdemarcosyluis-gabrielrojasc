package com.example.aventurasdemarcoyluis;

public interface IItems {

  /**
   * getName
   *
   * @return the name of the item
   */
  String getName();

  /**
   * applyTo
   *
   * @param player the player to apply the item to
   */
  void applyTo(IPlayers player);

  /**
   * equals method override
   *
   * @param o the object to compare to
   * @return if o equals this
   */
  @Override
  boolean equals(Object o);
}
