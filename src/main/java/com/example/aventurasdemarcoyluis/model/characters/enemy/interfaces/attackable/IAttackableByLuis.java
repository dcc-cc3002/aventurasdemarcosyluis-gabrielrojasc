package com.example.aventurasdemarcoyluis.model.characters.enemy.interfaces.attackable;

import com.example.aventurasdemarcoyluis.model.characters.enemy.interfaces.IEnemies;
import com.example.aventurasdemarcoyluis.model.characters.player.interfaces.IPlayers;

/** Interface that represents an enemy attackable by Luis */
public interface IAttackableByLuis extends IEnemies {

  /**
   * Receives the damage from a jump attack made by a player
   *
   * @param aPlayer the player attacking
   */
  void jumpAttackedByPlayer(IPlayers aPlayer);

  /**
   * Receives the damage from a hammer attack made by a player
   *
   * @param aPlayer the player attacking
   */
  void hammerAttackedByPlayer(IPlayers aPlayer);
}
