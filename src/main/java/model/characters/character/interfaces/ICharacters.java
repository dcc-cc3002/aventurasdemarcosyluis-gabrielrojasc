package model.characters.character.interfaces;

/** Interface that represents the character */
public interface ICharacters {

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

  /** Returns the maxHp */
  int getMaxHp();

  /** Returns if the enemy is knocked out (hp=0) */
  boolean isKO();

  /**
   * Set the hp to (currentHp - dmg)
   *
   * @param dmg
   */
  void receiveDmg(int dmg);

  /**
   * Levels up the Character, meaning it adds +1 to lvl, +15% of maxHp to hp, +15% to atk and +15%
   * to def
   */
  void levelUp();
}
