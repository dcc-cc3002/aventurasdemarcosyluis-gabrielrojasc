package com.example.aventurasdemarcoyluis;

public interface Enemies {
  public int getLvl();

  public void setLvl(int lvl);

  public int getAtk();

  public void setAtk(int atk);

  public int getDef();

  public void setDef(int def);

  public int getHp();

  public void setHp(int hp);

  public int getMaxHp();

  public boolean isKO();
}
