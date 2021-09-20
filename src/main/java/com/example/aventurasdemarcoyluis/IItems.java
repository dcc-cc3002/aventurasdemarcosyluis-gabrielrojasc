package com.example.aventurasdemarcoyluis;

public interface IItems {
  public String getName();

  public void applyTo(IPlayers players);

  @Override
  public boolean equals(Object o);
}
