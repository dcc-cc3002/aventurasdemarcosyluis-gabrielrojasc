import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import model.characters.enemy.Boo;
import model.characters.enemy.Goomba;
import model.characters.enemy.Spiny;
import model.characters.enemy.interfaces.IEnemies;
import model.characters.player.ItemVault;
import model.characters.player.Luis;
import model.characters.player.Marco;
import model.characters.player.interfaces.IPlayers;
import model.item.HoneySyrup;
import model.item.IItems;
import model.item.RedMushroom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestPlayer {
  private Marco testMarco;
  private Luis testLuis;

  @BeforeEach
  public void setUp() {
    testMarco = new Marco(10, 14, 3, 50, 30, 50, 50);
    testLuis = new Luis(12, 5, 4, 35, 6, 55, 18);
  }

  @Test
  public void constructorTest() {
    /* Can't create a new player if maxHp is less than 0 */
    Exception exception1 =
        assertThrows(
            IllegalArgumentException.class,
            () -> {
              IPlayers testExceptionMarco = new Marco(8, 5, 7, 10, 6, -5, 10);
            });
    String expectedMessage1 = "is not a valid maxHp";
    String actualMessage1 = exception1.getMessage();
    assertTrue(actualMessage1.contains(expectedMessage1));

    /* Can't create a new enemy if the hp is less than 0 */
    Exception exception2 =
        assertThrows(
            IllegalArgumentException.class,
            () -> {
              IPlayers testExceptionMarco = new Marco(8, 5, 7, -10, 6, 5, 18);
            });
    String expectedMessage2 = "is not a valid hp";
    String actualMessage2 = exception2.getMessage();
    assertTrue(actualMessage2.contains(expectedMessage2));

    /* Can't create a new enemy if the hp is greater than maxHp */
    Exception exception3 =
        assertThrows(
            IllegalArgumentException.class,
            () -> {
              IPlayers testExceptionMarco = new Marco(8, 5, 7, 10, 6, 5, 18);
            });
    String expectedMessage3 = "is not a valid hp";
    String actualMessage3 = exception3.getMessage();
    assertTrue(actualMessage3.contains(expectedMessage3));

    /* Can't create a new player if maxFp is less than 0 */
    Exception exception4 =
        assertThrows(
            IllegalArgumentException.class,
            () -> {
              IPlayers testExceptionMarco = new Marco(8, 5, 7, 10, 6, 50, -10);
            });
    String expectedMessage4 = "is not a valid maxFp";
    String actualMessage4 = exception4.getMessage();
    assertTrue(actualMessage4.contains(expectedMessage4));

    /* Can't create a new enemy if the fp is less than 0 */
    Exception exception5 =
        assertThrows(
            IllegalArgumentException.class,
            () -> {
              IPlayers testExceptionMarco = new Marco(8, 5, 7, 10, -6, 50, 10);
            });
    String expectedMessage5 = "is not a valid fp";
    String actualMessage5 = exception5.getMessage();
    assertTrue(actualMessage5.contains(expectedMessage5));

    /* Can't create a new enemy if the fp is greater than maxFp */
    Exception exception6 =
        assertThrows(
            IllegalArgumentException.class,
            () -> {
              IPlayers testExceptionMarco = new Marco(8, 5, 7, 10, 60, 50, 10);
            });
    String expectedMessage6 = "is not a valid fp";
    String actualMessage6 = exception6.getMessage();
    assertTrue(actualMessage6.contains(expectedMessage6));
  }

  @Test
  public void lvlGetterTest() {
    assertEquals(10, testMarco.getLvl());
    assertEquals(12, testLuis.getLvl());
  }

  @Test
  public void lvlSetterTest() {
    testMarco.setLvl(9);
    assertEquals(9, testMarco.getLvl());
    testLuis.setLvl(15);
    assertEquals(15, testLuis.getLvl());
  }

  @Test
  public void atkGetterTest() {
    assertEquals(14, testMarco.getAtk());
    assertEquals(5, testLuis.getAtk());

    testMarco.setHp(0);
    testLuis.setHp(0);

    assertEquals(0, testMarco.getAtk());
    assertEquals(0, testLuis.getAtk());
  }

  @Test
  public void atkSetterTest() {
    testMarco.setAtk(10);
    assertEquals(10, testMarco.getAtk());
    testLuis.setAtk(7);
    assertEquals(7, testLuis.getAtk());
  }

  @Test
  public void defGetterTest() {
    assertEquals(3, testMarco.getDef());
    assertEquals(4, testLuis.getDef());
  }

  @Test
  public void defSetterTest() {
    testMarco.setDef(9);
    assertEquals(9, testMarco.getDef());
    testLuis.setDef(6);
    assertEquals(6, testLuis.getDef());
  }

  @Test
  public void hpGetterTest() {
    assertEquals(50, testMarco.getHp());
    assertEquals(35, testLuis.getHp());
  }

  @Test
  public void hpSetterTest() {
    testMarco.setHp(20);
    assertEquals(20, testMarco.getHp());
    testLuis.setHp(12);
    assertEquals(12, testLuis.getHp());

    Exception exception1 = assertThrows(IllegalArgumentException.class, () -> testMarco.setHp(-10));
    String expectedMessage1 = "is not a valid hp";
    String actualMessage1 = exception1.getMessage();
    assertTrue(actualMessage1.contains(expectedMessage1));

    Exception exception2 = assertThrows(IllegalArgumentException.class, () -> testMarco.setHp(100));
    String expectedMessage2 = "is not a valid hp";
    String actualMessage2 = exception2.getMessage();
    assertTrue(actualMessage2.contains(expectedMessage2));
  }

  @Test
  public void fpGetterTest() {
    assertEquals(30, testMarco.getFp());
    assertEquals(6, testLuis.getFp());

    Exception exception1 = assertThrows(IllegalArgumentException.class, () -> testMarco.setFp(-10));
    String expectedMessage1 = "is not a valid fp";
    String actualMessage1 = exception1.getMessage();
    assertTrue(actualMessage1.contains(expectedMessage1));

    Exception exception2 = assertThrows(IllegalArgumentException.class, () -> testMarco.setFp(100));
    String expectedMessage2 = "is not a valid fp";
    String actualMessage2 = exception2.getMessage();
    assertTrue(actualMessage2.contains(expectedMessage2));
  }

  @Test
  public void fpSetterTest() {
    testMarco.setFp(21);
    assertEquals(21, testMarco.getFp());
    testLuis.setFp(9);
    assertEquals(9, testLuis.getFp());
  }

  @Test
  public void maxHpGetterTest() {
    assertEquals(50, testMarco.getMaxHp());
    assertEquals(55, testLuis.getMaxHp());
  }

  @Test
  public void isKOTest() {
    assertFalse(testMarco.isKO());
    assertFalse(testLuis.isKO());
    testMarco.setHp(0);
    testLuis.setHp(0);
    assertTrue(testMarco.isKO());
    assertTrue(testLuis.isKO());
  }

  @Test
  public void getItemTest() {
    ArrayList<IItems> items = new ArrayList<>();
    ItemVault vault = new ItemVault();
    assertEquals(items, vault.getItems());
  }

  @Test
  public void addItemTest() {
    ItemVault vault = new ItemVault();
    IItems redMushroom = new RedMushroom();
    IItems honeySyrup = new HoneySyrup();
    ArrayList<IItems> items = new ArrayList<>();

    vault.addItem(redMushroom);
    items.add(redMushroom);

    assertEquals(items, vault.getItems());

    vault.addItem(honeySyrup);
    items.add(honeySyrup);

    assertEquals(items, vault.getItems());
  }

  @Test
  public void useItemTest() {
    ItemVault vault = new ItemVault();
    IItems honeySyrup = new HoneySyrup();
    ArrayList<IItems> items = new ArrayList<>();

    vault.addItem(honeySyrup);
    items.add(honeySyrup);
    assertEquals(items, vault.getItems());

    int beforeFp = testMarco.getFp();
    testMarco.useItem(honeySyrup, vault);
    int afterFp = beforeFp + 3;
    assertEquals(afterFp, testMarco.getFp());
    items.remove(honeySyrup);

    assertEquals(items, vault.getItems());
  }

  @Test
  public void setRandSeedTest() {
    Goomba testGoomba1 = new Goomba(10, 50, 50, 100, 100);
    testMarco.setRandSeed(2);

    testMarco.hammerAttack(testGoomba1);
    assertEquals(100, testGoomba1.getHp());
    testMarco.hammerAttack(testGoomba1);
    assertEquals(100, testGoomba1.getHp());
    testMarco.hammerAttack(testGoomba1);
    assertEquals(100, testGoomba1.getHp());
    testMarco.hammerAttack(testGoomba1);
    assertEquals(96, testGoomba1.getHp());
  }

  @Test
  public void receiveDmgTest() {
    int dmg = 10;
    int expectedMarcoHp = testMarco.getHp() - dmg;
    testMarco.receiveDmg(dmg);

    assertEquals(expectedMarcoHp, testMarco.getHp());
  }

  @Test
  public void getJumpDmgTest() {
    IEnemies testGoomba = new Goomba(1, 5, 5, 10, 10);
    int expectedJumpDmg =
        Math.round(testMarco.getAtk() * ((float) testMarco.getLvl() / (float) testGoomba.getDef()));

    assertEquals(expectedJumpDmg, testMarco.getJumpDmg(testGoomba));
  }

  @Test
  public void getHammerDmgTest() {
    IEnemies testGoomba = new Goomba(1, 5, 5, 10, 10);
    int expectedHammerDmg =
        Math.round(
            (float) 1.5
                * testMarco.getAtk()
                * ((float) testMarco.getLvl() / (float) testGoomba.getDef()));

    assertEquals(expectedHammerDmg, testMarco.getHammerDmg(testGoomba));
  }

  @Test
  public void jumpAttackEnemyTest() {
    Goomba testGoomba1 = new Goomba(1, 5, 5, 10, 10);
    Goomba testGoomba2 = new Goomba(10, 50, 50, 100, 100);
    Spiny testSpiny = new Spiny(10, 50, 50, 100, 100);
    Boo testBoo = new Boo(10, 50, 50, 100, 100);

    int expectedGoomba1Hp = Math.max(0, testGoomba1.getHp() - testMarco.getJumpDmg(testGoomba1));
    testMarco.jumpAttack(testGoomba1);
    assertEquals(expectedGoomba1Hp, testGoomba1.getHp());

    int expectedGoomba2Hp = Math.max(0, testGoomba2.getHp() - testLuis.getJumpDmg(testGoomba2));
    testLuis.jumpAttack(testGoomba2);
    assertEquals(expectedGoomba2Hp, testGoomba2.getHp());

    int expectedSpinyHp = testSpiny.getHp();
    int expectedMarcoHp = testMarco.getHp() - Math.round(testMarco.getHp() * (float) 0.05);
    testMarco.jumpAttack(testSpiny);
    assertEquals(expectedSpinyHp, testSpiny.getHp());
    assertEquals(expectedMarcoHp, testMarco.getHp());

    int expectedBooHp = testBoo.getHp() - testMarco.getJumpDmg(testBoo);
    testMarco.jumpAttack(testBoo);
    assertEquals(expectedBooHp, testBoo.getHp());
  }

  @Test
  public void hammerAttackEnemyTest() {
    Goomba testGoomba1 = new Goomba(1, 5, 5, 10, 10);
    Goomba testGoomba2 = new Goomba(10, 50, 50, 100, 100);
    Boo testBoo = new Boo(1, 5, 5, 10, 10);

    testMarco.setRandSeed(1);
    testLuis.setRandSeed(1);

    int expectedGoomba1Hp = testGoomba1.getHp(); // not hit
    testMarco.hammerAttack(testGoomba1);
    assertEquals(expectedGoomba1Hp, testGoomba1.getHp());

    int expectedGoomba2Hp = testGoomba2.getHp(); // not hit
    testLuis.hammerAttack(testGoomba2);
    assertEquals(expectedGoomba2Hp, testGoomba2.getHp());

    int expectedGoomba3Hp =
        Math.max(0, testGoomba2.getHp() - testMarco.getHammerDmg(testGoomba2)); // hit
    testMarco.hammerAttack(testGoomba2);
    assertEquals(expectedGoomba3Hp, testGoomba2.getHp());

    int expectedGoomba4Hp =
        Math.max(0, testGoomba2.getHp() - testLuis.getHammerDmg(testGoomba2)); // hit
    testLuis.hammerAttack(testGoomba2);
    assertEquals(expectedGoomba4Hp, testGoomba2.getHp());

    int expectedBooHp = testBoo.getHp();
    testMarco.hammerAttack(testBoo);
    assertEquals(expectedBooHp, testBoo.getHp());
  }

  @Test
  public void attackedByGoombaTest() {
    Goomba testGoomba = new Goomba(10, 5, 5, 10, 10);

    int expectedMarcoHp = testMarco.getHp() - testGoomba.getDmg(testMarco);

    testMarco.attackedByEnemy(testGoomba);

    assertEquals(expectedMarcoHp, testMarco.getHp());
  }

  @Test
  public void attackedBySpinyTest() {
    Spiny testSpiny = new Spiny(10, 5, 5, 10, 10);

    int expectedMarcoHp = testMarco.getHp() - testSpiny.getDmg(testMarco);

    testMarco.attackedByEnemy(testSpiny);

    assertEquals(expectedMarcoHp, testMarco.getHp());
  }

  @Test
  public void attackedByBooTest() {
    Boo testBoo = new Boo(10, 5, 5, 10, 10);

    int expectedLuisHp = testLuis.getHp() - testBoo.getDmg(testLuis);

    testLuis.attackedByEnemy(testBoo);

    assertEquals(expectedLuisHp, testLuis.getHp());
  }

  @Test
  public void levelUpTest() {
    testMarco.setHp(1);
    testMarco.setFp(1);
    int newLvl = testMarco.getLvl() + 1;
    int newAtk = Math.round(testMarco.getAtk() + (float) 0.15 * testMarco.getAtk());
    int newDef = Math.round(testMarco.getDef() + (float) 0.15 * testMarco.getDef());
    int newHp =
        Math.min(
            testMarco.getMaxHp(),
            testMarco.getHp() + Math.round((float) 0.15 * testMarco.getMaxHp()));
    int newFp =
        Math.min(
            testMarco.getMaxFp(),
            testMarco.getFp() + Math.round((float) 0.15 * testMarco.getMaxFp()));

    testMarco.levelUp();

    assertEquals(newLvl, testMarco.getLvl());
    assertEquals(newAtk, testMarco.getAtk());
    assertEquals(newDef, testMarco.getDef());
    assertEquals(newHp, testMarco.getHp());
    assertEquals(newFp, testMarco.getFp());
  }
}
