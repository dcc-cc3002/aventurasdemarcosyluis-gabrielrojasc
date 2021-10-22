package enemy;

import player.IPlayers;

/** Class that represents the character Goomba */
public class Goomba extends AbstractEnemy implements IPlayerAttacker {

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

  public void attackPlayer(IPlayers aPlayer) {
    aPlayer.attackedByGoomba(this);
  }
}
