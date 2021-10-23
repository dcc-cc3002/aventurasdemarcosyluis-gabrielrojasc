package characters.player.interfaces.attacker;

import characters.enemy.interfaces.attackable.IAttackableByLuis;

public interface IAttackableByLuisAttacker {
  void jumpAttackEnemy(IAttackableByLuis anEnemy);

  void hammerAttackEnemy(IAttackableByLuis anEnemy);
}
