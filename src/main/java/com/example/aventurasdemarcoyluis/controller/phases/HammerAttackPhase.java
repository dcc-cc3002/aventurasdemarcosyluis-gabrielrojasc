package com.example.aventurasdemarcoyluis.controller.phases;

/** Class that defines the hammer attack phase */
public class HammerAttackPhase extends Phase {

  /** Creates a hammer attack phase */
  public HammerAttackPhase() {
    this.name = "Hammer_Attack_Phase";
    this.canAttackEnemy = false;
    this.canUseItem = false;
    this.canPass = false;
  }
}
