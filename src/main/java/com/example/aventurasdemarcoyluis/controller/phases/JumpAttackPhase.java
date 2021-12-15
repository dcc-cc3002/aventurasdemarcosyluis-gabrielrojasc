package com.example.aventurasdemarcoyluis.controller.phases;

/** Class that defines a jump attack phase */
public class JumpAttackPhase extends Phase {

  /** Create a jump attack phase */
  public JumpAttackPhase() {
    this.name = "Jump_Attack_Phase";
    this.canAttackEnemy = false;
    this.canUseItem = false;
    this.canPass = false;
  }
}
