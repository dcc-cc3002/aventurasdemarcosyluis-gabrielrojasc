package model.characters.enemy;

import model.characters.enemy.abstract_classes.AbstractEnemy;
import model.characters.enemy.interfaces.attackable.IAttackableByLuis;
import model.characters.player.interfaces.IPlayers;

/** Class that represents the character Spiny */
public class Spiny extends AbstractEnemy implements IAttackableByLuis {

  /**
   * Create a Spiny
   *
   * @param LVL the lvl of Spiny
   * @param ATK the atk of Spiny
   * @param DEF the def of Spiny
   * @param HP the hp of Spiny
   * @param MaxHP the maxHp of Spiny
   */
  public Spiny(int LVL, int ATK, int DEF, int HP, int MaxHP) {
    super(LVL, ATK, DEF, HP, MaxHP);
    this.attackableByLuis = true;
  }

  /**
   * Attacks a player by calling the method attackedByEnemy on the player
   *
   * @param aPlayer the player to attack
   */
  public void attackPlayer(IPlayers aPlayer) {
    aPlayer.attackedByEnemy(this);
  }

  /**
   * Receives the damage from a jump attack made by a player, because spiny does damage when
   * attacked by jump the newHp of the player is calculated and assigned.
   *
   * @param aPlayer the player attacking
   */
  @Override
  public void jumpAttackedByPlayer(IPlayers aPlayer) {
    int newHp = aPlayer.getHp() - Math.round((float) 0.05 * aPlayer.getHp());
    aPlayer.setHp(Math.max(0, newHp));
  }

  @Override
  public boolean attackableByLuis() {
    return true;
  }
}
