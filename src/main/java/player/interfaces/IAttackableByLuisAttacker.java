package player.interfaces;

import enemy.interfaces.IAttackableByLuis;

public interface IAttackableByLuisAttacker {
  void jumpAttackEnemy(IAttackableByLuis anEnemy);

  void hammerAttackEnemy(IAttackableByLuis anEnemy);
}
