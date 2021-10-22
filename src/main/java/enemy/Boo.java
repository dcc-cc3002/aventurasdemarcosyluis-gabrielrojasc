package enemy;

import enemy.interfaces.IAttackableByBooAttacker;
import enemy.interfaces.IAttackableByLuis;
import player.Luis;
import player.interfaces.IAttackableByBoo;

/** Class that represents the character Boo */
public class Boo extends AbstractEnemy implements IAttackableByLuis, IAttackableByBooAttacker {

  /**
   * Create a Boo
   *
   * @param LVL the lvl of Boo
   * @param ATK the atk of Boo
   * @param DEF the def of Boo
   * @param HP the hp of Boo
   * @param MaxHP the maxHp of Boo
   */
  public Boo(int LVL, int ATK, int DEF, int HP, int MaxHP) {
    super(LVL, ATK, DEF, HP, MaxHP);
  }

  @Override
  public void attackPlayer(IAttackableByBoo aPlayer) {
    aPlayer.attackedByBoo(this);
  }

  @Override
  public void jumpAttackedByLuis(Luis aLuis) {
    this.receiveDmg(aLuis.getJumpDmg(this));
  }

  @Override
  public void hammerAttackedByLuis(Luis aLuis) {}
}
