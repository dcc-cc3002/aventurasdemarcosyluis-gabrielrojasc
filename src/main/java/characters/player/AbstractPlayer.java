package characters.player;

import characters.character.AbstractCharacter;
import characters.enemy.Goomba;
import characters.enemy.Spiny;
import characters.enemy.interfaces.IEnemies;
import characters.enemy.interfaces.attackable.IAttackableByPlayer;
import characters.player.interfaces.IPlayers;
import characters.player.interfaces.attackable.IAttackableByGoomba;
import characters.player.interfaces.attackable.IAttackableBySpiny;
import characters.player.interfaces.attacker.IAttackableByPlayerAttacker;
import item.IItems;
import java.util.Random;

/** Class that represents a player */
public abstract class AbstractPlayer extends AbstractCharacter
    implements IPlayers, IAttackableByGoomba, IAttackableBySpiny, IAttackableByPlayerAttacker {

  protected int fp;
  protected int maxFp;
  protected Random rand = new Random();

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
   * Uses an item if the item is on the itemList
   *
   * @param item the item to be used
   */
  @Override
  public void useItem(IItems item, ItemVault vault) {
    if (!this.isKO()) {
      vault.useItem(item, this);
    }
  }

  @Override
  public void setRandSeed(int seed) {
    rand.setSeed(seed);
  }

  @Override
  public void receiveDmg(int dmg) {
    int newHp = this.getHp() - dmg;
    this.setHp(Math.max(0, newHp));
  }

  @Override
  public int getJumpDmg(IEnemies anEnemy) {
    float dmg = this.getAtk() * ((float) this.getLvl() / (float) anEnemy.getDef());
    return Math.round(dmg);
  }

  @Override
  public int getHammerDmg(IEnemies anEnemy) {
    float dmg = (float) 1.5 * this.getAtk() * ((float) this.getLvl() / (float) anEnemy.getDef());
    return Math.round(dmg);
  }

  @Override
  public void jumpAttackEnemy(IAttackableByPlayer anEnemy) {
    int newFp = this.getFp() - 1;
    if (newFp >= 0) {
      anEnemy.jumpAttackedByPlayer(this);
      this.setFp(newFp);
    }
  }

  @Override
  public void hammerAttackEnemy(IAttackableByPlayer anEnemy) {
    int newFp = this.getFp() - 2;
    if (newFp >= 0 && rand.nextInt(4) == 0) {
      anEnemy.hammerAttackedByPlayer(this);
      this.setFp(newFp);
    }
  }

  @Override
  public void attackedByGoomba(Goomba aGoomba) {
    this.receiveDmg(aGoomba.getDmg(this));
  }

  @Override
  public void attackedBySpiny(Spiny aSpiny) {
    this.receiveDmg(aSpiny.getDmg(this));
  }
}
