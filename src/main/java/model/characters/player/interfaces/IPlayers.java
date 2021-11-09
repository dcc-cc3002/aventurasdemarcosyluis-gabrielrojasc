package model.characters.player.interfaces;

import model.characters.character.interfaces.ICharacters;
import model.characters.enemy.interfaces.IEnemies;
import model.characters.player.ItemVault;
import model.item.IItems;

/** Interface that represents the players */
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
   * Uses an model.item if the model.item is on the itemList
   *
   * @param item the model.item to be used
   */
  void useItem(IItems item, ItemVault vault);

  /**
   * Sets the random seed for the random number rand
   *
   * @param seed the seed to set
   */
  void setRandSeed(int seed);

  /**
   * Return the damage made by a jump attack from this
   *
   * @param anEnemy the enemy being damaged by a jump attack
   * @return the damage to be dealt by a jump attack from this
   */
  int getJumpDmg(IEnemies anEnemy);

  /**
   * Return the damage made by a hammer attack from this
   *
   * @param anEnemy the enemy being damaged by a hammer attack
   * @return the damage to be dealt by a hammer attack from this
   */
  int getHammerDmg(IEnemies anEnemy);

  /**
   * Receives the damage dealt by an enemy
   *
   * @param anEnemy the enemy dealing the damage
   */
  void attackedByEnemy(IEnemies anEnemy);

  boolean attackableByBoo();
}
