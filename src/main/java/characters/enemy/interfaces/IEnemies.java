package characters.enemy.interfaces;

import characters.character.interfaces.ICharacters;
import characters.player.interfaces.IPlayers;

/** Interface that represents the enemy */
public interface IEnemies extends ICharacters {
  int getDmg(IPlayers aPlayer);
}
