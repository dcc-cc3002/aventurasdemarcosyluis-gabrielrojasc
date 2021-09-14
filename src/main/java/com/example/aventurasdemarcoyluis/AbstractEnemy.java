package com.example.aventurasdemarcoyluis;

public abstract class AbstractEnemy implements Characters {

  protected int lvl;
  protected int atk;
  protected int def;
  protected int hp;
  protected int maxHp;

  public AbstractEnemy(int LVL, int ATK, int DEF, int HP, int MAXHP) {
    this.lvl = LVL;
    this.atk = ATK;
    this.def = DEF;
    this.hp = HP;
    this.maxHp = MAXHP;
  }
}
