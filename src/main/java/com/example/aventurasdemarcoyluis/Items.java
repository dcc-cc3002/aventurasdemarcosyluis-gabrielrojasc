package com.example.aventurasdemarcoyluis;

public interface Items {
  public String getName();

  public void applyTo(Players players);

  @Override
  public boolean equals(Object o);
}
