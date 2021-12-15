package com.example.aventurasdemarcoyluis.controller.phases;

public class JumpAttackPhase extends Phase {
  public JumpAttackPhase() {
    this.name = "Jump_Attack_Phase";
    this.canAttackEnemy = false;
    this.canUseItem = false;
    this.canPass = false;
  }
}
