package com.example.aventurasdemarcoyluis;

public interface IEnemies {

  /**
   * getLvl
   *
   * @return the lvl of the enemy
   */
  int getLvl();

  /**
   * setLvl
   *
   * @param lvl the value to set the enemy lvl to
   */
  void setLvl(int lvl);

  /**
   * getAtk
   *
   * @return the atk of the enemy
   */
  int getAtk();

  /**
   * setAtk
   *
   * @param atk the value to set the enemy atk to
   */
  void setAtk(int atk);

  /**
   * getDef
   *
   * @return the def of the enemy
   */
  int getDef();

  /**
   * setDef
   *
   * @param def the value to set the enemy def to
   */
  void setDef(int def);

  /**
   * getHp
   *
   * @return the hp of the enemy
   */
  int getHp();

  /**
   * setHp
   *
   * @param hp the value to set the enemy hp to
   */
  void setHp(int hp);

  /**
   * getMaxHp
   *
   * @return the maxHp of the enemy
   */
  int getMaxHp();

  /**
   * isKO
   *
   * @return if the enemy is knocked out or not
   */
  boolean isKO();
}
