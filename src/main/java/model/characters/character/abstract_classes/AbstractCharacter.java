package model.characters.character.abstract_classes;

import model.characters.character.interfaces.ICharacters;

/** The class that represents a character */
public abstract class AbstractCharacter implements ICharacters {

  protected int lvl;
  protected int atk;
  protected int def;
  protected int hp;
  protected int maxHp;

  /**
   * Create a character
   *
   * @param LVL the lvl of the character
   * @param ATK the atk of the character
   * @param DEF the def of the character
   * @param HP the hp of the character
   * @param MaxHP the maxHp of the character
   * @throws IllegalArgumentException if HP is less than 0 or greater than MaxHP
   * @param MaxHP the maxHp of the enemy
   * @throws IllegalArgumentException if MaxHp is less than 0
   */
  public AbstractCharacter(int LVL, int ATK, int DEF, int HP, int MaxHP) {
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

  /** Returns the maxHp */
  @Override
  public int getMaxHp() {
    return maxHp;
  }

  /** Returns if the enemy is knocked out (hp=0) */
  @Override
  public boolean isKO() {
    return hp == 0;
  }

  /**
   * Set the hp to (currentHp - dmg)
   *
   * @param dmg
   */
  @Override
  public void receiveDmg(int dmg) {
    int newHp = this.getHp() - dmg;
    this.setHp(Math.max(0, newHp));
  }

  /**
   * Levels up the Character, meaning it adds +1 to lvl, +15% of maxHp to hp, +15% to atk and +15%
   * to def
   */
  @Override
  public void levelUp() {
    this.setLvl(this.getLvl() + 1);
    int newHp = this.getHp() + Math.round((float) 0.15 * this.getMaxHp());
    this.setHp(Math.min(this.getMaxHp(), newHp));
    this.setAtk(this.getAtk() + Math.round((float) 0.15 * this.getAtk()));
    this.setDef(this.getDef() + Math.round((float) 0.15 * this.getDef()));
  }
}
