package model.characters.player.abstract_classes;

import java.util.Random;
import model.characters.character.abstract_classes.AbstractCharacter;
import model.characters.enemy.interfaces.IEnemies;
import model.characters.player.ItemVault;
import model.characters.player.interfaces.IPlayers;
import model.item.IItems;

/** Class that represents a player */
public abstract class AbstractPlayer extends AbstractCharacter implements IPlayers {
  protected int fp;
  protected int maxFp;
  protected Random rand = new Random();
  protected boolean attackableByBoo;

  /**
   * Create a player
   *
   * @param LVL the lvl of the player
   * @param ATK the atk of the player
   * @param DEF the def of the player
   * @param HP the hp of the player
   * @throws IllegalArgumentException if HP is less than 0 or greater than MaxHP
   * @param FP the fp of the player
   * @throws IllegalArgumentException if FP is less than 0 or greater than MaxFP
   * @param MaxHP the maxHp of the player
   * @throws IllegalArgumentException if MaxHP is less than 0
   * @param MaxFP the maxFp of the player
   * @throws IllegalArgumentException if MaxFP is less than 0
   */
  public AbstractPlayer(int LVL, int ATK, int DEF, int HP, int FP, int MaxHP, int MaxFP) {
    super(LVL, ATK, DEF, HP, MaxHP);

    if (MaxFP < 0) {
      throw new IllegalArgumentException(
          MaxHP + " is not a valid maxFp. maxFp must be greater than 0.");
    }
    if (FP < 0 || FP > MaxFP) {
      throw new IllegalArgumentException(
          HP + " is not a valid fp. fp must be between 0 and " + MaxFP);
    }
    this.fp = FP;
    this.maxFp = MaxFP;
  }

  /** Returns the fp */
  @Override
  public int getFp() {
    return fp;
  }

  /**
   * Sets the fp
   *
   * @param fp the fp to set
   * @throws IllegalArgumentException if fp is less than 0 or greater than maxFp
   */
  @Override
  public void setFp(int fp) {
    if (fp > maxFp || fp < 0) {
      throw new IllegalArgumentException(
          fp + " is not a valid fp. hp must be between 0 and " + maxFp);
    }
    this.fp = fp;
  }

  /** Returns the maxFp */
  @Override
  public int getMaxFp() {
    return maxFp;
  }

  /**
   * Levels up the Character, meaning it adds +1 to lvl, +15% of maxHp to hp, +15% to atk, +15% to
   * def and +15% of the maxFp to fp
   */
  @Override
  public void levelUp() {
    super.levelUp();
    int newFp = this.getFp() + Math.round((float) 0.15 * this.getMaxFp());
    this.setFp(Math.min(this.getMaxFp(), newFp));
  }

  /**
   * Uses an model.item if the model.item is on the itemList
   *
   * @param item the model.item to be used
   */
  @Override
  public void useItem(IItems item, ItemVault vault) {
    if (!this.isKO()) {
      vault.useItem(item, this);
    }
  }

  /**
   * Sets the random seed for the random number rand
   *
   * @param seed the seed to set
   */
  @Override
  public void setRandSeed(int seed) {
    rand.setSeed(seed);
  }

  /**
   * Return the damage made by a jump attack from this
   *
   * @param anEnemy the enemy being damaged by a jump attack
   * @return the damage to be dealt by a jump attack from this
   */
  @Override
  public int getJumpDmg(IEnemies anEnemy) {
    float dmg = this.getAtk() * ((float) this.getLvl() / (float) anEnemy.getDef());
    return Math.round(dmg);
  }

  /**
   * Return the damage made by a hammer attack from this
   *
   * @param anEnemy the enemy being damaged by a hammer attack
   * @return the damage to be dealt by a hammer attack from this
   */
  @Override
  public int getHammerDmg(IEnemies anEnemy) {
    float dmg = (float) 1.5 * this.getAtk() * ((float) this.getLvl() / (float) anEnemy.getDef());
    return Math.round(dmg);
  }

  /**
   * Receives the damage dealt by an enemy
   *
   * @param anEnemy the enemy dealing the damage
   */
  @Override
  public void attackedByEnemy(IEnemies anEnemy) {
    this.receiveDmg(anEnemy.getDmg(this));
  }

  public abstract boolean attackableByBoo();
}
