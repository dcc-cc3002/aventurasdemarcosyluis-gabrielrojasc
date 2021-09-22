package com.example.aventurasdemarcoyluis;

public interface IPlayers {

  /**
   * getLvl
   *
   * @return the lvl of the player
   */
  int getLvl();

  /**
   * setLvl
   *
   * @param lvl the value to set the player lvl to
   */
  void setLvl(int lvl);

  /**
   * getAtk
   *
   * @return the atk of the player
   */
  int getAtk();

  /**
   * setAtk
   *
   * @param atk the value to set the player atk to
   */
  void setAtk(int atk);

  /**
   * getDef
   *
   * @return the def of the player
   */
  int getDef();

  /**
   * setDef
   *
   * @param def the value to set the player def to
   */
  void setDef(int def);

  /**
   * getHp
   *
   * @return the hp of the player
   */
  int getHp();

  /**
   * setHp
   *
   * @param hp the value to set the player hp to
   */
  void setHp(int hp);

  /**
   * getFp
   *
   * @return the fp of the player
   */
  int getFp();

  /**
   * setFp
   *
   * @param fp the value to set the player fp to
   */
  void setFp(int fp);

  /**
   * getMaxHp
   *
   * @return the maxHp of the player
   */
  int getMaxHp();

  /**
   * getItems
   *
   * @return the items that the player has
   */
  String getItems();

  /**
   * isKO
   *
   * @return if the enemy is knocked out or not
   */
  boolean isKO();

  /**
   * addItem
   *
   * @param item the item to add to the itemList
   */
  void addItem(IItems item);

  /**
   * useItem
   *
   * @param item the item to be used by the player
   */
  void useItem(IItems item);
}
