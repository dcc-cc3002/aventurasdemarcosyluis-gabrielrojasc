package com.example.aventurasdemarcoyluis.controller.phases;

public class HammerAttackPhase extends Phase {
  public HammerAttackPhase() {
    this.name = "Hammer_Attack_Phase";
    this.canAttackEnemy = false;
    this.canUseItem = false;
    this.canPass = false;
  }
}
