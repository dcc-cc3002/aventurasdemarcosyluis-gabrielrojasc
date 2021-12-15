package com.example.aventurasdemarcoyluis.controller.phases;

public class ItemPhase extends Phase {
  public ItemPhase() {
    this.name = "Item_Phase";
    this.canAttackEnemy = false;
    this.canUseItem = false;
    this.canPass = false;
  }
}
