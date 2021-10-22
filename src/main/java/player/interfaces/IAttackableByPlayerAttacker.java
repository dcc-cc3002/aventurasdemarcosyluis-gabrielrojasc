package player.interfaces;

import enemy.interfaces.IAttackableByPlayer;

public interface IAttackableByPlayerAttacker {
  void jumpAttackEnemy(IAttackableByPlayer anEnemy);

  void hammerAttackEnemy(IAttackableByPlayer anEnemy);
}
