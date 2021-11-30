package com.example.aventurasdemarcoyluis.model.characters.enemy;

import com.example.aventurasdemarcoyluis.model.characters.enemy.abstract_classes.AbstractEnemy;
import com.example.aventurasdemarcoyluis.model.characters.player.interfaces.IPlayers;
import com.example.aventurasdemarcoyluis.model.characters.player.interfaces.attackable.IAttackableByBoo;

/** Class that represents the character Boo */
public class Boo extends AbstractEnemy {

  /**
   * Create a Boo
   *
   * @param LVL the lvl of Boo
   * @param ATK the atk of Boo
   * @param DEF the def of Boo
   * @param HP the hp of Boo
   * @param MaxHP the maxHp of Boo
   */
  public Boo(int LVL, int ATK, int DEF, int HP, int MaxHP) {
    super(LVL, ATK, DEF, HP, MaxHP);
    this.attackableByLuis = false;
  }

  /**
   * Attacks a player by calling the method attackedByEnemy on the player
   *
   * @param aPlayer the player (that is attackable by boo) to attack
   */
  public void attackPlayer(IAttackableByBoo aPlayer) {
    aPlayer.attackedByEnemy(this);
  }

  /**
   * Receives the damage from a hammer attack made by a player, because Boo dodges the attacks made
   * with hammer this does nothing
   *
   * @param aPlayer the player attacking
   */
  @Override
  public void hammerAttackedByPlayer(IPlayers aPlayer) {}

  /** Returns if this is attackable by Luis */
  @Override
  public boolean attackableByLuis() {
    return attackableByLuis;
  }
}
