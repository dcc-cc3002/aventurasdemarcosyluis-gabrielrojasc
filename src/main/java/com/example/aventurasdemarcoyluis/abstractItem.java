package com.example.aventurasdemarcoyluis;

public abstract class abstractItem implements Items {

  protected String name;

  public abstractItem() {}

  public String getName() {
    return name;
  }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Items)) return false;
    Items item = (Items) o;
    return this.getName() == item.getName();
  }
}
