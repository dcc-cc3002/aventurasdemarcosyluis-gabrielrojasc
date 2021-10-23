package characters.player.interfaces.attacker;

import characters.enemy.interfaces.attackable.IAttackableByPlayer;

public interface IAttackableByPlayerAttacker {
  void jumpAttackEnemy(IAttackableByPlayer anEnemy);

  void hammerAttackEnemy(IAttackableByPlayer anEnemy);
}
