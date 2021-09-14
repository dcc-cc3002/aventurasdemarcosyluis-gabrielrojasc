package com.example.aventurasdemarcoyluis;

public abstract class AbstractPlayer implements Players {

  protected int lvl;
  protected int atk;
  protected int def;
  protected int hp;
  protected int fp;
  protected int maxHp;

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
}
