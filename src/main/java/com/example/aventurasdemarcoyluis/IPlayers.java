package com.example.aventurasdemarcoyluis;

import java.util.ArrayList;

/** Interfaces that represents the players */
public interface IPlayers {

  /** Returns the lvl */
  int getLvl();

  /**
   * Sets the lvl
   *
   * @param lvl the lvl to set
   */
  void setLvl(int lvl);

  /** Returns the atk */
  int getAtk();

  /**
   * Sets the atk
   *
   * @param atk the atk to set
   */
  void setAtk(int atk);

  /** Returns the def */
  int getDef();

  /**
   * Sets the def
   *
   * @param def the def to set
   */
  void setDef(int def);

  /** Returns the hp */
  int getHp();

  /**
   * Sets the hp
   *
   * @param hp the hp to set
   */
  void setHp(int hp);

  /** Returns the fp */
  int getFp();

  /**
   * Sets the fp
   *
   * @param fp the fp to set
   */
  void setFp(int fp);

  /** Returns the maxHp */
  int getMaxHp();

  /** Returns the maxFp */
  int getMaxFp();

  /** Returns the items that the player has */
  ArrayList getItems();

  /** Returns if the enemy is knocked out (hp=0) */
  boolean isKO();

  /**
   * Adds an item to the itemList
   *
   * @param item the item to add to the itemList
   */
  void addItem(IItems item);

  /**
   * Uses an item if the item is on the itemList
   *
   * @param item the item to be used
   */
  void useItem(IItems item);
}
