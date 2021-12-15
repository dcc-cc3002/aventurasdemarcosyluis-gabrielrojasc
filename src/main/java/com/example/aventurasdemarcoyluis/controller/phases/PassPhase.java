package com.example.aventurasdemarcoyluis.controller.phases;

/** Class that defines a pass phase */
public class PassPhase extends Phase {

  /** Creates a pass phase */
  public PassPhase() {
    this.name = "Pass_Phase";
    this.canAttackEnemy = false;
    this.canUseItem = false;
    this.canPass = false;
  }
}
