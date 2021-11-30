package com.example.aventurasdemarcoyluis.model.characters.enemy.factories;

import com.example.aventurasdemarcoyluis.model.characters.enemy.Boo;
import com.example.aventurasdemarcoyluis.model.characters.enemy.Goomba;
import com.example.aventurasdemarcoyluis.model.characters.enemy.Spiny;
import com.example.aventurasdemarcoyluis.model.characters.enemy.interfaces.IEnemies;
import java.util.Random;

/** Class that creates a random enemy */
public class RandomEnemyFactory {
  private Random rand = new Random();

  /** Create a random enemy factory */
  public RandomEnemyFactory() {}

  /**
   * Sets the seed for the random number rand
   *
   * @param seed the seed to set
   */
  public void setRandSeed(int seed) {
    rand.setSeed(seed);
  }

  /**
   * Returns a random enemy
   *
   * @param lvl the lvl of the random enemy
   * @param atk the atk of the random enemy
   * @param def the def of the random enemy
   * @param hp the hp of the random enemy
   * @param maxHp the maxHp of the random enemy
   * @return a random enemy created with the above parameters
   */
  public IEnemies createEnemy(int lvl, int atk, int def, int hp, int maxHp) {
    int enemyType = rand.nextInt(3);

    if (enemyType == 0) return new Goomba(lvl, atk, def, hp, maxHp);
    else if (enemyType == 1) return new Spiny(lvl, atk, def, hp, maxHp);
    else return new Boo(lvl, atk, def, hp, maxHp);
  }
}
