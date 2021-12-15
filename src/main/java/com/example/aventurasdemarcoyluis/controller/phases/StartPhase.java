package com.example.aventurasdemarcoyluis.controller.phases;

public class StartPhase extends Phase {

  public StartPhase() {
    this.name = "Start_Phase";
    this.canAttackEnemy = true;
    this.canUseItem = true;
    this.canPass = true;
  }

  public void toAttackPhase() {
    this.changePhase(new AttackPhase());
  }

  public void toItemPhase() {}
}
