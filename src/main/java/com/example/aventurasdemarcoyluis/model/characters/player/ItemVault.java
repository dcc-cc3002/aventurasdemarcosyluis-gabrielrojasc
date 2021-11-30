package com.example.aventurasdemarcoyluis.model.characters.player;

import com.example.aventurasdemarcoyluis.model.characters.player.interfaces.IPlayers;
import com.example.aventurasdemarcoyluis.model.item.IItems;
import java.util.ArrayList;

/** The class that represents an item vault */
public class ItemVault {
  private final ArrayList<IItems> itemList = new ArrayList<>();

  /** Create an item vault */
  public ItemVault() {}

  /** Returns the items that are currently on the vault */
  public ArrayList getItems() {
    return itemList;
  }

  /**
   * Adds an item to the vault
   *
   * @param item the item to add
   */
  public void addItem(IItems item) {
    itemList.add(item);
  }

  /**
   * Applies an item to a player if the item is on the vault
   *
   * @param item the item to apply
   * @param player the player to apply it to
   */
  public void useItem(IItems item, IPlayers player) {
    if (itemList.contains(item)) {
      item.applyTo(player);
      itemList.remove(item);
    }
  }
}
