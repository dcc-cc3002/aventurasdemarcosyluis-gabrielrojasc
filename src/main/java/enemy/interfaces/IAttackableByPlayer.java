package enemy.interfaces;

import player.interfaces.IPlayers;

public interface IAttackableByPlayer {
  void jumpAttackedByPlayer(IPlayers aPlayer);

  void hammerAttackedByPlayer(IPlayers aPlayer);
}
