import static org.junit.jupiter.api.Assertions.assertEquals;

import controller.Controller;
import java.util.ArrayList;
import model.characters.character.interfaces.ICharacters;
import model.characters.enemy.Boo;
import model.characters.enemy.Goomba;
import model.characters.enemy.Spiny;
import model.characters.enemy.interfaces.IEnemies;
import model.characters.enemy.interfaces.attackable.IAttackableByLuis;
import model.characters.player.Luis;
import model.characters.player.Marco;
import model.characters.player.interfaces.IPlayers;
import model.characters.player.interfaces.attackable.IAttackableByBoo;
import model.item.HoneySyrup;
import model.item.IItems;
import model.item.RedMushroom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestController {

  Controller controller;

  @BeforeEach
  public void setUp() {
    controller = new Controller();
  }

  @Test
  public void getRoundTest() {
    assertEquals(1, controller.getRound());
  }

  @Test
  public void setRoundTest() {
    controller.setRound(4);
    assertEquals(4, controller.getRound());
  }

  @Test
  public void setRandSeedTest() {
    Marco testMarco1 = new Marco(1, 1, 1, 1, 1, 1, 1);
    controller.addCharacter(testMarco1);
    controller.setRandSeed(1);
  }

  @Test
  public void generateItemsTest() {
    ArrayList<IItems> itemList = new ArrayList<>();
    IItems redMushroom = new RedMushroom();
    IItems honeySyrup = new HoneySyrup();
    for (int i = 0; i < 3; i++) {
      itemList.add(redMushroom);
      itemList.add(honeySyrup);
    }
    controller.setRound(1);
    controller.generateItems();
    assertEquals(itemList, controller.getItems());

    controller.setRound(2);
    controller.generateItems();
    itemList.add(redMushroom);
    itemList.add(honeySyrup);
    assertEquals(itemList, controller.getItems());
  }

  @Test
  public void generateCharacterList() {
    Marco testMarco = new Marco(1, 1, 1, 1, 1, 1, 1);
    Goomba testGoomba = new Goomba(1, 1, 1, 1, 1);
    ArrayList<ICharacters> characterList = new ArrayList<>();

    characterList.add(testMarco);
    characterList.add(testGoomba);

    controller.addCharacter(testMarco);
    controller.addCharacter(testGoomba);
    controller.generateCharacterList();

    assertEquals(characterList, controller.getCharacterList());
  }

  @Test
  public void generatePlayers() {
    ArrayList<IPlayers> playerList = new ArrayList<>();
    Marco testMarco = new Marco(1, 5, 5, 10, 8, 10, 8);
    Luis testLuis = new Luis(1, 5, 5, 10, 8, 10, 8);

    playerList.add(testMarco);
    playerList.add(testLuis);
    controller.setRound(1);
    controller.generatePlayers();
    assertEquals(2, controller.getPlayers().size());
    for (IPlayers player : controller.getPlayers()) {
      assertEquals(1, player.getLvl());
    }

    controller.setRound(3);
    controller.generatePlayers();
    assertEquals(2, controller.getPlayers().size());
    for (IPlayers player : controller.getPlayers()) {
      assertEquals(3, player.getLvl());
    }
  }

  @Test
  public void generateEnemiesForRound1and2Test() {
    controller.setRound(1);
    controller.generateEnemies();
    assertEquals(3, controller.getEnemies().size());
  }

  @Test
  public void generateEnemiesForRound3and4Test() {
    controller.setRound(3);
    controller.generateEnemies();
    assertEquals(5, controller.getEnemies().size());
  }

  @Test
  public void generateEnemiesForRound5Test() {
    controller.setRound(5);
    controller.generateEnemies();
    assertEquals(6, controller.getEnemies().size());
  }

  @Test
  public void getCharactersTest() {
    Marco testMarco = new Marco(1, 1, 1, 1, 1, 1, 1);
    Goomba testGoomba = new Goomba(1, 1, 1, 1, 1);
    ArrayList<ICharacters> characterList = new ArrayList<>();
    characterList.add(testMarco);
    characterList.add(testGoomba);
    controller.addCharacter(testMarco);
    controller.addCharacter(testGoomba);
    assertEquals(characterList, controller.getCharacterList());
  }

  @Test
  public void getPlayersTest() {
    Marco testMarco = new Marco(1, 1, 1, 1, 1, 1, 1);
    ArrayList<ICharacters> playerList = new ArrayList<>();
    playerList.add(testMarco);
    controller.addCharacter(testMarco);
    assertEquals(playerList, controller.getPlayers());
  }

  @Test
  public void getEnemies() {
    Goomba testGoomba = new Goomba(1, 1, 1, 1, 1);
    ArrayList<IEnemies> enemyList = new ArrayList<>();
    enemyList.add(testGoomba);
    controller.addCharacter(testGoomba);
    assertEquals(enemyList, controller.getEnemies());
  }

  @Test
  public void initializeControllerTest() {
    controller.initialize();
    assertEquals(5, controller.getCharacterList().size());
    assertEquals(6, controller.getItems().size());
  }

  @Test
  public void useItemTest() {
    IItems honeySyrup = new HoneySyrup();
    Marco testMarco1 = new Marco(1, 1, 1, 1, 1, 10, 10);
    Marco testMarco2 = new Marco(1, 1, 1, 1, 1, 10, 10);
    int prevFp = testMarco1.getFp();

    honeySyrup.applyTo(testMarco1);

    controller.useItem(testMarco2, honeySyrup);

    assertEquals(prevFp, testMarco2.getFp());

    controller.addItem(honeySyrup);

    controller.useItem(testMarco2, honeySyrup);

    assertEquals(testMarco1.getFp(), testMarco2.getFp());
  }

  @Test
  public void getCurrentTurnCharacterTest() {
    Marco testMarco = new Marco(1, 1, 1, 1, 1, 1, 1);
    Goomba testGoomba = new Goomba(1, 1, 1, 1, 1);
    controller.addCharacter(testMarco);
    controller.addCharacter(testGoomba);

    assertEquals(testMarco, controller.getCurrentTurnCharacter());

    controller.getCurrentTurnCharacter().setHp(0);

    assertEquals(testGoomba, controller.getCurrentTurnCharacter());
  }

  @Test
  public void getNextTurnCharacterTest() {
    Marco testMarco = new Marco(1, 1, 1, 1, 1, 1, 1);
    Goomba testGoomba = new Goomba(1, 1, 1, 1, 1);
    controller.addCharacter(testMarco);
    controller.addCharacter(testGoomba);

    assertEquals(testGoomba, controller.getNextTurnCharacter());

    controller.getNextTurnCharacter().setHp(0);

    assertEquals(testMarco, controller.getNextTurnCharacter());
  }

  @Test
  public void enemiesWinTest() {
    Marco testMarco = new Marco(1, 1, 1, 1, 1, 1, 1);
    Goomba testGomba = new Goomba(1, 1, 1, 1, 1);

    controller.addCharacter(testMarco);
    controller.addCharacter(testGomba);

    assertEquals(false, controller.enemiesWin());

    controller.getCurrentTurnCharacter().setHp(0);

    assertEquals(true, controller.enemiesWin());
  }

  @Test
  public void playersWinBattleTest() {
    Marco testMarco = new Marco(1, 1, 1, 1, 1, 1, 1);
    Goomba testGoomba = new Goomba(1, 1, 1, 1, 1);

    controller.addCharacter(testMarco);
    controller.addCharacter(testGoomba);

    assertEquals(false, controller.playersWinBattle());

    controller.getNextTurnCharacter().setHp(0);

    assertEquals(true, controller.playersWinBattle());
  }

  @Test
  public void playersWinGameTest() {
    controller.setRound(5);
    assertEquals(false, controller.playersWinGame());
    controller.setRound(6);
    assertEquals(true, controller.playersWinGame());
  }

  @Test
  public void getAttackableEnemiesTest() {
    Marco testMarco = new Marco(1, 1, 1, 1, 1, 1, 1);
    Luis testLuis = new Luis(1, 1, 1, 1, 1, 1, 1);
    Goomba testGoomba = new Goomba(1, 1, 1, 1, 1);
    Spiny testSpiny = new Spiny(1, 1, 1, 1, 1);
    Boo testBoo = new Boo(1, 1, 1, 1, 1);

    ArrayList<IEnemies> attackableEnemies = new ArrayList<>();

    controller.addCharacter(testMarco);
    controller.addCharacter(testLuis);
    controller.addCharacter(testGoomba);
    controller.addCharacter(testSpiny);
    controller.addCharacter(testBoo);

    attackableEnemies.add(testGoomba);
    attackableEnemies.add(testSpiny);
    attackableEnemies.add(testBoo);

    assertEquals(attackableEnemies, controller.getAttackableEnemies());
  }

  @Test
  public void getAttackableByLuisTest() {
    Marco testMarco = new Marco(1, 1, 1, 1, 1, 1, 1);
    Luis testLuis = new Luis(1, 1, 1, 1, 1, 1, 1);
    Goomba testGoomba = new Goomba(1, 1, 1, 1, 1);
    Spiny testSpiny = new Spiny(1, 1, 1, 1, 1);
    Boo testBoo = new Boo(1, 1, 1, 1, 1);

    ArrayList<IAttackableByLuis> attackableByLuis = new ArrayList<>();

    controller.addCharacter(testMarco);
    controller.addCharacter(testLuis);
    controller.addCharacter(testGoomba);
    controller.addCharacter(testSpiny);
    controller.addCharacter(testBoo);

    attackableByLuis.add(testGoomba);
    attackableByLuis.add(testSpiny);

    assertEquals(attackableByLuis, controller.getAttackableByLuis());
  }

  @Test
  public void getAttackablePlayersTest() {
    Marco testMarco = new Marco(1, 1, 1, 1, 1, 1, 1);
    Luis testLuis = new Luis(1, 1, 1, 1, 1, 1, 1);
    Goomba testGoomba = new Goomba(1, 1, 1, 1, 1);
    Spiny testSpiny = new Spiny(1, 1, 1, 1, 1);
    Boo testBoo = new Boo(1, 1, 1, 1, 1);

    ArrayList<IPlayers> attackablePlayers = new ArrayList<>();

    controller.addCharacter(testMarco);
    controller.addCharacter(testLuis);
    controller.addCharacter(testGoomba);
    controller.addCharacter(testSpiny);
    controller.addCharacter(testBoo);

    attackablePlayers.add(testMarco);
    attackablePlayers.add(testLuis);

    assertEquals(attackablePlayers, controller.getAttackablePlayers());
  }

  @Test
  public void getAttackableByBooTest() {
    Marco testMarco = new Marco(1, 1, 1, 1, 1, 1, 1);
    Luis testLuis = new Luis(1, 1, 1, 1, 1, 1, 1);
    Goomba testGoomba = new Goomba(1, 1, 1, 1, 1);
    Spiny testSpiny = new Spiny(1, 1, 1, 1, 1);
    Boo testBoo = new Boo(1, 1, 1, 1, 1);

    ArrayList<IAttackableByBoo> attackableByBoo = new ArrayList<>();

    controller.addCharacter(testMarco);
    controller.addCharacter(testLuis);
    controller.addCharacter(testGoomba);
    controller.addCharacter(testSpiny);
    controller.addCharacter(testBoo);

    attackableByBoo.add(testLuis);

    assertEquals(attackableByBoo, controller.getAttackableByBoo());
  }

  @Test
  public void controllerBattle1Test() {
    Marco testMarco = new Marco(1, 7, 7, 30, 15, 30, 30);
    Luis testLuis = new Luis(1, 7, 7, 30, 15, 30, 30);
    Goomba testGoomba = new Goomba(1, 5, 5, 10, 10);
    Spiny testSpiny = new Spiny(1, 5, 5, 10, 10);
    Boo testBoo = new Boo(1, 5, 5, 10, 10);

    controller.setRandSeed(1);

    controller.addCharacter(testMarco);
    controller.addCharacter(testLuis);
    controller.addCharacter(testGoomba);
    controller.addCharacter(testSpiny);
    controller.addCharacter(testBoo);

    int atk = 0;

    while (!controller.playersWinBattle() && !controller.enemiesWin()) {
      if (atk % 2 == 0) {
        controller.jumpAttackEnemy(testMarco, controller.getTargetMarco());
        if (controller.playersWinBattle()) break;
        if (!controller.getAttackableByLuis().isEmpty())
          controller.hammerAttackEnemy(testLuis, controller.getTargetLuis());
      } else {
        controller.hammerAttackEnemy(testMarco, controller.getTargetMarco());
        if (controller.playersWinBattle()) break;
        if (!controller.getAttackableByLuis().isEmpty())
          controller.jumpAttackEnemy(testLuis, controller.getTargetLuis());
      }
      if (controller.playersWinBattle()) break;
      controller.attackRandomPlayer(testGoomba);
      if (controller.enemiesWin()) break;
      controller.attackRandomPlayer(testSpiny);
      if (controller.enemiesWin()) break;
      if (testLuis.getHp() > 0) controller.attackRandomPlayer(testBoo);
      atk += 1;
    }

    assertEquals(false, controller.playersWinBattle());
    assertEquals(true, controller.enemiesWin());
  }

  @Test
  public void controllerBattle2Test() {
    Marco testMarco = new Marco(1, 20, 20, 30, 15, 30, 30);
    Luis testLuis = new Luis(1, 20, 20, 30, 15, 30, 30);
    Goomba testGoomba = new Goomba(1, 5, 5, 10, 10);
    Spiny testSpiny = new Spiny(1, 5, 5, 10, 10);
    Boo testBoo = new Boo(1, 5, 5, 10, 10);

    controller.setRandSeed(1);

    controller.addCharacter(testMarco);
    controller.addCharacter(testLuis);
    controller.addCharacter(testGoomba);
    controller.addCharacter(testSpiny);
    controller.addCharacter(testBoo);

    int atk = 0;

    while (!controller.playersWinBattle() && !controller.enemiesWin()) {
      if (atk % 2 == 0) {
        controller.jumpAttackEnemy(testMarco, controller.getTargetMarco());
        if (controller.playersWinBattle()) break;
        if (!controller.getAttackableByLuis().isEmpty())
          controller.hammerAttackEnemy(testLuis, controller.getTargetLuis());
      } else {
        controller.hammerAttackEnemy(testMarco, controller.getTargetMarco());
        if (controller.playersWinBattle()) break;
        if (!controller.getAttackableByLuis().isEmpty())
          controller.jumpAttackEnemy(testLuis, controller.getTargetLuis());
      }
      if (controller.playersWinBattle()) break;
      controller.attackRandomPlayer(testGoomba);
      if (controller.enemiesWin()) break;
      controller.attackRandomPlayer(testSpiny);
      if (controller.enemiesWin()) break;
      controller.attackRandomPlayer(testBoo);
      atk += 1;
    }

    assertEquals(true, controller.playersWinBattle());
    assertEquals(false, controller.enemiesWin());
  }
}
