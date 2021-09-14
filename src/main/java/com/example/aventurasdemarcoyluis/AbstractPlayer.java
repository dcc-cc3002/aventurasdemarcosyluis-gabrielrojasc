package com.example.aventurasdemarcoyluis;

import java.util.ArrayList;

public abstract class AbstractPlayer implements Players {

  protected int lvl;
  protected int atk;
  protected int def;
  protected int hp;
  protected int fp;
  protected int maxHp;
  protected ArrayList<String> itemList = new ArrayList<>();

  public AbstractPlayer(int LVL, int ATK, int DEF, int HP, int FP, int MaxHP) {
    this.lvl = LVL;
    this.atk = ATK;
    this.def = DEF;
    this.hp = HP;
    this.fp = FP;
    this.maxHp = MaxHP;
  }

  public int getLvl() {
    return lvl;
  }

  public void setLvl(int lvl) {
    this.lvl = lvl;
  }

  public int getAtk() {
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
    this.hp = hp;
  }

  public int getFp() {
    return fp;
  }

  public void setFp(int fp) {
    this.fp = fp;
  }

  public int getMaxHp() {
    return maxHp;
  }

  public String getItems() {
    return itemList.toString();
  }

  public void addItem(Items item) {
    itemList.add(item.getName());
  }

  public void useItem(Items item) {
    if (itemList.contains(item.getName())) {
      item.applyTo(this);
      itemList.remove(item.getName());
    }
  }
}
