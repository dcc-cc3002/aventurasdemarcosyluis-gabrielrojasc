package characters.enemy.interfaces.attackable;

import characters.player.interfaces.IPlayers;

public interface IAttackableByPlayer {
  void jumpAttackedByPlayer(IPlayers aPlayer);

  void hammerAttackedByPlayer(IPlayers aPlayer);
}
