package com.example.aventurasdemarcoyluis.controller.phases;

/** Class that defines */
public class AttackPhase extends Phase {

  /** Creates an attack phase */
  public AttackPhase() {
    this.name = "Attack_Phase";
    this.canAttackEnemy = true;
    this.canUseItem = false;
    this.canPass = false;
  }

  /** Changes to jump attack phase */
  public void toJumpAttackPhase() {
    this.changePhase(new JumpAttackPhase());
  }

  /** Changes to hammer attack phase */
  public void toHammerAttackPhase() {
    this.changePhase(new HammerAttackPhase());
  }
}
