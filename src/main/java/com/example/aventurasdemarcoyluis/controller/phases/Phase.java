package com.example.aventurasdemarcoyluis.controller.phases;

import com.example.aventurasdemarcoyluis.controller.Controller;
import com.example.aventurasdemarcoyluis.controller.phases.exceptions.InvalidMoveException;

/** Class that defines a phase */
public class Phase {
  public String name;
  public boolean canAttackEnemy;
  public boolean canUseItem;
  public boolean canPass;
  protected Controller controller;

  /**
   * Sets the controller for the phase
   *
   * @param aController the controller to set
   */
  public void setController(Controller aController) {
    this.controller = aController;
  }

  @Override
  public String toString() {
    return this.name;
  }

  /**
   * Changes the current phase
   *
   * @param aPhase the phase to change to
   */
  protected void changePhase(Phase aPhase) {
    controller.setPhase(aPhase);
  }
}
