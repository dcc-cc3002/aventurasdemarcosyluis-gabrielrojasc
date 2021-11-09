package model.characters.player.interfaces.attackable;

import model.characters.enemy.interfaces.IEnemies;
import model.characters.player.interfaces.IPlayers;

/** Interface that represents a player that is attackable by boo */
public interface IAttackableByBoo extends IPlayers {
  /**
   * Receives the damage dealt by an enemy
   *
   * @param anEnemy the enemy dealing the damage
   */
  void attackedByEnemy(IEnemies anEnemy);
}
