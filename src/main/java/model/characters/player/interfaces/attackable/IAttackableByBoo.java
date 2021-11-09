package model.characters.player.interfaces.attackable;

import model.characters.enemy.interfaces.IEnemies;
import model.characters.player.interfaces.IPlayers;

/** Interface that represents a player that is attackable by boo */
public interface IAttackableByBoo extends IPlayers {
  void attackedByEnemy(IEnemies anEnemy);
}
