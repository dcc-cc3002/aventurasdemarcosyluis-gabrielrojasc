package characters.enemy;

import characters.enemy.interfaces.attackable.IAttackableByPlayer;
import characters.enemy.interfaces.attacker.IAttackableByGoombaAttacker;
import characters.player.interfaces.IPlayers;
import characters.player.interfaces.attackable.IAttackableByGoomba;

/** Class that represents the character Goomba */
public class Goomba extends AbstractEnemy
    implements IAttackableByPlayer, IAttackableByGoombaAttacker {

  /**
   * Create a Goomba
   *
   * @param LVL the lvl of Goomba
   * @param ATK the atk of Goomba
   * @param DEF the def of Goomba
   * @param HP the hp of Goomba
   * @param MaxHP the maxHp of Goomba
   */
  public Goomba(int LVL, int ATK, int DEF, int HP, int MaxHP) {
    super(LVL, ATK, DEF, HP, MaxHP);
  }

  @Override
  public void attackPlayer(IAttackableByGoomba aPlayer) {
    aPlayer.attackedByGoomba(this);
  }

  @Override
  public void jumpAttackedByPlayer(IPlayers aPlayer) {
    this.receiveDmg(aPlayer.getJumpDmg(this));
  }

  @Override
  public void hammerAttackedByPlayer(IPlayers aPlayer) {
    this.receiveDmg(aPlayer.getHammerDmg(this));
  }
}
