package model.characters.player;

import model.characters.enemy.interfaces.attackable.IAttackableByLuis;
import model.characters.player.abstract_classes.AbstractPlayer;
import model.characters.player.interfaces.IPlayers;
import model.characters.player.interfaces.attackable.IAttackableByBoo;

/** Class that represents the character Luis */
public class Luis extends AbstractPlayer implements IPlayers, IAttackableByBoo {

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
    this.attackableByBoo = true;
  }

  /**
   * Jump attacks an enemy, consumes the respective fp if the attack is made, else it does not
   * attack
   *
   * @param anEnemy the enemy (attackable by Luis) to be attacked
   */
  public void jumpAttack(IAttackableByLuis anEnemy) {
    int newFp = this.getFp() - 1;
    if (newFp >= 0) {
      anEnemy.jumpAttackedByPlayer(this);
      this.setFp(newFp);
    }
  }

  /**
   * Hammer attacks an enemy, consumes the respective fp if the attack is made, else it does not
   * attack
   *
   * @param anEnemy the enemy (attackable by Luis) to be attacked
   */
  public void hammerAttack(IAttackableByLuis anEnemy) {
    int newFp = this.getFp() - 2;
    if (newFp >= 0 && rand.nextInt(4) == 0) {
      anEnemy.hammerAttackedByPlayer(this);
      this.setFp(newFp);
    }
  }

  /** Returns if this is attackable by Boo */
  @Override
  public boolean attackableByBoo() {
    return attackableByBoo;
  }
}
