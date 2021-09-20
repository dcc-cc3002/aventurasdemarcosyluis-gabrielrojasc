package com.example.aventurasdemarcoyluis;

public abstract class AbstractEnemy implements IEnemies {

  protected int lvl;
  protected int atk;
  protected int def;
  protected int hp;

  public AbstractEnemy(int LVL, int ATK, int DEF, int HP) {
    if (HP < 0) {
      throw new IllegalArgumentException(HP + " is not a valid hp.");
    }
    this.lvl = LVL;
    this.atk = ATK;
    this.def = DEF;
    this.hp = HP;
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
    if (hp < 0) {
      throw new IllegalArgumentException(hp + " is not a valid hp. hp must be greater than 0");
    }
    this.hp = hp;
  }

  public boolean isKO() {
    return hp == 0;
  }
}
