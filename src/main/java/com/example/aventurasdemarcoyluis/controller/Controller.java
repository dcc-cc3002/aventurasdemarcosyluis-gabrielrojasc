package com.example.aventurasdemarcoyluis.controller;

import com.example.aventurasdemarcoyluis.model.characters.character.interfaces.ICharacters;
import com.example.aventurasdemarcoyluis.model.characters.enemy.Boo;
import com.example.aventurasdemarcoyluis.model.characters.enemy.Goomba;
import com.example.aventurasdemarcoyluis.model.characters.enemy.Spiny;
import com.example.aventurasdemarcoyluis.model.characters.enemy.factories.RandomEnemyFactory;
import com.example.aventurasdemarcoyluis.model.characters.enemy.interfaces.IEnemies;
import com.example.aventurasdemarcoyluis.model.characters.enemy.interfaces.attackable.IAttackableByLuis;
import com.example.aventurasdemarcoyluis.model.characters.player.ItemVault;
import com.example.aventurasdemarcoyluis.model.characters.player.Luis;
import com.example.aventurasdemarcoyluis.model.characters.player.Marco;
import com.example.aventurasdemarcoyluis.model.characters.player.interfaces.IPlayers;
import com.example.aventurasdemarcoyluis.model.characters.player.interfaces.attackable.IAttackableByBoo;
import com.example.aventurasdemarcoyluis.model.item.HoneySyrup;
import com.example.aventurasdemarcoyluis.model.item.IItems;
import com.example.aventurasdemarcoyluis.model.item.RedMushroom;
import java.util.ArrayList;
import java.util.Random;

/** The class that represents the com.example.aventurasdemarcoyluis.controller */
public class Controller {

  private int round = 1;
  private int currentTurn = 0;
  private ArrayList<IPlayers> playerList = new ArrayList<>();
  private ArrayList<IEnemies> enemyList = new ArrayList<>();
  private ArrayList<ICharacters> characterList = new ArrayList<>();
  private ItemVault itemVault = new ItemVault();
  private RandomEnemyFactory randomEnemyFactory = new RandomEnemyFactory();
  private Random rand = new Random();

  /** Creates a com.example.aventurasdemarcoyluis.controller */
  public Controller() {}

  /**
   * Initializes the com.example.aventurasdemarcoyluis.controller with respective players, enemies
   * and items for the respective round
   */
  public void initialize() {
    generatePlayers();
    generateEnemies();
    generateItems();
  }

  /** Returns the current round */
  public int getRound() {
    return round;
  }

  /**
   * Sets the current round
   *
   * @param round the round to set
   */
  public void setRound(int round) {
    this.round = round;
  }

  /**
   * Sets the seed to be used for the random numbers
   *
   * @param seed the seed to set
   */
  public void setRandSeed(int seed) {
    rand.setSeed(seed);
    randomEnemyFactory.setRandSeed(seed);
    for (IPlayers player : playerList) {
      player.setRandSeed(seed);
    }
  }

  /**
   * Adds a player to the player and character list
   *
   * @param aPlayer the player to add
   */
  public void addCharacter(IPlayers aPlayer) {
    playerList.add(aPlayer);
    characterList.add(aPlayer);
  }

  /**
   * Adds an enemy to the enemy and character list
   *
   * @param anEnemy the enemy to add
   */
  public void addCharacter(IEnemies anEnemy) {
    enemyList.add(anEnemy);
    characterList.add(anEnemy);
  }

  /**
   * Adds an item to the item vault
   *
   * @param anItem the item to add
   */
  public void addItem(IItems anItem) {
    itemVault.addItem(anItem);
  }

  /** Generates the players for the current round */
  public void generatePlayers() {
    playerList = new ArrayList<>();
    Marco marco = new Marco(1, 5, 5, 10, 8, 10, 8);
    Luis luis = new Luis(1, 5, 5, 10, 8, 10, 8);
    for (int i = 1; i < round; i++) {
      marco.levelUp();
      luis.levelUp();
    }
    this.addCharacter(marco);
    this.addCharacter(luis);
  }

  /** Generates the enemies for the current round */
  public void generateEnemies() {
    enemyList = new ArrayList<>();
    if (round <= 2) addNRandomEnemiesToEnemyList(3);
    else if (round <= 4) addNRandomEnemiesToEnemyList(5);
    else addNRandomEnemiesToEnemyList(6);
  }

  /** Generates the character list from the player and enemy lists */
  public void generateCharacterList() {
    characterList = new ArrayList<>();
    characterList.addAll(playerList);
    characterList.addAll(enemyList);
  }

  /**
   * Adds N random enemies to the enemy and character list for the current round
   *
   * @param N the number of enemies to add
   */
  public void addNRandomEnemiesToEnemyList(int N) {
    for (int i = 0; i < N; i++) {
      this.addCharacter(randomEnemyFactory.createEnemy(1, 5, 5, 10, 10));
      for (int j = 1; j < round; j++) enemyList.get(i).levelUp();
    }
  }

  /** Generates the items for the current round */
  public void generateItems() {
    if (round == 1) {
      for (int i = 0; i < 3; i++) {
        this.addItem(new RedMushroom());
        this.addItem(new HoneySyrup());
      }
    } else {
      this.addItem(new RedMushroom());
      this.addItem(new HoneySyrup());
    }
  }

  /**
   * Applies an item (if available on the item vault) on a player
   *
   * @param aPlayer the player to apply the item to
   * @param anItem the item to apply
   */
  public void useItem(IPlayers aPlayer, IItems anItem) {
    itemVault.useItem(anItem, aPlayer);
  }

  /** Returns the item currently available on the vault */
  public ArrayList<IItems> getItems() {
    return itemVault.getItems();
  }

  /** Returns the character list */
  public ArrayList<ICharacters> getCharacterList() {
    return characterList;
  }

  /** Returns the player list */
  public ArrayList<IPlayers> getPlayers() {
    return playerList;
  }

  /** Returns the enemy list */
  public ArrayList<IEnemies> getEnemies() {
    return enemyList;
  }

  /** Returns the character who owns the current turn */
  public ICharacters getCurrentTurnCharacter() {
    ICharacters character = characterList.get(currentTurn);
    if (character.isKO()) {
      finishCurrentTurn();
      return getCurrentTurnCharacter();
    } else return character;
  }

  /** Returns the character who owns the next turn */
  public ICharacters getNextTurnCharacter() {
    int turn = currentTurn;
    finishCurrentTurn();
    ICharacters character = getCurrentTurnCharacter();
    currentTurn = turn;
    return character;
  }

  /** Finishes the current turn */
  public void finishCurrentTurn() {
    currentTurn += 1;
    currentTurn %= characterList.size();
  }

  /**
   * Jump attacks an enemy
   *
   * @param aMarco the attacker
   * @param anEnemy the attacked
   */
  public void jumpAttackEnemy(Marco aMarco, IEnemies anEnemy) {
    aMarco.jumpAttack(anEnemy);
  }

  /**
   * Jump attacks an enemy (attackable by Luis)
   *
   * @param aLuis the attacker
   * @param anEnemy the attacked
   */
  public void jumpAttackEnemy(Luis aLuis, IAttackableByLuis anEnemy) {
    aLuis.jumpAttack(anEnemy);
  }

  /**
   * Hammer attacks an enemy
   *
   * @param aMarco the attacker
   * @param anEnemy the attacked
   */
  public void hammerAttackEnemy(Marco aMarco, IEnemies anEnemy) {
    aMarco.hammerAttack(anEnemy);
  }

  /**
   * Hammer attacks an enemy (attackable by Luis)
   *
   * @param aLuis the attacker
   * @param anEnemy the attacked
   */
  public void hammerAttackEnemy(Luis aLuis, IAttackableByLuis anEnemy) {
    aLuis.hammerAttack(anEnemy);
  }

  /** Returns an array of the attackable players */
  public ArrayList<IPlayers> getAttackablePlayers() {
    ArrayList<IPlayers> attackable = new ArrayList<>();
    for (IPlayers player : playerList) {
      if (!player.isKO()) attackable.add(player);
    }
    return attackable;
  }

  /** Returns an array of the attackable players by boo */
  public ArrayList<IAttackableByBoo> getAttackableByBoo() {
    ArrayList<IAttackableByBoo> attackable = new ArrayList<>();
    for (IPlayers player : playerList) {
      if (!player.isKO() && player.attackableByBoo()) attackable.add((IAttackableByBoo) player);
    }
    return attackable;
  }

  /** Returns an array of the attackable enemies */
  public ArrayList<IEnemies> getAttackableEnemies() {
    ArrayList<IEnemies> attackable = new ArrayList<>();
    for (IEnemies enemy : enemyList) {
      if (!enemy.isKO()) attackable.add(enemy);
    }
    return attackable;
  }

  /** Returns an array of the attable enemies by Luis */
  public ArrayList<IAttackableByLuis> getAttackableByLuis() {
    ArrayList<IAttackableByLuis> attackable = new ArrayList<>();
    for (IEnemies enemy : enemyList) {
      if (!enemy.isKO() && enemy.attackableByLuis()) attackable.add((IAttackableByLuis) enemy);
    }
    return attackable;
  }

  /** Returns a target for Marco to attack in automated test */
  public IEnemies getTargetMarco() {
    ArrayList<IEnemies> attackable = getAttackableEnemies();
    int chosen = rand.nextInt(attackable.size());
    return attackable.get(chosen);
  }

  /** Returns a target for Luis to attack in automated test */
  public IAttackableByLuis getTargetLuis() {
    ArrayList<IAttackableByLuis> attackable = getAttackableByLuis();
    int chosen = rand.nextInt(attackable.size());
    return attackable.get(chosen);
  }

  /**
   * Attacks a random player
   *
   * @param aGoomba the attacker
   */
  public void attackRandomPlayer(Goomba aGoomba) {
    ArrayList<IPlayers> attackable = getAttackablePlayers();
    int chosen = rand.nextInt(attackable.size());
    aGoomba.attackPlayer(attackable.get(chosen));
  }

  /**
   * Attacks a random player
   *
   * @param aSpiny the attacker
   */
  public void attackRandomPlayer(Spiny aSpiny) {
    ArrayList<IPlayers> attackable = getAttackablePlayers();
    int chosen = rand.nextInt(attackable.size());
    aSpiny.attackPlayer(attackable.get(chosen));
  }

  /**
   * Attacks a random player (attackable by boo)
   *
   * @param aBoo the attacker
   */
  public void attackRandomPlayer(Boo aBoo) {
    ArrayList<IAttackableByBoo> attackable = getAttackableByBoo();
    int chosen = rand.nextInt(attackable.size());
    aBoo.attackPlayer(attackable.get(chosen));
  }

  /** Returns if the enemies have won */
  public boolean enemiesWin() {
    for (IPlayers player : playerList) {
      if (!player.isKO()) return false;
    }
    return true;
  }

  /** Returns if the player have won the current battle */
  public boolean playersWinBattle() {
    for (IEnemies enemy : enemyList) {
      if (!enemy.isKO()) return false;
    }
    return true;
  }

  /** Returns if the players have won the game */
  public boolean playersWinGame() {
    return round > 5;
  }
}
