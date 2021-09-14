package com.example.aventurasdemarcoyluis;

public class Star implements Items {

  private String name = "Star";

  public Star() {}

  public String getName() {
    return name;
  }

  public void applyTo(Players player) {

    int currHp = player.getHp();
  }
}
