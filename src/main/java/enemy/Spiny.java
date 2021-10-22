package enemy;

import enemy.interfaces.IAttackableByPlayer;
import enemy.interfaces.IAttackableBySpinyAttacker;
import player.interfaces.IAttackableBySpiny;
import player.interfaces.IPlayers;

/** Class that represents the character Spiny */
public class Spiny extends AbstractEnemy
    implements IAttackableByPlayer, IAttackableBySpinyAttacker {

  /**
   * Create a Spiny
   *
   * @param LVL the lvl of Spiny
   * @param ATK the atk of Spiny
   * @param DEF the def of Spiny
   * @param HP the hp of Spiny
   * @param MaxHP the maxHp of Spiny
   */
  public Spiny(int LVL, int ATK, int DEF, int HP, int MaxHP) {
    super(LVL, ATK, DEF, HP, MaxHP);
  }

  @Override
  public void attackPlayer(IAttackableBySpiny aPlayer) {
    aPlayer.attackedBySpiny(this);
  }

  @Override
  public void jumpAttackedByPlayer(IPlayers aPlayer) {
    int newHp = Math.round(aPlayer.getHp() * (float) 0.95);
    aPlayer.setHp(Math.max(0, newHp));
  }

  @Override
  public void hammerAttackedByPlayer(IPlayers aPlayer) {
    this.receiveDmg(aPlayer.getHammerDmg(this));
  }
}
