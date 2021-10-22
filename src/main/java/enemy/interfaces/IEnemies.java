package enemy.interfaces;

import player.interfaces.IPlayers;

/** Interface that represetns the enemy */
public interface IEnemies {

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

  void receiveDmg(int dmg);

  int getDmg(IPlayers aPlayer);
}
