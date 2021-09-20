package com.example.aventurasdemarcoyluis;

public abstract class abstractItem implements IItems {

  protected String name;

  public abstractItem() {}

  public String getName() {
    return name;
  }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof IItems)) return false;
    IItems item = (IItems) o;
    return this.getName() == item.getName();
  }
}
