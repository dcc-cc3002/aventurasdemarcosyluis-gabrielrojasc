package enemy;

import player.IPlayers;

/** Class that represents an enemy */
public abstract class AbstractEnemy implements IEnemies {

  protected int lvl;
  protected int atk;
  protected int def;
  protected int hp;
  protected int maxHp;

  /**
   * Create an enemy
   *
   * @param LVL the lvl of the enemy
   * @param ATK the atk of the enemy
   * @param DEF the def of the enemy
   * @param HP the hp of the enemy
   * @throws IllegalArgumentException if HP is less than 0 or greater than MaxHP
   * @param MaxHP the maxHp of the enemy
   * @throws IllegalArgumentException if MaxHp is less than 0
   */
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
    if (hp < 0 || hp > maxHp) {
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

  @Override
  public void receiveDmg(int dmg) {
    this.setHp(Math.max(0, dmg));
  }

  @Override
  public int getDmg(IPlayers aPlayer) {
    float dmg = (float) 0.75 * this.getAtk() * ((float) this.getLvl() / (float) aPlayer.getDef());
    return Math.round(dmg);
  }

  @Override
  public void jumpAttackedByPlayer(IPlayers aPlayer) {
    this.receiveDmg(aPlayer.getJumpDmg(this));
  }

  @Override
  public void hammerAttackedByPlayer(IPlayers aPlayer) {
    this.receiveDmg(aPlayer.getHammerDmg(this));
  }
}
