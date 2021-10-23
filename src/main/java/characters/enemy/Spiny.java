package characters.enemy;

import characters.enemy.interfaces.attackable.IAttackableByPlayer;
import characters.enemy.interfaces.attacker.IAttackableBySpinyAttacker;
import characters.player.interfaces.IPlayers;
import characters.player.interfaces.attackable.IAttackableBySpiny;

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
    int dmg = Math.round((float) 0.05 * aPlayer.getHp());
    aPlayer.receiveDmg(dmg);
  }

  @Override
  public void hammerAttackedByPlayer(IPlayers aPlayer) {
    this.receiveDmg(aPlayer.getHammerDmg(this));
  }
}
