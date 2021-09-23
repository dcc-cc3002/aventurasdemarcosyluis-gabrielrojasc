package com.example.aventurasdemarcoyluis;

public abstract class AbstractEnemy implements IEnemies {

  protected int lvl;
  protected int atk;
  protected int def;
  protected int hp;
  protected int maxHp;

  public AbstractEnemy(int LVL, int ATK, int DEF, int HP, int MaxHP) {
    if (MaxHP < 0) {
      throw new IllegalArgumentException(
          MaxHP + " is not a valid maxHp. maxHp must be greater than 0.");
    }
    if (HP < 0 || HP > MaxHP) {
      throw new IllegalArgumentException(
          HP + " is not a valid hp. hp must be between 0 and " + maxHp);
    }
    this.lvl = LVL;
    this.atk = ATK;
    this.def = DEF;
    this.hp = HP;
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
    if (hp < 0 || hp > maxHp) {
      throw new IllegalArgumentException(
          hp + " is not a valid hp. hp must be between 0 and " + maxHp);
    }
    this.hp = hp;
  }

  public int getMaxHp() {
    return maxHp;
  }

  public boolean isKO() {
    return hp == 0;
  }
}
