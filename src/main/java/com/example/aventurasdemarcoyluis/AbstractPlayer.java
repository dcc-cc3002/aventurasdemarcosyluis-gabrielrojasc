package com.example.aventurasdemarcoyluis;

import java.util.ArrayList;

public abstract class AbstractPlayer implements IPlayers {

  protected int lvl;
  protected int atk;
  protected int def;
  protected int hp;
  protected int fp;
  protected int maxHp;
  protected int maxFp;
  protected ArrayList<String> itemList = new ArrayList<>();

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

  public int getLvl() {
    return lvl;
  }

  public void setLvl(int lvl) {
    this.lvl = lvl;
  }

  public int getAtk() {
    if (this.isKO()) {
      return 0;
    }
    return atk;
  }

  public void setAtk(int atk) {
    this.atk = atk;
  }

  public int getDef() {
    return def;
  }

  public void setDef(int def) {
    this.def = def;
  }

  public int getHp() {
    return hp;
  }

  public void setHp(int hp) {
    if (hp > maxHp || hp < 0) {
      throw new IllegalArgumentException(
          hp + " is not a valid hp. hp must be between 0 and " + maxHp);
    }
    this.hp = hp;
  }

  public int getFp() {
    return fp;
  }

  public void setFp(int fp) {
    if (fp > maxFp || fp < 0) {
      throw new IllegalArgumentException(
          fp + " is not a valid fp. hp must be between 0 and " + maxFp);
    }
    this.fp = fp;
  }

  public int getMaxHp() {
    return maxHp;
  }

  public int getMaxFp() {
    return maxFp;
  }

  public String getItems() {
    return itemList.toString();
  }

  public boolean isKO() {
    return hp == 0;
  }

  public void addItem(IItems item) {
    itemList.add(item.getName());
  }

  public void useItem(IItems item) {
    if (itemList.contains(item.getName())) {
      item.applyTo(this);
      itemList.remove(item.getName());
    }
  }
}
