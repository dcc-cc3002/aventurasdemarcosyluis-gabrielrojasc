package enemy;

import enemy.interfaces.IAttackableByPlayer;
import enemy.interfaces.IPlayerAttacker;
import player.interfaces.IPlayers;

/** Class that represents the character Goomba */
public class Goomba extends AbstractEnemy implements IAttackableByPlayer, IPlayerAttacker {

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
  public void attackPlayer(IPlayers aPlayer) {
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
