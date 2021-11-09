package model.characters.enemy.interfaces.attackable;

import model.characters.enemy.interfaces.IEnemies;
import model.characters.player.interfaces.IPlayers;

/** Interface that represents an enemy attackable by Luis */
public interface IAttackableByLuis extends IEnemies {
  public void jumpAttackedByPlayer(IPlayers aPlayer);

  public void hammerAttackedByPlayer(IPlayers aPlayer);
}
