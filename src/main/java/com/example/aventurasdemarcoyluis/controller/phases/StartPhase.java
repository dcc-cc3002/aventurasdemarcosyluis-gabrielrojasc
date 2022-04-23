package com.example.aventurasdemarcoyluis.controller.phases;

/** Class that defines the start phase */
public class StartPhase extends Phase {

  /** Creates an start phase */
  public StartPhase() {
    this.name = "Start_Phase";
    this.canAttackEnemy = true;
    this.canUseItem = true;
    this.canPass = true;
  }

  /** Changes to an attack phase */
  public void toAttackPhase() {
    this.changePhase(new AttackPhase());
  }

  /** Change to an item phase */
  public void toItemPhase() {
    this.changePhase(new ItemPhase());
  }

  /** Change to a pass phase */
  public void toPassPhase() {
    this.changePhase(new PassPhase());
  }
}
