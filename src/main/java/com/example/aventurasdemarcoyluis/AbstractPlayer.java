package com.example.aventurasdemarcoyluis;

import java.util.ArrayList;

/** Class that represents a player */
public abstract class AbstractPlayer implements IPlayers {

  protected int lvl;
  protected int atk;
  protected int def;
  protected int hp;
  protected int fp;
  protected int maxHp;
  protected int maxFp;
  protected ArrayList<IItems> itemList = new ArrayList<>();

  /**
   * Create a player
   *
   * @param LVL the lvl of the player
   * @param ATK the atk of the player
   * @param DEF the def of the player
   * @param HP the hp of the player
   * @throws IllegalArgumentException if HP is less than 0 or greater than MaxHP
   * @param FP the fp of the player
   * @throws IllegalArgumentException if FP is less than 0 or greater than MaxFP
   * @param MaxHP the maxHp of the player
   * @throws IllegalArgumentException if MaxHP is less than 0
   * @param MaxFP the maxFp of the player
   * @throws IllegalArgumentException if MaxFP is less than 0
   */
  public AbstractPlayer(int LVL, int ATK, int DEF, int HP, int FP, int MaxHP, int MaxFP) {
    if (MaxHP < 0) {
      throw new IllegalArgumentException(
          MaxHP + " is not a valid maxHp. maxHp must be greater than 0.");
    }
    if (HP < 0 || HP > MaxHP) {
      throw new IllegalArgumentException(
          HP + " is not a valid hp. hp must be between 0 and " + MaxHP);
    }
    if (MaxFP < 0) {
      throw new IllegalArgumentException(
          MaxHP + " is not a valid maxFp. maxFp must be greater than 0.");
    }
    if (FP < 0 || FP > MaxFP) {
      throw new IllegalArgumentException(
          HP + " is not a valid fp. fp must be between 0 and " + MaxFP);
    }
    this.lvl = LVL;
    this.atk = ATK;
    this.def = DEF;
    this.hp = HP;
    this.fp = FP;
    this.maxHp = MaxHP;
    this.maxFp = MaxFP;
  }

  /** Returns the lvl */
  @Override
  public int getLvl() {
    return lvl;
  }

  /**
   * Sets the lvl
   *
   * @param lvl the lvl to set
   */
  @Override
  public void setLvl(int lvl) {
    this.lvl = lvl;
  }

  /** Returns the atk */
  @Override
  public int getAtk() {
    if (this.isKO()) {
      return 0;
    }
    return atk;
  }

  /**
   * Sets the atk
   *
   * @param atk the atk to set
   */
  @Override
  public void setAtk(int atk) {
    this.atk = atk;
  }

  /** Returns the def */
  @Override
  public int getDef() {
    return def;
  }

  /**
   * Sets the def
   *
   * @param def the def to set
   */
  @Override
  public void setDef(int def) {
    this.def = def;
  }

  /** Returns the hp */
  @Override
  public int getHp() {
    return hp;
  }

  /**
   * Sets the hp
   *
   * @param hp the hp to set
   * @throws IllegalArgumentException if hp is less than 0 or greater than maxHp
   */
  @Override
  public void setHp(int hp) {
    if (hp > maxHp || hp < 0) {
      throw new IllegalArgumentException(
          hp + " is not a valid hp. hp must be between 0 and " + maxHp);
    }
    this.hp = hp;
  }

  /** Returns the fp */
  @Override
  public int getFp() {
    return fp;
  }

  /**
   * Sets the fp
   *
   * @param fp the fp to set
   * @throws IllegalArgumentException if fp is less than 0 or greater than maxFp
   */
  @Override
  public void setFp(int fp) {
    if (fp > maxFp || fp < 0) {
      throw new IllegalArgumentException(
          fp + " is not a valid fp. hp must be between 0 and " + maxFp);
    }
    this.fp = fp;
  }

  /** Returns the maxHp */
  @Override
  public int getMaxHp() {
    return maxHp;
  }

  /** Returns the maxFp */
  @Override
  public int getMaxFp() {
    return maxFp;
  }

  /** Returns the items that the player has */
  @Override
  public ArrayList getItems() {
    return itemList;
  }

  /** Returns if the enemy is knocked out (hp=0) */
  @Override
  public boolean isKO() {
    return hp == 0;
  }

  /**
   * Adds an item to the itemList
   *
   * @param item the item to add to the itemList
   */
  @Override
  public void addItem(IItems item) {
    itemList.add(item);
  }

  /**
   * Uses an item if the item is on the itemList
   *
   * @param item the item to be used
   */
  @Override
  public void useItem(IItems item) {
    if (itemList.contains(item)) {
      item.applyTo(this);
      itemList.remove(item);
    }
  }
}
