package enemy;

/** Class that represents the character Spiny */
public class Spiny extends AbstractEnemy {

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
}
