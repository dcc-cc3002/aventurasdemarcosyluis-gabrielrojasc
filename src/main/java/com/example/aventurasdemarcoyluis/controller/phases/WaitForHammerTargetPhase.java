package com.example.aventurasdemarcoyluis.controller.phases;

public class WaitForHammerTargetPhase extends Phase {
  public WaitForHammerTargetPhase() {
    this.name = "Wait_For_Hammer_Target_Phase";
    this.canAttackEnemy = false;
    this.canUseItem = false;
    this.canPass = false;
  }
}
