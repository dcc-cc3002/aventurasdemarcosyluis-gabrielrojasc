package characters.enemy;

import characters.character.AbstractCharacter;
import characters.enemy.interfaces.IEnemies;
import characters.player.interfaces.IPlayers;

/** Class that represents an enemy */
public abstract class AbstractEnemy extends AbstractCharacter implements IEnemies {

  /**
   * Create an enemy
   *
   * @param LVL the lvl of the enemy
   * @param ATK the atk of the enemy
   * @param DEF the def of the enemy
   * @param HP the hp of the enemy
   * @throws IllegalArgumentException if HP is less than 0 or greater than MaxHP
   * @param MaxHP the maxHp of the enemy
   * @throws IllegalArgumentException if MaxHp is less than 0
   */
  public AbstractEnemy(int LVL, int ATK, int DEF, int HP, int MaxHP) {
    super(LVL, ATK, DEF, HP, MaxHP);
  }

  @Override
  public void receiveDmg(int dmg) {
    int newHp = this.getHp() - dmg;
    this.setHp(Math.max(0, newHp));
  }

  @Override
  public int getDmg(IPlayers aPlayer) {
    float dmg = (float) 0.75 * this.getAtk() * ((float) this.getLvl() / (float) aPlayer.getDef());
    return Math.round(dmg);
  }
}
