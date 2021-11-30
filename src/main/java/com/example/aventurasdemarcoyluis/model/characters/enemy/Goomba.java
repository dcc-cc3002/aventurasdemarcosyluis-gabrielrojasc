package com.example.aventurasdemarcoyluis.model.characters.enemy;

import com.example.aventurasdemarcoyluis.model.characters.enemy.abstract_classes.AbstractEnemy;
import com.example.aventurasdemarcoyluis.model.characters.enemy.interfaces.attackable.IAttackableByLuis;
import com.example.aventurasdemarcoyluis.model.characters.player.interfaces.IPlayers;

/** Class that represents the character Goomba */
public class Goomba extends AbstractEnemy implements IAttackableByLuis {

  /**
   * Create a Goomba
   *
   * @param LVL the lvl of Goomba
   * @param ATK the atk of Goomba
   * @param DEF the def of Goomba
   * @param HP the hp of Goomba
   * @param MaxHP the maxHp of Goomba
   */
  public Goomba(int LVL, int ATK, int DEF, int HP, int MaxHP) {
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

  /** Returns if this is attackable by Luis */
  @Override
  public boolean attackableByLuis() {
    return true;
  }
}
