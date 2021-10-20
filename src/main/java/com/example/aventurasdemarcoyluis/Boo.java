package com.example.aventurasdemarcoyluis;

/** Class that represents the character Boo */
public class Boo extends AbstractEnemy {

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
}
