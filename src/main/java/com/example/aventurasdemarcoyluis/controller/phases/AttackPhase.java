package com.example.aventurasdemarcoyluis.controller.phases;

public class AttackPhase extends Phase {
  public AttackPhase() {
    this.name = "Attack_Phase";
    this.canAttackEnemy = true;
    this.canUseItem = false;
    this.canPass = false;
  }


}
