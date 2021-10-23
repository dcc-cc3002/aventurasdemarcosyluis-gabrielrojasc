package characters.player;

import characters.enemy.Boo;
import characters.enemy.interfaces.attackable.IAttackableByLuis;
import characters.player.interfaces.attackable.IAttackableByBoo;
import characters.player.interfaces.attacker.IAttackableByLuisAttacker;

/** Class that represents the character Luis */
public class Luis extends AbstractPlayer implements IAttackableByBoo, IAttackableByLuisAttacker {

  /**
   * Create a Luis
   *
   * @param LVL the lvl of Luis
   * @param ATK the atk of Luis
   * @param DEF the def of Luis
   * @param HP the hp of Luis
   * @param FP the fp of Luis
   * @param MaxHP the maxHp of Luis
   * @param MaxFP the maxFp of Luis
   */
  public Luis(int LVL, int ATK, int DEF, int HP, int FP, int MaxHP, int MaxFP) {
    super(LVL, ATK, DEF, HP, FP, MaxHP, MaxFP);
  }

  @Override
  public void jumpAttackEnemy(IAttackableByLuis anEnemy) {
    anEnemy.jumpAttackedByPlayer(this);
  }

  @Override
  public void hammerAttackEnemy(IAttackableByLuis anEnemy) {
    anEnemy.hammerAttackedByPlayer(this);
  }

  @Override
  public void attackedByBoo(Boo aBoo) {
    int newHp = this.getHp() - aBoo.getDmg(this);
    this.setHp(Math.max(0, newHp));
  }
}
