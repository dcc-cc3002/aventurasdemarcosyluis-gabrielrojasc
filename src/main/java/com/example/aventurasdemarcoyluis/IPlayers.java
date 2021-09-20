package com.example.aventurasdemarcoyluis;

public interface IPlayers {
  public int getLvl();

  public void setLvl(int lvl);

  public int getAtk();

  public void setAtk(int atk);

  public int getDef();

  public void setDef(int def);

  public int getHp();

  public void setHp(int hp);

  public int getFp();

  public void setFp(int fp);

  public int getMaxHp();

  public String getItems();

  public boolean isKO();

  public void addItem(IItems item);

  public void useItem(IItems item);
}
