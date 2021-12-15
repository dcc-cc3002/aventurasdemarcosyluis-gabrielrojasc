package com.example.aventurasdemarcoyluis.controller.phases;

public class WaitForJumpTargetPhase extends Phase {
  public WaitForJumpTargetPhase() {
    this.name = "Wait_For_Jump_Target_Phase";
    this.canAttackEnemy = false;
    this.canUseItem = false;
    this.canPass = false;
  }
}
