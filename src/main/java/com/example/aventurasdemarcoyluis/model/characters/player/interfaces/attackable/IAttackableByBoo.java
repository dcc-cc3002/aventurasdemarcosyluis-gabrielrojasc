package com.example.aventurasdemarcoyluis.model.characters.player.interfaces.attackable;

import com.example.aventurasdemarcoyluis.model.characters.enemy.interfaces.IEnemies;
import com.example.aventurasdemarcoyluis.model.characters.player.interfaces.IPlayers;

/** Interface that represents a player that is attackable by boo */
public interface IAttackableByBoo extends IPlayers {
  /**
   * Receives the damage dealt by an enemy
   *
   * @param anEnemy the enemy dealing the damage
   */
  void attackedByEnemy(IEnemies anEnemy);
}
