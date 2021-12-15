package com.example.aventurasdemarcoyluis.controller.phases;

/** Class that defines an item phase */
public class ItemPhase extends Phase {

  /** Creates an item phase */
  public ItemPhase() {
    this.name = "Item_Phase";
    this.canAttackEnemy = false;
    this.canUseItem = false;
    this.canPass = false;
  }
}
