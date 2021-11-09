package model.characters.enemy.interfaces;

import model.characters.character.interfaces.ICharacters;
import model.characters.player.interfaces.IPlayers;

/** Interface that represents the enemy */
public interface IEnemies extends ICharacters {
  /**
   * Calculates the dmg to be made to a player adn returns it
   *
   * @param aPlayer the player to calculate the dmg
   * @return the dmg to be made to the player
   */
  int getDmg(IPlayers aPlayer);

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

  boolean attackableByLuis();
}
