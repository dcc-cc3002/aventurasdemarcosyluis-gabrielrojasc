package model.characters.enemy.abstract_classes;

import model.characters.character.abstract_classes.AbstractCharacter;
import model.characters.enemy.interfaces.IEnemies;
import model.characters.player.interfaces.IPlayers;

/** Class that represents an enemy */
public abstract class AbstractEnemy extends AbstractCharacter implements IEnemies {

  protected boolean attackableByLuis;

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
    super(LVL, ATK, DEF, HP, MaxHP);
  }

  /**
   * Calculates the dmg to be made to a player adn returns it
   *
   * @param aPlayer the player to calculate the dmg
   * @return the dmg to be made to the player
   */
  @Override
  public int getDmg(IPlayers aPlayer) {
    float dmg = (float) 0.75 * this.getAtk() * ((float) this.getLvl() / (float) aPlayer.getDef());
    return Math.round(dmg);
  }

  /**
   * Receives the damage from a jump attack made by a player
   *
   * @param aPlayer the player attacking
   */
  @Override
  public void jumpAttackedByPlayer(IPlayers aPlayer) {
    this.receiveDmg(aPlayer.getJumpDmg(this));
  }

  /**
   * Receives the damage from a hammer attack made by a player
   *
   * @param aPlayer the player attacking
   */
  @Override
  public void hammerAttackedByPlayer(IPlayers aPlayer) {
    this.receiveDmg(aPlayer.getHammerDmg(this));
  }

  /** Returns if this is attackable by Luis */
  public abstract boolean attackableByLuis();
}
