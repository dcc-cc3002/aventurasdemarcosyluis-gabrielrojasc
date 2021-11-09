package model.characters.player;

import model.characters.enemy.interfaces.IEnemies;
import model.characters.player.abstract_classes.AbstractPlayer;
import model.characters.player.interfaces.IPlayers;

/** Class that represent the character Marco */
public class Marco extends AbstractPlayer implements IPlayers {

  /**
   * Create a Marco
   *
   * @param LVL the lvl of Marco
   * @param ATK the atk of Marco
   * @param DEF the def of Marco
   * @param HP the hp of Marco
   * @param FP the fp of Marco
   * @param MaxHP the maxHp of Marco
   * @param MaxFP the maxFp of Marco
   */
  public Marco(int LVL, int ATK, int DEF, int HP, int FP, int MaxHP, int MaxFP) {
    super(LVL, ATK, DEF, HP, FP, MaxHP, MaxFP);
    this.attackableByBoo = false;
  }

  /**
   * Jump attacks an enemy, consumes the respective fp if the attack is made, else it does not
   * attack
   *
   * @param anEnemy the enemy to be attacked
   */
  public void jumpAttack(IEnemies anEnemy) {
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
   * @param anEnemy the enemy to be attacked
   */
  public void hammerAttack(IEnemies anEnemy) {
    int newFp = this.getFp() - 2;
    if (newFp >= 0 && rand.nextInt(4) == 0) {
      anEnemy.hammerAttackedByPlayer(this);
      this.setFp(newFp);
    }
  }

  @Override
  public boolean attackableByBoo() {
    return attackableByBoo;
  }
}
