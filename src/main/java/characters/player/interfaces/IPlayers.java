package characters.player.interfaces;

import characters.character.interfaces.ICharacters;
import characters.enemy.interfaces.IEnemies;
import characters.player.ItemVault;
import item.IItems;

/** Interfaces that represents the players */
public interface IPlayers extends ICharacters {

  /** Returns the fp */
  int getFp();

  /**
   * Sets the fp
   *
   * @param fp the fp to set
   */
  void setFp(int fp);

  /** Returns the maxFp */
  int getMaxFp();

  /**
   * Uses an item if the item is on the itemList
   *
   * @param item the item to be used
   */
  void useItem(IItems item, ItemVault vault);

  void setRandSeed(int seed);

  int getJumpDmg(IEnemies anEnemy);

  int getHammerDmg(IEnemies anEnemy);
}
