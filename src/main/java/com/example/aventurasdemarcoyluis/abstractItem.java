package com.example.aventurasdemarcoyluis;

import java.util.Objects;

public abstract class abstractItem implements IItems {

  protected String name;

  public abstractItem() {}

  public String getName() {
    return name;
  }

  public abstract void applyTo(IPlayers player);

  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof IItems item)) return false;
    return Objects.equals(this.getName(), item.getName());
  }
}
